<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/factory.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Factory</h1>
</div>

<br />

## Intent
Factory Method is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

A factory is like a special machine that makes specific things. You don't need to know how it's made; you just press a button and get what you want.

Imagine you go to a pizza restaurant. You don't need to know how to make a pizza from scratch. Instead, you tell the chef the kind of pizza you want, like `margarita` or `pepperoni`, and the chef uses a pizza-making machine **(the factory)** to prepare it for you. This way, you get the pizza you want without having to make it yourself.

## Implementation
The Factory Method pattern suggests that you replace direct object construction calls (using the `new` operator) with calls to a special factory method. Don’t worry: the objects are still created via the `new` operator, but it’s being called from within the `factory method`. Objects returned by a `factory method` are often referred to as products.

The Factory design pattern is a way to create objects without specifying the exact class of object that will be created. It uses a factory method to create objects of different types based on a common interface or superclass.

## Structure

<p align="center">
    <img src="../assets/imgs/structures/factory.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

```java
      // The product interface (common interface for objects)
    interface Product {
        void create();
    }

    // Concrete implementations of the product interface
    class ConcreteProductA implements Product {
        public void create() {
            System.out.println("Creating Product A");
        }
    }

    class ConcreteProductB implements Product {
        public void create() {
            System.out.println("Creating Product B");
        }
    }

    // The factory class
    class ProductFactory {
        public Product createProduct(String productType) {
            if ("A".equals(productType)) {
                return new ConcreteProductA();
            } else if ("B".equals(productType)) {
                return new ConcreteProductB();
            }
            return null;
        }
    }
```

Now, if you want to create a product using the factory, you can do this:

```java
    public class Main {
      public static void main(String[] args) {
          ProductFactory factory = new ProductFactory();
          
          Product productA = factory.createProduct("A");
          productA.create(); // Output: Creating Product A
          
          Product productB = factory.createProduct("B");
          productB.create(); // Output: Creating Product B
      }
  }
```

In this example, the ProductFactory uses a factory method to create different types of products (Product A and Product B) without needing to know the exact details of how they are created. This is similar to ordering a pizza at a restaurant without having to make it yourself; you just tell the chef what you want, and the factory (chef) prepares it for you.
