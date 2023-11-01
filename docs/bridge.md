<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/bridge.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Bridge</h1>
</div>

<br />

## Intent
Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.

A bridge is like a connection that allows you to combine different things to work together, even if they are quite different from each other. It's like building a bridge to connect two islands so people and things can travel between them.

Imagine two remote-controlled toy cars from different manufacturers. Each car has its own unique remote control. To make things easier, you build a special bridge device that connects to both remotes. Now, you can control both toy cars using a single remote. The bridge makes it possible for two different systems to work together seamlessly.

## Implementation
The Bridge pattern switch from inheritance to the object composition. What this means is that you extract one of the dimensions into a separate class hierarchy, so that the original classes will reference an object of the new hierarchy, instead of having all of its state and behaviors within one class.


## Structure

<p align="center">
    <img src="../assets/imgs/structures/bridge.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

The abstraction interface

```java
    interface RemoteControl {
        void turnOn();
        void turnOff();
    }

    // Concrete implementations of the abstraction
    class TVRemoteControl implements RemoteControl {
        public void turnOn() {
            System.out.println("TV is turned on.");
        }

        public void turnOff() {
            System.out.println("TV is turned off.");
        }
    }

    class RadioRemoteControl implements RemoteControl {
        public void turnOn() {
            System.out.println("Radio is turned on.");
        }

        public void turnOff() {
            System.out.println("Radio is turned off.");
        }
    }
```

The implementation interface

```java
    interface Device {
        void powerOn();
        void powerOff();
    }

    // Concrete implementations of the implementation
    class TV implements Device {
        public void powerOn() {
            System.out.println("TV power is on.");
        }

        public void powerOff() {
            System.out.println("TV power is off.");
        }
    }

    class Radio implements Device {
        public void powerOn() {
            System.out.println("Radio power is on.");
        }

        public void powerOff() {
            System.out.println("Radio power is off.");
        }
    }
```

The bridge that connects the abstraction and implementation

```java
    class RemoteControlBridge {
        private RemoteControl remoteControl;
        private Device device;

        public RemoteControlBridge(RemoteControl remoteControl, Device device) {
            this.remoteControl = remoteControl;
            this.device = device;
        }

        public void powerOn() {
            remoteControl.turnOn();
            device.powerOn();
        }

        public void powerOff() {
            remoteControl.turnOff();
            device.powerOff();
        }
    }
```

Now, you can use the bridge to control devices through a remote control:

```java
    public class Main {
        public static void main(String[] args) {
            RemoteControl tvRemote = new TVRemoteControl();
            Device tv = new TV();
            RemoteControlBridge tvBridge = new RemoteControlBridge(tvRemote, tv);

            RemoteControl radioRemote = new RadioRemoteControl();
            Device radio = new Radio();
            RemoteControlBridge radioBridge = new RemoteControlBridge(radioRemote, radio);

            tvBridge.powerOn();
            tvBridge.powerOff();

            radioBridge.powerOn();
            radioBridge.powerOff();
        }
    }
```

In this example, the RemoteControl hierarchy represents different types of remote controls, and the Device hierarchy represents different types of devices. The RemoteControlBridge connects a specific remote control with a specific device, allowing you to control them together.

Just like in the real-life example, the bridge enables you to control two different things (remote controls and devices) using a single interface (bridge).