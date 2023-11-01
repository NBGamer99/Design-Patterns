<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/proxy.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Proxy</h1>
</div>

<br />

## Intent
Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

A proxy is like an assistant or a middleman that helps you do something without you having to do all the work. It's like having someone stand in for you when you're too busy or need some help.

Imagine you're a very important person, and you need to sign a lot of documents every day. It's a time-consuming task. So, you hire a trusted assistant (the proxy) to sign documents on your behalf. The assistant has the authority to sign for you, and you can focus on more important tasks while the assistant handles the paperwork.

## Implementation
The Proxy pattern suggests that you create a new proxy class with the same interface as an original service object. Then you update your app so that it passes the proxy object to all of the original object’s clients. Upon receiving a request from a client, the proxy creates a real service object and delegates all the work to it.

But what’s the benefit? If you need to execute something either before or after the primary logic of the class, the proxy lets you do this without changing that class. Since the proxy implements the same interface as the original class, it can be passed to any client that expects a real service object.

## Structure

<p align="center">
    <img src="../assets/imgs/structures/proxy.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

```java
    // The interface representing the real object
    interface Image {
        void display();
    }

    // The real object that does the actual work
    class RealImage implements Image {
        private String filename;

        public RealImage(String filename) {
            this.filename = filename;
            loadFromDisk();
        }

        private void loadFromDisk() {
            System.out.println("Loading image: " + filename);
        }

        public void display() {
            System.out.println("Displaying image: " + filename);
        }
    }

    // The proxy class that controls access to the real object
    class ImageProxy implements Image {
        private RealImage realImage;
        private String filename;

        public ImageProxy(String filename) {
            this.filename = filename;
        }

        public bool isGrantedAccess() {
            // Check if the user has access to the image
            return true;
        }

        public void display() {
            if (isGrantedAccess()) {
                if (realImage == null) {
                    realImage = new RealImage(filename);
                }
                realImage.display();
            }
            else {
                System.out.println("Access denied");
            }
        }
    }
```

Now, you can use the proxy to control access to the real object:


```java
    public class Main {
        public static void main(String[] args) {
            // Using the proxy to display an image
            Image image = new ImageProxy("sample.jpg");

            // The real image is loaded and displayed only when needed
            image.display();
        }
    }
```

In this example, the ImageProxy acts as a middleman between the client code and the RealImage. It loads the real image only when necessary, and it allows you to control access to the image. This is similar to having an assistant (proxy) handle tasks for you when you need them, like signing documents.
