package controlador.reservas;

import modelo.dao.reserva.ReservaDAO;
import modelo.dao.reserva.ReservaDAOImpl;
import modelo.dao.usuario.Usuario;
import modelo.dao.usuario.UsuarioDAO;
import vista.logueo.Login;
import vista.reservas.Reserva;

import javax.swing.*;

public class ControladorReservas {
    private ReservaDAO modelo;
    private Reserva vista;
    private Usuario usuario;

    public ControladorReservas(Usuario usuario) {
        this.modelo = new ReservaDAOImpl();
        this.vista = new Reserva();
        this.usuario = usuario;
        inicializarVista();
    }

    private void inicializarVista() {
        vista.getVentanaReservas().setVisible(true);
        vista.getTextoUsuario().setText(usuario.getNombre());
        //vista.getTextoFecha().setText(modelo.);
    }
    public void inicializarControlador() {
        vista.getBorrar().addActionListener(actionEvent -> borrarReserva());
        vista.getBotonSalir().addActionListener(actionEvent -> salirApp());
    }

    private void borrarReserva() {

    }

    private void salirApp() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de salir?",
                "SALIR", JOptionPane.YES_NO_OPTION);
        if (opcion == 0)
            System.exit(0);
    }
}
