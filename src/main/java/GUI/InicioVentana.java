package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InicioVentana extends JFrame implements ActionListener {
    private JLabel lblBienvenida;
    private JLabel lblNombre;
    private JTextField nombreTextField;
    private JButton btnEntrarButton;
    private JButton btnSalirButton;
    private JLabel a;

    public void Pantalla() {
        // Configuramos la ventana
        setTitle("Casino");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        lblBienvenida = new JLabel("Bienvenido");
        lblNombre = new JLabel("Escriba su nombre");

        nombreTextField = new JTextField("Escriba aqui");

        btnEntrarButton = new JButton("Entrar al casino");
        btnSalirButton = new JButton("Salir");

        setLayout(new GridLayout(3, 2));

        add(lblBienvenida);
        add(a);
        add(lblNombre);

        add(nombreTextField);
        add(btnEntrarButton);
        add(btnSalirButton);

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
