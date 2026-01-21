package frame;

import logic.Humano;
import logic.Mounstro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ventana  extends JFrame {

    Humano humano;
    Mounstro mounstro;



    public Ventana(Humano humano, Mounstro mounstro){
        this.humano = humano;
        this.mounstro = mounstro;

        setSize(600, 600);
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelHumano = new JPanel();
        panelHumano.setLayout(new BoxLayout(panelHumano, BoxLayout.Y_AXIS));
        panelHumano.setBackground(Color.WHITE);

        JPanel panelMounstro = new JPanel();
        panelMounstro.setLayout(new BoxLayout(panelMounstro, BoxLayout.Y_AXIS));
        panelMounstro.setBackground(Color.WHITE);


        //Cosas del humano
        ImageIcon icono = new ImageIcon(getClass().getResource("/images/humano.png"));
        JLabel etiquetaImagen = new JLabel(icono);
        panelHumano.add(etiquetaImagen);
        panelHumano.add(new JLabel(humano.getNombre()));
        panelHumano.add(new JLabel(String.valueOf( humano.getInteligencia()) ));
        panelHumano.add(new JLabel(String.valueOf(humano.getVelocidad())));
        panelHumano.add(new JLabel(String.valueOf(humano.getDano())));
        JLabel referenciaHumano = new JLabel(String.valueOf(humano.getVida()));
        panelHumano.add(referenciaHumano);

        add(panelHumano,  BorderLayout.WEST);

        //Cosas del mounsto
        ImageIcon icono2 = new ImageIcon(getClass().getResource("/images/mounstro.png"));
        JLabel etiquetaImagen2 = new JLabel(icono2);
        panelMounstro.add(etiquetaImagen2);
        panelMounstro.add(new JLabel(mounstro.getNombre()));
        panelMounstro.add(new JLabel(String.valueOf( mounstro.getPoder()) ));
        panelMounstro.add(new JLabel(String.valueOf(mounstro.getRugido())));
        panelMounstro.add(new JLabel(String.valueOf(mounstro.getDano())));
        JLabel referenciaMounstro = new JLabel(String.valueOf(mounstro.getVida()));
        panelMounstro.add(referenciaMounstro);

        add(panelMounstro,  BorderLayout.EAST);

        // panel de pelea
        JPanel panelPelea = new JPanel();
        JButton btnPelear = new JButton("Pelear");
        JLabel labelMensaje = new JLabel("");
        panelPelea.add(btnPelear, BorderLayout.CENTER);
        panelPelea.add(labelMensaje);
        add(panelPelea ,  BorderLayout.CENTER);




        // Peleamooooos!!
        btnPelear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mensaje = calcularPelea(humano, mounstro);

                if (mensaje.matches("[mh]\\d+")) {

                    int valor = Integer.parseInt(mensaje.substring(1));

                    if (mensaje.charAt(0) == 'm') {
                        mounstro.setVida(valor);
                        referenciaMounstro.setText(String.valueOf(mounstro.getVida()));
                    } else {
                        humano.setVida(valor);
                        referenciaHumano.setText(String.valueOf(humano.getVida()));
                    }

                } else {
                    labelMensaje.setText(mensaje);
                }
            }
        });

        setVisible(true);
    }

    //aca van lo metodos
    public String calcularPelea(Humano humano, Mounstro mounstro){

        //Variable auxiliar
        String mensaje = "";

        //bloque por turnos
        Random random = new Random();
        int turno = random.nextInt(100);

        if (turno < 50 ){
            //primero pega el mounstro
            humano.setVida((humano.getVida()-mounstro.getDano()));
            if(humano.getVida() <= 0){
                mensaje = "gano el mounstro";
                return mensaje;
            }
            mensaje = "h" + String.valueOf(humano.getVida());
        }else{
            //primero pega el humano
            mounstro.setVida((mounstro.getVida()-humano.getDano()));
            if(mounstro.getVida() <= 0){
                mensaje = "gano el humano";
                return mensaje;
            }
            mensaje = "m" + String.valueOf(mounstro.getVida());
        }
        return mensaje;
    }
}
