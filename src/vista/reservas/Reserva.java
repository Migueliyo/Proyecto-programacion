package vista.reservas;

import javax.swing.*;

public class Reserva {
    private JFrame ventanaReservas;
    private JPanel panelPrincipal;
    private JLabel labelPrueba;
    private JPanel panelInferior;
    private JButton botonSalir;
    private JButton botonCerrarSesion;
    private JPanel panelLateral;
    private JPanel panelNorte;
    private JPanel panelCentral;
    private JTextField textoFecha;
    private JLabel fecha;
    private JTextField textoDuracion;
    private JLabel duracion;
    private JTextField textoHoraEntrada;
    private JTextField textoTipoReserva;
    private JLabel horaEntrada;
    private JLabel tipoReserva;
    private JButton crear;
    private JButton borrar;
    private JButton avanzar;
    private JButton retroceder;
    private JLabel etiquetaUsuario;
    private JLabel textoUsuario;

    public Reserva () {
        ventanaReservas = new JFrame("Aplicación reservas");
        ventanaReservas.setContentPane(panelPrincipal);
        //ventanaReservas.setSize(800,800);
        ventanaReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaReservas.setLocationRelativeTo(null);
        ventanaReservas.pack();
        ventanaReservas.setVisible(true);
    }

    public JFrame getVentanaReservas() {
        return ventanaReservas;
    }

    public JLabel getLabelPrueba() {
        return labelPrueba;
    }

    public JButton getBorrar() {
        return borrar;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JLabel getTextoUsuario() {
        return textoUsuario;
    }

    public JTextField getTextoFecha() {
        return textoFecha;
    }

    public JTextField getTextoDuracion() {
        return textoDuracion;
    }

    public JTextField getTextoHoraEntrada() {
        return textoHoraEntrada;
    }

    public JTextField getTextoTipoReserva() {
        return textoTipoReserva;
    }

    public static void main(String[] args) {
        new Reserva();
    }
}
