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
    private JLabel blackJackLabel;
    private JLabel invisible;
    private JButton btnJugar;
    private JButton btnVolver;
    private JList resultadoList;
    private JScrollPane scrollPane;
    private JLabel resultadoLabel;

    private JPanel jPanel;

    public BlackJackVentana(JugadorBlackJack jugadorBlackJack) throws HeadlessException {
        this.jugadorBlackJack = jugadorBlackJack;
    }

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

        add(blackJackLabel);
        add(invisible);
        add(resultadoLabel);
        add(jPanel);

        add(btnJugar);
        add(btnVolver);

        btnJugar.addActionListener(this);
        btnVolver.addActionListener(this);
        setVisible(true);
    }
    public void DeclararListaResultado(){
        resultadoList = new JList<>();

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

            jPanel.removeAll();

            DeclararListaResultado();

            scrollPane = new JScrollPane();
            scrollPane.setViewportView(resultadoList);

            jPanel.add(scrollPane,BorderLayout.CENTER);
            jPanel.revalidate();
            jPanel.repaint();

        } else if (e.getSource() == btnVolver) {
            MenuPrincipal menu = new MenuPrincipal(jugadorBlackJack.GetNombre());
            menu.Pantalla();
            setVisible(false);
        }
    }
}
