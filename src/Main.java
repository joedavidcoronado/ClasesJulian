import frame.Ventana;
import logic.Humano;
import logic.Mounstro;

public class Main {
    public static void main(String[] args) {

        Humano humano = new Humano("Julian el Desctructor", 1000, 20, 100, 100);
        Mounstro mounstro = new Mounstro("Carlitos del barrio", 1000, 30, 90, 20);

        Ventana ventana = new Ventana(humano, mounstro);

    }
}