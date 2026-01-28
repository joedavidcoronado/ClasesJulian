package logic;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class MusicaDeFondo {
    private Clip clip;

    public MusicaDeFondo(String rutaArchivo){
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(rutaArchivo));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void iniciar(){
        clip.start();
    }
    public void detener(){
        clip.stop();
    }
}
