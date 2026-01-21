package logic;

public class Mounstro extends Personaje {

    int poder;
    int rugido;

    public Mounstro(String nombre, int vida, int dano, int poder, int rugido) {
        super(nombre, vida, dano);
        this.poder = poder;
        this.rugido = rugido;

    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getRugido() {
        return rugido;
    }

    public void setRugido(int rugido) {
        this.rugido = rugido;
    }
}
