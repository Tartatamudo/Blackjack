package GUI;

import BullsEye.JuegoBullsEye;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Validadores.validadores.GetEntero;
import static Validadores.validadores.ValidarEntero;

public class BullsEyeVentana extends JFrame implements ActionListener {
    private JuegoBullsEye juegoBullsEye;
    private JLabel bullsEyeLabel;
    private JLabel numCaballoLabel;
    private JTextField numCaballoTextField;
    private JLabel escribaApuesta;
    private JList apuestaList;
    private JTextField apuestaTextField;
    private JButton btnVolver;
    private JButton btnHacerApuesta;
    private JPanel jPanelResultado;
    private JLabel caballoGanadorLabel;
    private JList resultadoList;
    private JPanel jPannel;
    private JLabel a;
    private JLabel b;
    private JLabel c;
    private JLabel d;
    private JScrollPane scrollPane;

    public BullsEyeVentana(JuegoBullsEye juegoBullsEye) throws HeadlessException {
        this.juegoBullsEye = juegoBullsEye;
    }

    public void Pantalla(){
        // Configuramos la ventana
        setTitle("Casino");
        setSize(1000, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        bullsEyeLabel = new JLabel("BullsEye");

        numCaballoLabel = new JLabel("Escriba el id del caballo al que desea apostar del 1 al 6: ");
        numCaballoTextField = new JTextField("caballo");

        escribaApuesta = new JLabel("ELiga monto que va a apostar:");

        btnHacerApuesta = new JButton("Hacer apuesta");
        btnVolver = new JButton("Vover");


        DeclararListNumApuesta();

        apuestaTextField = new JTextField("apuesta");

        jPanelResultado = new JPanel(new GridLayout(2, 1));

        setLayout(new GridLayout(6, 2));

        add(bullsEyeLabel);
        add(a);
        add(numCaballoLabel);
        add(b);
        add(numCaballoTextField);
        add(c);

        add(escribaApuesta);
        add(apuestaList);
        add(apuestaTextField);
        add(jPanelResultado);

        add(btnVolver);
        add(btnHacerApuesta);
        //add(d);


        btnVolver.addActionListener(this);
        btnHacerApuesta.addActionListener(this);
        setVisible(true);

    }
    public void DeclararListNumApuesta(){
        apuestaList = new JList<>();
        List<String> texto = Arrays.asList(juegoBullsEye.ElegirMontoApuesta().split(";"));

        apuestaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < texto.size(); i++) {
            modelo.addElement(texto.get(i));
        }
        apuestaList.setModel(modelo);
    }
    public void DeclararListResultado(int apuesta, int caballo){
        resultadoList = new JList<>();
        List<String> texto = Arrays.asList(juegoBullsEye.Jugar(caballo, apuesta).split(";"));

        resultadoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
        DefaultListModel modelo = new DefaultListModel();
        for (int i = 0; i < texto.size(); i++) {
            modelo.addElement(texto.get(i));
        }
        resultadoList.setModel(modelo);
    }
    public int DeclararApuesta(){

        int apuesta = GetEntero(apuestaTextField.getText());
        if (apuesta == 1){
            apuesta = 500;
        } else if (apuesta == 2) {
            apuesta = 1000;
        }else if (apuesta == 3){
            apuesta = 5000;
        }else if ( apuesta == 4){
            apuesta = 10000;
        } else if ( apuesta == 5) {
            apuesta = 25000;
        }else if (apuesta == 6){
            apuesta = 50000;
        }else{
            apuesta = 0;
        }
        return apuesta;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnHacerApuesta) {
            int apuesta = DeclararApuesta();
            if (apuesta == 0 || ValidarEntero(numCaballoTextField.getText()) != true ) {
                jPanelResultado.removeAll();
                caballoGanadorLabel = new JLabel("Escribio mal el numero del monto a apostar o del id del caballo");
                jPanelResultado.add(caballoGanadorLabel);
            }else{
            if (apuesta <= juegoBullsEye.Getjugador().GetMonto()) {

                int caballo = GetEntero(numCaballoTextField.getText());

                DeclararListResultado(apuesta, caballo);

                caballoGanadorLabel = new JLabel(juegoBullsEye.ImprimirDatosCaballoganador());
                jPanelResultado.removeAll();

                jPanelResultado.add(caballoGanadorLabel, BorderLayout.CENTER);

                scrollPane = new JScrollPane();
                scrollPane.setViewportView(resultadoList);
                jPanelResultado.add(scrollPane);

            } else {
                jPanelResultado.removeAll();
                caballoGanadorLabel = new JLabel("Usted no tiene dinero sufiecviente para realizar la apuesta");
                jPanelResultado.add(caballoGanadorLabel);

            }
        }
            jPanelResultado.revalidate();
            jPanelResultado.repaint();
        }else if(e.getSource() == btnVolver){
            MenuPrincipal menu = new MenuPrincipal(juegoBullsEye.Getjugador().GetNombre());
            menu.Pantalla();
            setVisible(false);
        }
    }
}
