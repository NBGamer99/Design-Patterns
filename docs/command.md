<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/command.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Command</h1>
</div>

<br />


## Intent

**Command** is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

## Implementation

1. Declare the command interface with a single execution method.

2. Start extracting requests into concrete command classes that implement the command interface. Each class must have a set of fields for storing the request arguments along with a reference to the actual receiver object. All these values must be initialized via the command’s constructor.

3. Identify classes that will act as senders. Add the fields for storing commands into these classes. Senders should communicate with their commands only via the command interface. Senders usually don’t create command objects on their own, but rather get them from the client code.

4. Change the senders so they execute the command instead of sending a request to the receiver directly.

5. The client should initialize objects in the following order:
- Create receivers.
- Create commands, and associate them with receivers if needed.
- Create senders, and associate them with specific commands.

## Structure

<p align="center">
	<img src="../assets/imgs/structures/command.png" alt="Command Structure" width="400px">
</p>

## Pseudocode


In this example, the **Command** pattern helps to track the history of executed operations and makes it possible to revert an operation if needed.

<p align="center">
	<img src="../assets/imgs/pseudo-code/command.png" alt="Command Structure" width="400px">
</p>

Commands which result in changing the state of the editor (e.g., cutting and pasting) make a backup copy of the editor’s state before executing an operation associated with the command. After a command is executed, it’s placed into the command history (a stack of command objects) along with the backup copy of the editor’s state at that point. Later, if the user needs to revert an operation, the app can take the most recent command from the history, read the associated backup of the editor’s state, and restore it.

The client code (GUI elements, command history, etc.) isn’t coupled to concrete command classes because it works with commands via the command interface. This approach lets you introduce new commands into the app without breaking any existing code.

```java
// The base command class defines the common interface for all
// concrete commands.
abstract class Command {
    protected Application app;
    protected Editor editor;
    protected String backup;

    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    // Make a backup of the editor's state.
    public void saveBackup() {
        backup = editor.text;
    }

    // Restore the editor's state.
    public void undo() {
        editor.text = backup;
    }

    // The execution method is declared abstract to force all
    // concrete commands to provide their own implementations.
    // The method must return true or false depending on whether
    // the command changes the editor's state.
    public abstract boolean execute();
}

// The concrete commands go here.
class CopyCommand extends Command {
    // The copy command isn't saved to the history since it
    // doesn't change the editor's state.
    public boolean execute() {
        app.clipboard = editor.getSelection();
        return false;
    }
}

class CutCommand extends Command {
    // The cut command does change the editor's state, therefore
    // it must be saved to the history. And it'll be saved as
    // long as the method returns true.
    public boolean execute() {
        saveBackup();
        app.clipboard = editor.getSelection();
        editor.deleteSelection();
        return true;
    }
}

class PasteCommand extends Command {
    public boolean execute() {
        saveBackup();
        editor.replaceSelection(app.clipboard);
        return true;
    }
}

// The undo operation is also a command.
class UndoCommand extends Command {
    public boolean execute() {
        app.undo();
        return false;
    }
}

// The global command history is just a stack.
class CommandHistory {
    private Stack<Command> history = new Stack<>();

    // Last in...
    public void push(Command c) {
        history.push(c);
    }

    // ...first out
    public Command pop() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}

// The editor class has actual text editing operations. It plays
// the role of a receiver: all commands end up delegating
// execution to the editor's methods.
class Editor {
    String text;

    public String getSelection() {
        // Return selected text.
    }

    public void deleteSelection() {
        // Delete selected text.
    }

    public void replaceSelection(String text) {
        // Insert the clipboard's contents at the current position.
    }
}

// The application class sets up object relations. It acts as a
// sender: when something needs to be done, it creates a command
// object and executes it.
class Application {
    String clipboard;
    Editor[] editors;
    Editor activeEditor;
    CommandHistory history = new CommandHistory();

    // The code which assigns commands to UI objects may look
    // like this.
    public void createUI() {
        // ...
        Command copy = new CopyCommand(this, activeEditor);
        copyButton.setCommand(copy);
        shortcuts.onKeyPress("Ctrl+C", copy);

        Command cut = new CutCommand(this, activeEditor);
        cutButton.setCommand(cut);
        shortcuts.onKeyPress("Ctrl+X", cut);

        Command paste = new PasteCommand(this, activeEditor);
        pasteButton.setCommand(paste);
        shortcuts.onKeyPress("Ctrl+V", paste);

        Command undo = new UndoCommand(this, activeEditor);
        undoButton.setCommand(undo);
        shortcuts.onKeyPress("Ctrl+Z", undo);
    }

    // Execute a command and check whether it has to be added to
    // the history.
    public void executeCommand(Command command) {
        if (command.execute()) {
            history.push(command);
        }
    }

    // Take the most recent command from the history and run its
    // undo method. Note that we don't know the class of that
    // command. But we don't have to, since the command knows
    // how to undo its own action.
    public void undo() {
        Command command = history.pop();
        if (command != null) {
            command.undo();
        }
    }
}


```