package GUI;

import BlackJack.JugadorBlackJack;
import BullsEye.JuegoBullsEye;
import BullsEye.JugadorBullsEye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame implements ActionListener {
    private String nombre;
    private JLabel menu;
    private JLabel eligaQueJuegoJugarLabel;
    private JButton btnBlackJack;
    private JButton btnBullsEyeButton;
    private JButton btnVolver;
    private JPanel ventana;

    public MenuPrincipal(String nombre) throws HeadlessException {
        this.nombre = nombre;
    }

    public void Pantalla(){
        // Configuramos la ventana
        setTitle("Casino");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

       setContentPane(ventana);

        btnBlackJack.addActionListener(this);
        btnBullsEyeButton.addActionListener(this);
        btnVolver.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBlackJack){
            JugadorBlackJack jugadorBlackJack = new JugadorBlackJack(nombre);
            BlackJackVentana blackJackVentana = new BlackJackVentana(jugadorBlackJack);

            setVisible(false);
        }else if(e.getSource() == btnBullsEyeButton){
            JugadorBullsEye jugadorBullsEye = new JugadorBullsEye(nombre);
            JuegoBullsEye juegoBullsEye = new JuegoBullsEye(jugadorBullsEye);

            BullsEyeVentana bullsEyeVentana = new BullsEyeVentana(juegoBullsEye);
            bullsEyeVentana.Pantalla();
            setVisible(false);
        }else if (e.getSource() == btnVolver){
            InicioVentana inicioVentana = new InicioVentana();
            inicioVentana.Pantalla();
            setVisible(false);
        }
    }
}
