<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/facade.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Facade</h1>
</div>

<br />

## Intent

**Facade** is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

Imagine you have a big, complicated machine with lots of buttons, switches, and levers. Using this machine directly is very confusing because you have to know which button does what, and it's easy to make mistakes.

Now, think of a Facade as a friendly and easy-to-use control panel that simplifies your interaction with the machine. This control panel has just a few buttons, each clearly labeled with what it does. When you press a button on the control panel, it takes care of all the complex operations on the machine for you.

## Implementation



1. Check whether it’s possible to provide a simpler interface than what an existing subsystem already provides. You’re on the right track if this interface makes the client code independent from many of the subsystem’s classes.

2. Declare and implement this interface in a new facade class. The facade should redirect the calls from the client code to appropriate objects of the subsystem. The facade should be responsible for initializing the subsystem and **managing** its further life cycle unless the client code already does this.

3. To get the full benefit from the pattern, make all the client code communicate with the subsystem only via the facade. Now the client code is protected from any changes in the subsystem code. For example, when a subsystem gets upgraded to a new version, you will only need to modify the code in the facade.

4. If the facade becomes too big, consider extracting part of its behavior to a new, refined facade class.


## Structure

<p align="center">
    <img src="../assets/imgs/structures/facade.png" alt="Singleton Structure" width="400px">
</p>

## Pseudocode

In this **example**, the Facade pattern simplifies interaction with a complex video conversion framework.

```java
// Complex subsystem classes
class Computer {
    public void turnOn() {
        System.out.println("Computer is turning on");
    }

    public void turnOff() {
        System.out.println("Computer is turning off");
    }
}

class StereoSystem {
    public void turnOn() {
        System.out.println("Stereo system is turning on");
    }

    public void turnOff() {
        System.out.println("Stereo system is turning off");
    }
}

class Projector {
    public void turnOn() {
        System.out.println("Projector is turning on");
    }

    public void turnOff() {
        System.out.println("Projector is turning off");
    }
}

// Facade class
class HomeTheaterFacade {
    private Computer computer;
    private StereoSystem stereo;
    private Projector projector;

    public HomeTheaterFacade(Computer computer, StereoSystem stereo, Projector projector) {
        this.computer = computer;
        this.stereo = stereo;
        this.projector = projector;
    }

    public void watchMovie() {
        System.out.println("Get ready to watch a movie!");
        computer.turnOn();
        stereo.turnOn();
        projector.turnOn();
    }

    public void endMovie() {
        System.out.println("Movie night is over.");
        computer.turnOff();
        stereo.turnOff();
        projector.turnOff();
    }
}
```

In this simple Java example, we're using the Facade design pattern to make movie nights at home easier. We have complex subsystems like a computer, a stereo system, and a projector, each with their own on and off functions. To simplify the process of setting up a home theater for a movie night, we create a `HomeTheaterFacade` class. This facade provides easy-to-use methods like `watchMovie()` and `endMovie()`, which internally handle turning on and off the individual devices.

So, when someone wants to watch a movie, they can call `homeTheater.watchMovie()`, and the facade takes care of the details, turning on the computer, stereo system, and projector. When the movie night is over, they call `homeTheater.endMovie()`, and the facade handles turning everything off. This makes the experience much more straightforward for the user, as they don't need to worry about the complexities of each device – they just interact with the simple control provided by the facade.