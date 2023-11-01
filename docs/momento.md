<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/memento.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Momento</h1>
</div>

<br />


## Intent

**Memento** is a behavioral design pattern that lets you save and restore the previous state of an object without revealing the details of its implementation.

## Implementation

The implementation of the Memento pattern typically involves three key components:

- **Originator**: The originator is the object whose state needs to be saved. It provides methods for saving and restoring its state, often by creating a Memento object that encapsulates the state.

- **Memento**: The Memento is an object that represents a snapshot of the originator's state at a specific point in time. It is responsible for storing the state but does not expose it directly. Instead, it provides methods for setting and getting the state, ensuring that the originator's internal state remains encapsulated.

- **Caretaker**: The Caretaker is responsible for managing the Memento objects. It typically keeps a stack or collection of Mementos and requests the originator to save or restore its state using these Mementos. This allows the Caretaker to implement operations like undo, redo, or managing a history of states.

The **Memento** pattern promotes encapsulation and separation of concerns by preventing direct access to the originator's internal state. It provides a clean and structured way to implement features like undo/redo functionality in applications. The pattern is widely used in various software systems, including text editors, version control systems, and applications with complex state management requirements.

## Structure

**Implementation based on nested classes**

The classic implementation of the pattern relies on support for nested classes, available in many popular programming languages (such as C++, C#, and Java).


<p align="center">
    <img src="../assets/imgs/structures/momento.png" alt="Singleton Structure" width="400px">
</p>

**Implementation based on an intermediate interface**

There’s an alternative implementation, suitable for programming languages that don’t support nested classes (yeah, PHP, I’m talking about you).


<p align="center">
    <img src="../assets/imgs/structures/momento2.png" alt="Singleton Structure" width="400px">
</p>

**Implementation with even stricter encapsulation**

<p align="center">
    <img src="../assets/imgs/structures/momento3.png" alt="Singleton Structure" width="400px">
</p>


## Pseudocode

```java

// Originator
class TextEditor {
    private String text;

    public TextEditor() {
        text = "";
    }

    public void addText(String input) {
        text += input;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(text);
    }

    public void restore(TextEditorMemento memento) {
        text = memento.getState();
    }
}

// Memento
class TextEditorMemento {
    private String state;

    public TextEditorMemento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.addText("Hello, ");
        TextEditorMemento memento = editor.save(); // Save the state

        editor.addText("World!");
        System.out.println(editor.getText()); // Output: "Hello, World!"

        editor.restore(memento); // Restore the previous state
        System.out.println(editor.getText()); // Output: "Hello, "
    }
}


```

This Java pseudo-code demonstrates the Memento design pattern, which allows for capturing and restoring the state of an object. In this example, the `TextEditor` class serves as the originator, maintaining a text field and providing methods to add text, save its state using a `TextEditorMemento`, and restore the state from a memento. The `TextEditorMemento` class encapsulates the state. The client code illustrates how to use these classes to save and restore the state of the text editor, effectively enabling undo and redo functionality. This pattern is valuable for managing the history of an object's state in various applications, such as text editors and document processors.