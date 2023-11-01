<div align="center" id="top">
  <a href="">
    <img src="assets/imgs/main.png" alt="Logo" width="250px">
  </a>

  <h3 align="center">Design Patterns</h3>

  <p align="center">
    From Chaos to Clarity: Design Patterns for a Harmonious World
  </p>
</div>

<br />

# What's a design pattern?

**Design patterns** are typical solutions to commonly occurring problems in software design. They are like pre-made blueprints that you can customize to solve a recurring design problem in your code.

<br/>

# What does the pattern consist of?
Most patterns are described very formally so people can reproduce them in many contexts. Here are the sections that are usually present in a pattern description:

- **Intent** of the pattern briefly describes both the problem and the solution.
- **Motivation** further explains the problem and the solution the pattern makes possible.
- **Structure** of classes shows each part of the pattern and how they are related.
- **Code example** in one of the popular programming languages makes it easier to grasp the idea behind the pattern.

<br/>

# Why should you care?
The truth is that you might manage to work as a programmer for many years without knowing about a single pattern. A lot of people do just that. Even in that case, though, you might be implementing some patterns without even knowing it. So why would you spend time learning them?

- Design patterns are a toolkit of tried and tested solutions to common problems in software design. Even if you never encounter these problems, knowing patterns is still useful because it teaches you how to solve all sorts of problems using principles of object-oriented design.

- Design patterns define a common language that you and your teammates can use to communicate more efficiently. You can say, “Oh, just use a Singleton for that,” and everyone will understand the idea behind your suggestion. No need to explain what a singleton is if you know the pattern and its name.

<br />

# Classification of patterns
Design patterns differ by their complexity, level of detail and scale of applicability to the entire system being designed.

- **Creational** patterns provide object creation mechanisms that increase flexibility and reuse of existing code.

- **Structural** patterns explain how to assemble objects and classes into larger structures, while keeping the structures flexible and efficient.

- **Behavioral** patterns take care of effective communication and the assignment of responsibilities between objects.

# Design patterns Catalog
## Creational Patterns
<table align="center" width="100%" border="1">
  <tr>
    <td align="center">
        <img src="assets/imgs/creation-patterns/singleton.png" width="100px">
        <div>
          <a href="./docs/singleton.md">Singleton</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/creation-patterns/builder.png" width="100px">
        <div>
          <a href="./docs/builder.md">Builder</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/creation-patterns/factory.png"  width="100px">
        <div>
          <a href="./docs/factory.md">Factory</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/creation-patterns/prototype.png"  width="100px">
        <div>
          <a href="./docs/prototype.md">Prototype</a>
        </div>
    </td>
  </tr>
</table>

## Structural patterns
<table align="center" width="100%" border="1">
  <tr>
    <td align="center">
        <img src="assets/imgs/structure-patterns/proxy.png" width="100px">
        <div>
          <a href="./docs/proxy.md">Proxy</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/structure-patterns/decorator.png" width="100px">
        <div>
          <a href="./docs/decorator.md">Decorator</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/structure-patterns/facade.png"  width="100px">
        <div>
          <a href="./docs/facade.md">Facade</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/structure-patterns/adapter.png"  width="100px">
        <div>
          <a href="./docs/adapter.md">Adapter</a>
        </div>
    </td>
  </tr>
</table>

<table align="center" width="100%" border="1">
  <tr>
    <td align="center">
        <img src="assets/imgs/structure-patterns/composite.png" width="100px">
        <div>
          <a href="./docs/composite.md">Composite</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/structure-patterns/bridge.png" width="100px">
        <div>
          <a href="./docs/bridge.md">Bridge</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/structure-patterns/flyweight.png"  width="100px">
        <div>
          <a href="#">Flyweight</a>
        </div>
    </td>
  </tr>
</table>

## Behavioral patterns
<table align="center" width="100%" border="1">
  <tr>
    <td align="center">
        <img src="assets/imgs/behav-patterns/observer.png" width="100px">
        <div>
          <a href="#">Observer</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/behav-patterns/memento.png" width="100px">
        <div>
          <a href="#">Memento</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/behav-patterns/state.png"  width="100px">
        <div>
        <a href="#">State</a>
        </div>
    </td>
    <td align="center">
        <img src="assets/imgs/behav-patterns/command.png"  width="100px">
        <div>
          <a href="#">Command</a>
        </div>
    </td>
  </tr>
</table>