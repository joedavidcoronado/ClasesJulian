package logic;

public class Humano extends Personaje{

    int velocidad;
    int inteligencia;

    public Humano(String nombre, int vida, int dano, int velocidad, int inteligencia) {
        super(nombre, vida, dano);
        this.velocidad = velocidad;
        this.inteligencia = inteligencia;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
