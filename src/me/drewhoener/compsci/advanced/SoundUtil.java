
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineEvent.Type;

public class SoundUtil{

  public void playSound(File soundFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException{
  
    class AudioListener implements LineListener{
      
      private boolean soundFinished = false;
      
      @Override
      public synchronized void update(LineEvent event){
        Type eventType = event.getType();
        if(eventType == Type.STOP || eventType == Type.CLOSE){
          soundFinished = true;
          notifyAll();
        }
      
      }
      
      public synchronized void waitUntilDone() throws InterruptedException {
        while(!soundFinished)
          wait();
      }
    
    }
  
    AudioListener listener = new AudioListener();
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(clipFile);
    try {
    
      Clip clip = AudioSystem.getClip();
      clip.addLineListener(listener);
      clip.open(audioInputStream);
      try {
    
        clip.start();
        listener.waitUntilDone();
      } finally {
    
        clip.close();
      }
    } finally {
      audioInputStream.close();
    }
  
  }

}
