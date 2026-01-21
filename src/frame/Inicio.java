package frame;

import logic.Humano;
import logic.Mounstro;

import javax.swing.*;
import java.awt.*;

public class Inicio extends JFrame {

    private Humano humano;
    private Mounstro mounstro;

    public  Inicio(){
        setSize(600, 600);
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("inicio");

        JPanel panelHumano = new JPanel();
        panelHumano.setLayout(new BoxLayout(panelHumano, BoxLayout.Y_AXIS));
        JPanel panelMounstro = new JPanel();
        panelMounstro.setVisible(false);

        //Parte del humano
        JLabel labelNombre = new JLabel("Nombre de tu humano");
        JTextField txtNombre = new JTextField("Coloca un nombre");
        panelHumano.add(labelNombre);
        panelHumano.add(txtNombre);

        JLabel labelVida= new JLabel("Vida de tu humano");
        JTextField txtVida = new JTextField("Coloca la vida");
        panelHumano.add(labelVida);
        panelHumano.add(txtVida);

        JLabel labelDano= new JLabel("Dano de tu humano");
        JTextField txtDano = new JTextField("Coloca el daño");
        panelHumano.add(labelDano);
        panelHumano.add(txtDano);

        JLabel labelVelocidad= new JLabel("Velocidad de tu humano");
        JTextField txtVelocidad = new JTextField("Coloca la velocidad");
        panelHumano.add(labelVelocidad);
        panelHumano.add(txtVelocidad);

        JLabel labelInteligencia= new JLabel("Inteligencia de tu humano");
        JTextField txtInteligencia = new JTextField("Coloca la Inteligencia");
        panelHumano.add(labelInteligencia);
        panelHumano.add(txtInteligencia);

        add(panelHumano, BorderLayout.CENTER);
        //add(panelMounstro);


        setVisible(true);
    }
}
