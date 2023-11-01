<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/singleton.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Singleton</h1>
</div>

<br />

## Intent
Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

Think of a Singleton as a special kind of object that can only exist once. It's like having a unique, one-of-a-kind key for your house. No matter how many times you go in and out of your house, there's only one key for that house.

Imagine you have a big, magical book that contains all the secrets of your favorite video game. You don't want everyone to have their own copy of this book because it's precious and should be kept safe. So, you create a rule that says only one person can have the book at a time. If someone wants to read it, they have to ask the person who's already reading it to share it. This way, you make sure the book is always protected and not duplicated.

## Implementation
There are two things you need to do to implement the Singleton pattern:

1. Make the default constructor private, to prevent other objects from using the new operator with the Singleton class.
2. Create a static creation method that acts as a constructor. Under the hood, this method calls the private constructor to create an object and saves it in a static field. All following calls to this method return the cached object.

If your code has access to the Singleton class, then it's able to call the Singleton's static method. So whenever that method is called, the same object is always returned.

## Structure

<p align="center">
    <img src="../assets/imgs/structures/singleton.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

```java
    public class Singleton {
        // The unique instance of the class
        private static Singleton instance;
    
        // Private constructor to prevent creating multiple instances
        private Singleton() {
        }
    
        // A method to access the single instance, and create it if it doesn't exist
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
```

Now, if you want to use the `Singleton` in your code, you can do this:

```java
  public class Main {
      public static void main(String[] args) {
          Singleton uniqueInstance = Singleton.getInstance();
          // Now you have the one and only instance of Singleton
      }
  }
```

So, in Java, the `Singleton` class ensures that there's only one instance of itself, and you can access that instance using the `getInstance` method. This is similar to the real-life example where you have one unique book that everyone shares.