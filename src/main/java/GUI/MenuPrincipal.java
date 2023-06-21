package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame implements ActionListener {
    private JLabel menu;
    private JLabel eligaQueJuegoJugarLabel;
    private JButton btnBlackJack;
    private JButton btnBullsEyeButton;

    public void Pantalla(){
        // Configuramos la ventana
        setTitle("Casino");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        btnBlackJack =new JButton("BlackJack");
        btnBullsEyeButton = new JButton("BullsEye");

        setLayout(new GridLayout(3, 2));

        add(menu);
        add(eligaQueJuegoJugarLabel);
        add(btnBlackJack);
        add(btnBullsEyeButton);

        btnBlackJack.addActionListener(this);
        btnBullsEyeButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBlackJack){
            BlackJackVentana blackJackVentana = new BlackJackVentana();
            blackJackVentana.Pantalla();
            setVisible(false);
        }
    }
}
