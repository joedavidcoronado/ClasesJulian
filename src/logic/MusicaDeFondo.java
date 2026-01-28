package logic;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class MusicaDeFondo {
    private Clip clip;

    public MusicaDeFondo(String rutaArchivo){
        try {
            InputStream is = getClass().getResourceAsStream(rutaArchivo);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(is);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar la música: " + rutaArchivo, e);
        }
    }

    public void iniciar(){
        clip.start();
    }
    public void detener(){
        clip.stop();
    }
}
