<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/decorator.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Decorator</h1>
</div>

<br />

## Intent
Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

A decorator is like adding layers or decorations to something to make it more interesting or functional. It's like putting different toppings on your ice cream to make it tastier.

Think about decorating a cake. You have a plain cake, and you want to make it extra special. You add layers of frosting, some colorful sprinkles, and maybe a cherry on top. These decorations don't change the fact that it's still a cake, but they enhance its appearance and flavor. The more layers of decorations you add, the fancier and more delicious the cake becomes.

## Implementation
Extending a class is the first thing that comes to mind when you need to alter an object’s behavior. However, inheritance has several serious caveats that you need to be aware of.

With this new approach you can easily substitute the linked `helper` object with another, changing the behavior of the container at runtime. An object can use the behavior of various classes, having references to multiple objects and delegating them all kinds of work. Aggregation/composition is the key principle behind many design patterns, including Decorator. On that note, let’s return to the pattern discussion.

## Structure

<p align="center">
    <img src="../assets/imgs/structures/decorator.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

```java
    // The interface representing the base object
    interface IceCream {
        String makeIceCream();
    }

    // The concrete implementation of the base object
    class BasicIceCream implements IceCream {
        public String makeIceCream() {
            return "Basic Ice Cream";
        }
    }

    // The decorator class that adds extra functionality
    class IceCreamDecorator implements IceCream {
        protected IceCream iceCream;

        public IceCreamDecorator(IceCream iceCream) {
            this.iceCream = iceCream;
        }

        public String makeIceCream() {
            return iceCream.makeIceCream();
        }
    }
```

```java
    // Concrete decorator classes that add specific toppings
    class ChocolateTopping extends IceCreamDecorator {
        public ChocolateTopping(IceCream iceCream) {
            super(iceCream);
        }

        public String makeIceCream() {
            return super.makeIceCream() + " with Chocolate Topping";
        }
    }

    class SprinklesTopping extends IceCreamDecorator {
        public SprinklesTopping(IceCream iceCream) {
            super(iceCream);
        }

        public String makeIceCream() {
            return super.makeIceCream() + " with Sprinkles";
        }
    }
```

Now, you can use the decorator to add toppings to your ice cream:


```java
    public class Main {
        public static void main(String[] args) {
            IceCream basicIceCream = new BasicIceCream();
            System.out.println("Plain: " + basicIceCream.makeIceCream());

            IceCream chocolateIceCream = new ChocolateTopping(basicIceCream);
            System.out.println("With Chocolate Topping: " + chocolateIceCream.makeIceCream());

            IceCream fancyIceCream = new SprinklesTopping(new ChocolateTopping(basicIceCream));
            System.out.println("With Chocolate Topping and Sprinkles: " + fancyIceCream.makeIceCream());
        }
    }
```

In this example, you have an IceCream interface representing the base object, a BasicIceCream class as the concrete implementation, and decorator classes like ChocolateTopping and SprinklesTopping that add extra functionality. You can stack these decorators to add layers of toppings to your ice cream.

Just like in the real-life example, you can decorate your ice cream (base object) with different toppings (decorators) to make it more interesting and flavorful.
