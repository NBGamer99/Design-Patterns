<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/composite.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Composite</h1>
</div>

<br />

## Intent

**Composite** is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.

## Implementation

The Composite pattern suggests that you work with products and collections of products in the same way. This is because the root object of the hierarchy and the nested objects are all implementations of the same interface.


1. Make sure that the core model of your app can be represented as a tree structure. Try to break it down into simple elements and containers. Remember that containers must be able to contain both simple elements and other containers.

2. Declare the component interface with a list of methods that make sense for both simple and complex components.

3. Create a leaf class to represent simple elements. A program may have multiple different leaf classes.

4. Create a container class to represent complex elements. In this class, provide an array field for storing references to sub-elements. The array must be able to store both leaves and containers, so make sure it’s declared with the component interface type.

> While implementing the methods of the component interface, remember that a container is supposed to be delegating most of the work to sub-elements.

6. Finally, define the methods for adding and removal of child elements in the container.

Keep in mind that these operations can be declared in the component interface. This would violate the Interface Segregation Principle because the methods will be empty in the leaf class. However, the client will be able to treat all the elements equally, even when composing the tree.


## Structure

<p align="center">
    <img src="../assets/imgs/structures/composite.png" alt="Singleton Structure" width="400px">
</p>

## Pseudocode

```java

// Component interface
interface Component {
    void operation();
}

// Leaf class (represents individual objects)
class Leaf implements Component {
    @Override
    public void operation() {
        // Implement the operation for the leaf
        // This can be some specific behavior for individual objects
    }
}

// Composite class (represents a group of components)
class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void addComponent(Component component) {
        children.add(component);
    }

    public void removeComponent(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        // Implement the operation for the composite
        // This operation can also delegate to its child components
        for (Component child : children) {
            child.operation();
        }
    }
}

// Client code
public class Client {
    public static void main(String[] args) {
        // Create leaf objects
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();

        // Create a composite object
        Composite composite = new Composite();

        // Add leaf objects to the composite
        composite.addComponent(leaf1);
        composite.addComponent(leaf2);

        // Perform operations on individual leaf objects
        leaf1.operation();
        leaf2.operation();

        // Perform an operation on the composite, which in turn, delegates to its children
        composite.operation();
    }
}
```

This pattern allows you to create tree-like structures where individual objects (referred to as "leaf" objects) and groups of objects (referred to as "composite" objects) can be treated uniformly. The `Component` interface defines a common operation for all objects in the hierarchy, ensuring that both leaves and composites implement this operation. The `Leaf` class represents individual objects with specific behaviors, while the `Composite` class can contain a collection of both leaf and other composite objects. The client code illustrates how to create and work with these objects. When performing operations on a composite, it delegates the operation to its child components, making it possible to manipulate complex structures in a consistent and unified way.