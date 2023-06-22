package GUI;

import BlackJack.Crupier;
import BlackJack.JugadorBlackJack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class BlackJackVentana extends JFrame implements ActionListener {
    private JugadorBlackJack jugadorBlackJack;
    private JButton btnJugar;
    private JButton btnVolver;
    private JList resultadoList;
    private JPanel ventana;
    private JScrollPane resultadoScroll;
    private JLabel resultadoLabel;
    private JLabel blackJackLabel;


    public BlackJackVentana(JugadorBlackJack jugadorBlackJack) throws HeadlessException {
        this.jugadorBlackJack = jugadorBlackJack;
        Pantalla();
    }

    public void Pantalla(){
        // Configuramos la ventana
        setTitle("Inicio");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        setContentPane(ventana);
        resultadoScroll.setViewportView(resultadoList);

        btnJugar.addActionListener(this);
        btnVolver.addActionListener(this);
        setVisible(true);
    }
    public void DeclararListaResultado(){
        Crupier crupier = new Crupier(jugadorBlackJack);
        List<String> texto = Arrays.asList(crupier.Jugar().split(";"));

        resultadoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < texto.size(); i++) {
            modelo.addElement(texto.get(i));
        }
        resultadoList.setModel(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnJugar){


            DeclararListaResultado();

            resultadoScroll.repaint();


        } else if (e.getSource() == btnVolver) {
            MenuPrincipal menu = new MenuPrincipal(jugadorBlackJack.GetNombre());
            menu.Pantalla();
            setVisible(false);
        }
    }
}
