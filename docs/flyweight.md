<div align="center" id="top">
  <a href="">
    <img src="./../assets/imgs/bgs/flyweight.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Flyweight</h1>
</div>

<br />

## Intent

**Flyweight** is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.

## Implementation



1. Divide fields of a class that will become a flyweight into two parts:
- the intrinsic state: the fields that contain unchanging data duplicated across many objects
- the extrinsic state: the fields that contain contextual data unique to each object

2. Leave the fields that represent the intrinsic state in the class, but make sure they’re immutable. They should take their initial values only inside the constructor.

3. Go over methods that use fields of the extrinsic state. For each field used in the method, introduce a new parameter and use it instead of the field.

4. Optionally, create a factory class to manage the pool of flyweights. It should check for an existing flyweight before creating a new one. Once the factory is in place, clients must only request flyweights through it. They should describe the desired flyweight by passing its intrinsic state to the factory.

5. The client must store or calculate values of the extrinsic state (context) to be able to call methods of flyweight objects. For the sake of convenience, the extrinsic state along with the flyweight-referencing field may be moved to a separate context class.


## Structure

<p align="center">
	<img src="../assets/imgs/structures/flyweight.png" alt="Singleton Structure" width="400px">
</p>


## Psuedocode

In this example, the **Flyweight** pattern helps to reduce memory usage when rendering millions of tree objects on a canvas.

<p align="center">
	<img src="../assets/imgs/pseudo-code/flyweight.png" alt="Singleton Structure" width="400px">
</p>

The pattern extracts the repeating intrinsic state from a main `Tree` class and moves it into the flyweight class `TreeType`.

Now instead of storing the same data in multiple objects, it’s kept in just a few flyweight objects and linked to appropriate `Tree` objects which act as contexts. The client code creates new tree objects using the flyweight factory, which encapsulates the complexity of searching for the right object and reusing it if needed.

```java

// The flyweight class contains a portion of the state of a
// tree. These fields store values that are unique for each
// particular tree. For instance, you won't find here the tree
// coordinates. But the texture and colors shared between many
// trees are here. Since this data is usually BIG, you'd waste a
// lot of memory by keeping it in each tree object. Instead, we
// can extract texture, color, and other repeating data into a
// separate object which lots of individual tree objects can
// reference.
class TreeType {
    private String name;
    private String color;
    private String texture;

    public TreeType(String name, String color, String texture) { ... }

    public void draw(Canvas canvas, int x, int y) {
        // 1. Create a bitmap of a given type, color & texture.
        // 2. Draw the bitmap on the canvas at X and Y coords.
    }
}

// Flyweight factory decides whether to re-use an existing
// flyweight or to create a new object.
class TreeFactory {
    private static Collection<TreeType> treeTypes;

    public static TreeType getTreeType(String name, String color, String texture) {
        TreeType type = treeTypes.find(name, color, texture);
        if (type == null) {
            type = new TreeType(name, color, texture);
            treeTypes.add(type);
        }
        return type;
    }
}

// The contextual object contains the extrinsic part of the tree
// state. An application can create billions of these since they
// are pretty small: just two integer coordinates and one
// reference field.
class Tree {
    private int x, y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) { ... }

    public void draw(Canvas canvas) {
        type.draw(canvas, this.x, this.y);
    }
}

// The Tree and the Forest classes are the flyweight's clients.
// You can merge them if you don't plan to develop the Tree
// class any further.
class Forest {
    private Collection<Tree> trees;

    public void plantTree(int x, int y, String name, String color, String texture) {
        TreeType type = TreeFactory.getTreeType(name, color, texture);
        Tree tree = new Tree(x, y, type);
        trees.add(tree);
    }

    public void draw(Canvas canvas) {
        for (Tree tree : trees) {
            tree.draw(canvas);
        }
    }
}
```