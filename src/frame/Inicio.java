package frame;

import logic.Humano;
import logic.Mounstro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame {

    private Humano humano;
    private Mounstro mounstro;
    private boolean uso = true;


    public  Inicio(){
        setSize(650, 600);
        setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("inicio");

        JPanel panelHumano = new JPanel();
        panelHumano.setLayout(new BoxLayout(panelHumano, BoxLayout.Y_AXIS));
        JPanel panelMounstro = new JPanel();
        panelMounstro.setLayout(new BoxLayout(panelMounstro, BoxLayout.Y_AXIS));
        panelMounstro.setVisible(false);
        //Parte del humano
        JLabel titulo = new JLabel("CREA TU HUMANO");
        titulo.setPreferredSize(new Dimension(300, 100));
        panelHumano.add(titulo);

        JLabel labelNombre = new JLabel("Nombre de tu humano");
        JTextField txtNombre = new JTextField();
        panelHumano.add(labelNombre);
        panelHumano.add(txtNombre);

        JLabel labelVida= new JLabel("Vida de tu humano");
        JTextField txtVida = new JTextField();
        panelHumano.add(labelVida);
        panelHumano.add(txtVida);

        JLabel labelDano= new JLabel("Dano de tu humano");
        JTextField txtDano = new JTextField();
        panelHumano.add(labelDano);
        panelHumano.add(txtDano);

        JLabel labelVelocidad= new JLabel("Velocidad de tu humano");
        JTextField txtVelocidad = new JTextField();
        panelHumano.add(labelVelocidad);
        panelHumano.add(txtVelocidad);

        JLabel labelInteligencia= new JLabel("Inteligencia de tu humano");
        JTextField txtInteligencia = new JTextField();
        panelHumano.add(labelInteligencia);
        panelHumano.add(txtInteligencia);

        JPanel panelElegirPersonaje = new JPanel(new FlowLayout(FlowLayout.LEFT) );


        ImageIcon iconoHumano = new ImageIcon(getClass().getResource("/images/mounstro1.jpg"));
        Image imagenHumano = iconoHumano.getImage();
        Image imagenRedimensionada = imagenHumano.getScaledInstance(200, 140, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        JLabel Humano1 = new JLabel(iconoRedimensionado);
        panelElegirPersonaje.add(Humano1);

        ImageIcon iconoHumano2 = new ImageIcon(getClass().getResource("/images/mounstro1.jpg"));
        Image imagenHumano2 = iconoHumano2.getImage();
        Image imagenRedimensionada2 = imagenHumano2.getScaledInstance(200, 140, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado2 = new ImageIcon(imagenRedimensionada2);
        JLabel Humano2 = new JLabel(iconoRedimensionado2);
        panelElegirPersonaje.add(Humano2);

        ImageIcon iconoHumano3 = new ImageIcon(getClass().getResource("/images/mounstro1.jpg"));
        Image imagenHumano3 = iconoHumano3.getImage();
        Image imagenRedimensionada3= imagenHumano3.getScaledInstance(200, 140, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado3 = new ImageIcon(imagenRedimensionada3);
        JLabel Humano3 = new JLabel(iconoRedimensionado3);
        panelElegirPersonaje.add(Humano3);

        add(panelElegirPersonaje);





        add(panelHumano, BorderLayout.NORTH);

        //Parte del Mounstro
        JLabel tituloM = new JLabel("CREA TU MOUNSTRO");
        tituloM.setPreferredSize(new Dimension(300, 100));
        panelMounstro.add(tituloM);

        JLabel labelNombreM = new JLabel("Nombre de tu mounstro");
        JTextField txtNombreM = new JTextField();
        panelMounstro.add(labelNombreM);
        panelMounstro.add(txtNombreM);

        JLabel labelVidaM= new JLabel("Vida de tu mounstro");
        JTextField txtVidaM = new JTextField();
        panelMounstro.add(labelVidaM);
        panelMounstro.add(txtVidaM);

        JLabel labelDanoM = new JLabel("Dano de tu mounstro");
        JTextField txtDanoM = new JTextField();
        panelMounstro.add(labelDanoM);
        panelMounstro.add(txtDanoM);

        JLabel labelPoder= new JLabel("Poder de tu mounstro");
        JTextField txtPoder = new JTextField();
        panelMounstro.add(labelPoder);
        panelMounstro.add(txtPoder);

        JLabel labelRugido= new JLabel("Rugido de tu mounstro");
        JTextField txtRugido = new JTextField();
        panelMounstro.add(labelRugido);
        panelMounstro.add(txtRugido);




        JButton btnCrear = new JButton("CREAR");
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(uso == true){
                    String nombre = txtNombre.getText();
                    int vida = Integer.parseInt(txtVida.getText());
                    int dano = Integer.parseInt(txtDano.getText());
                    int velocidad = Integer.parseInt(txtVelocidad.getText());
                    int inteligencia = Integer.parseInt(txtInteligencia.getText());
                    humano = new Humano(nombre, vida, dano, velocidad, inteligencia);
                    panelHumano.setVisible(false);
                    panelMounstro.setVisible(true);
                    add(panelMounstro, BorderLayout.NORTH);
                    uso = false;
                }else{
                    String nombre = txtNombreM.getText();
                    int vida = Integer.parseInt(txtVidaM.getText());
                    int dano = Integer.parseInt(txtDanoM.getText());
                    int rugido = Integer.parseInt(txtRugido.getText());
                    int poder = Integer.parseInt(txtPoder.getText());
                    mounstro = new Mounstro(nombre, vida, dano, rugido, poder);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    setVisible(false);
                    Ventana ventana = new Ventana(humano, mounstro);
                }
            }
        });

        add(btnCrear, BorderLayout.SOUTH);


        setVisible(true);
    }
}
