<div align="center" id="top">
  <a href="">
    <img src="../assets/imgs/bgs/adapter.png" alt="Logo" width="250px">
  </a>

  <h1 align="center">Adapter</h1>
</div>

<br />

## Intent
Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

An adapter is like a special connector that allows two things that wouldn't normally fit together to work together. It's like using a plug adapter to connect your electronic devices to outlets in different countries.

Imagine you have a collection of old, square-shaped cassette tapes, but your new music player only accepts round CDs. To listen to your cassette tapes on the CD player, you use a cassette-to-CD adapter. This adapter transforms the square shape into a round one so that your music player can read and play the tapes.

## Implementation
This is a special object that converts the interface of one object so that another object can understand it.

An adapter wraps one of the objects to hide the complexity of conversion happening behind the scenes. The wrapped object isn’t even aware of the adapter. For example, you can wrap an object that operates in meters and kilometers with an adapter that converts all of the data to imperial units such as feet and miles.

## Structure

<p align="center">
    <img src="../assets/imgs/structures/adapter.png" alt="Singleton Structure" width="400px">
</p>

## Psuedocode

```java
    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // The class that implements the target interface
    class AudioPlayer implements MediaPlayer {
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing MP3 file: " + fileName);
            } else {
                System.out.println("Unsupported audio format: " + audioType);
            }
        }
    }

    // The interface that's not compatible with the target
    interface AdvancedMediaPlayer {
        void playVlc(String fileName);
        void playMp4(String fileName);
    }
```

The classes that implement the incompatible interface

```java
    class VlcPlayer implements AdvancedMediaPlayer {
        public void playVlc(String fileName) {
            System.out.println("Playing Vlc file: " + fileName);
        }

        public void playMp4(String fileName) {
            // Do nothing for MP4 files
        }
    }

    class Mp4Player implements AdvancedMediaPlayer {
        public void playVlc(String fileName) {
            // Do nothing for Vlc files
        }

        public void playMp4(String fileName) {
            System.out.println("Playing Mp4 file: " + fileName);
        }
    }
```

 The adapter class that makes the incompatible interface compatible

```java
    class MediaAdapter implements MediaPlayer {
        private AdvancedMediaPlayer advancedMediaPlayer;

        public MediaAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer = new VlcPlayer();
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer = new Mp4Player();
            }
        }

        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedMediaPlayer.playVlc(fileName);
            } else if (audioType.equalsIgnoreCase("mp4")) {
                advancedMediaPlayer.playMp4(fileName);
            }
        }
    }
```

Now, you can use the adapter to play different audio formats on the MediaPlayer:

```java
    public class Main {
        public static void main(String[] args) {
            MediaPlayer audioPlayer = new AudioPlayer();

            audioPlayer.play("mp3", "song.mp3");
            audioPlayer.play("vlc", "movie.vlc");
            audioPlayer.play("mp4", "video.mp4");

            // Use the adapter to play unsupported formats
            audioPlayer = new MediaAdapter("vlc");
            audioPlayer.play("vlc", "movie.vlc");

            audioPlayer = new MediaAdapter("mp4");
            audioPlayer.play("mp4", "video.mp4");
        }
    }
```

In this example, the MediaAdapter allows you to play different audio formats (Vlc and Mp4) on the MediaPlayer, even though they have incompatible interfaces. The adapter class acts as a bridge to make them work together.

Just like in the real-life example, the adapter helps you connect and use two things that wouldn't normally fit together.