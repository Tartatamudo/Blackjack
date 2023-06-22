package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioVentana extends JFrame implements ActionListener {
    private JTextField nombreTextField;
    private JButton btnEntrarButton;
    private JButton btnSalirButton;
    private JPanel ventana;
    private JLabel lblBienvenida;
    private JLabel lblEscribaNombre;

    public void Pantalla() {
        // Configuramos la ventana
        setTitle("Casino");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        setContentPane(ventana);
        btnEntrarButton.addActionListener(this);
        btnSalirButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnEntrarButton){
            String nombre = nombreTextField.getText();
            MenuPrincipal menuPrincipal = new MenuPrincipal(nombre);
            menuPrincipal.Pantalla();
            setVisible(false);
        } else if (e.getSource() == btnSalirButton) {
            System.exit(WIDTH);
        }
    }
}
