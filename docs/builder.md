<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/builder.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Builder</h1>
</div>

<br />

## Intent
Builder is a creational design pattern that lets you construct complex objects step by step. The pattern allows you to produce different types and representations of an object using the same construction code.

A builder is like a specialized chef who prepares a meal with different ingredients, and you can tell them exactly what you want in your meal. It's like customizing your own sandwich with your favorite ingredients.

Imagine you're at a sandwich shop, and you want a sandwich that's just the way you like it. Instead of choosing a pre-made sandwich, you work with a sandwich builder. You tell the builder which bread, meat, cheese, vegetables, and condiments you want. The builder assembles your sandwich with your chosen ingredients. This way, you get a personalized sandwich made to order.

## Implementation
The Builder pattern suggests that you extract the object construction code out of its own class and move it to separate objects called builders.

The pattern organizes object construction into a set of steps (`getBread`, `getMeat`, etc.). To create an object, you execute a series of these steps on a builder object. The important part is that you don’t need to call all of the steps. You can call only those steps that are necessary for producing a particular configuration of an object.

## Structure

<p align="center">
    <img src="../assets/imgs/structures/builder.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

```java
    // The product class that you want to build
    class Sandwich {
        private String bread;
        private String meat;
        private String cheese;
        // .....

        public Sandwich(String bread, String meat, String cheese) {
            this.bread = bread;
            this.meat = meat;
            this.cheese = cheese;
        }

        // Methods to get the parts of the sandwich
        public String getBread() {
            return bread;
        }
        // ....
    }
```

The builder class for creating sandwiches


```java
    class SandwichBuilder {
        private String bread;
        private String meat;
        private String cheese;
        // .....

        public SandwichBuilder() {
        }

        public SandwichBuilder withBread(String bread) {
            this.bread = bread;
            return this;
        }

        // ....

        public Sandwich build() {
            return new Sandwich(bread, meat, cheese);
        }
    }
```
Now, you can use the builder to create a customized sandwich:

```java
  public class Main {
    public static void main(String[] args) {
        Sandwich sandwich = new SandwichBuilder()
            .withBread("Whole wheat")
            .withMeat("Turkey")
            .withCheese("Swiss")
            .build();
    }
}
```

In this example, the SandwichBuilder class allows you to customize a sandwich by specifying the type of bread, meat, cheese, vegetables, and condiments. Then, it constructs the sandwich based on your preferences. This is similar to working with a sandwich builder to create a personalized sandwich with your favorite ingredients.
