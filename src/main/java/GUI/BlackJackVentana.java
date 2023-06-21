package GUI;

import BlackJack.BlackJack;
import BlackJack.Crupier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackJackVentana extends JFrame implements ActionListener {
    private JLabel blackJackLabel;
    private JLabel juegoLabel;
    private JButton btnJugar;
    private JButton btnVolver;
    private JLabel resultadoLabel;
    private JPanel panel1;
    private JPanel jPanel;

    public void Pantalla(){
        // Configuramos la ventana
        setTitle("Inicio");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        blackJackLabel = new JLabel("BlackJack");
        resultadoLabel = new JLabel("Resultado:");
        btnJugar = new JButton("Jugar");
        btnVolver = new JButton("Volver");


        jPanel = new JPanel(new GridLayout(1, 1));


        setLayout(new GridLayout(3, 2));

        add(resultadoLabel);
        add(jPanel);
        add(blackJackLabel);
        add(btnJugar);
        add(btnVolver);

        btnJugar.addActionListener(this);
        btnVolver.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnJugar){
            jPanel.removeAll();
            BlackJack blackJack = new BlackJack();
            //juegoLabel = new JLabel(blackJack.Jugar());

            jPanel.add(juegoLabel,BorderLayout.CENTER);
            jPanel.revalidate();
            jPanel.repaint();

        } else if (e.getSource() == btnVolver) {
            MenuPrincipal menu = new MenuPrincipal();
            menu.Pantalla();
            setVisible(false);
        }
    }
}
