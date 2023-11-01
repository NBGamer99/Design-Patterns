<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/prototype.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Prototype</h1>
</div>

<br />

## Intent
Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.

A prototype is like a special kind of model that you can copy to create new things that are exactly like it. It's like making multiple copies of your favorite toy.

Imagine you have a beautiful and unique snowflake ornament that you want to use to decorate your Christmas tree. You want more ornaments that look just like this one. Instead of making each ornament from scratch, you take your unique snowflake to a special machine **(the prototype)** that can duplicate it perfectly. Now you have many snowflakes that are identical to your original one.

## Implementation
The Prototype pattern delegates the cloning process to the actual objects that are being cloned. The pattern declares a common interface for all objects that support cloning. This interface lets you clone an object without coupling your code to the class of that object. Usually, such an interface contains just a single clone method.

The Prototype design pattern is used to create new objects by copying an existing object, known as a prototype. The prototype serves as a blueprint for creating new instances.

## Structure

<p align="center">
    <img src="../assets/imgs/structures/prototype.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

```java
    // The prototype interface
    interface Prototype {
        // This method creates a copy of the object
        Prototype clone();
    }

    // Concrete implementations of the prototype
    class ConcretePrototype implements Prototype {
        private String name;

        public ConcretePrototype(String name) {
            this.name = name;
        }

        public Prototype clone() {
            return new ConcretePrototype(this.name);
        }

        public String getName() {
            return this.name;
        }
    }
```

Now, you can use the prototype to create new objects:

```java
    public class Main {
        public static void main(String[] args) {
            Prototype original = new ConcretePrototype("Original Snowflake");
            Prototype copy1 = original.clone();
            Prototype copy2 = original.clone();

            System.out.println("Original: " + original.getName());
            System.out.println("Copy 1: " + copy1.getName());
            System.out.println("Copy 2: " + copy2.getName());
        }
    }
```

In this example, the `ConcretePrototype` class implements the Prototype interface. The clone method creates a new instance of the object with the same properties. You can use the prototype to create copies (or `clones`) of the original object.

Just like in the real-life example, you can create multiple snowflakes that are identical to the original one by using the prototype.