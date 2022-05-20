package controlador.reservas;

import helpers.Fechas;
import modelo.dao.reserva.ReservaDAO;
import modelo.dao.reserva.ReservaDAOImpl;
import modelo.dao.usuario.Usuario;
import modelo.dao.usuario.UsuarioDAO;
import vista.logueo.Login;
import vista.reservas.Reserva;
import helpers.Fechas.*;
import javax.swing.*;
import java.sql.SQLException;

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
        try {
            /*vista.getTextoFecha().setText(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).
                    getFecha().toString());*/
            String fecha = Fechas.convertirFormatoFechaEspannol(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).
                    getFecha());
            vista.getTextoFecha().setText(fecha);
            vista.getTextoDuracion().setText(String.valueOf(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).getDuracion()));
            vista.getTextoHoraEntrada().setText(String.valueOf(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).getHoraEntrada()));
            vista.getTextoTipoReserva().setText(String.valueOf(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).getTipoReserva()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inicializarControlador() {
        vista.getBorrar().addActionListener(actionEvent -> borrarReserva());
        vista.getBotonCerrarSesion().addActionListener(actionEvent -> cerrarSesion());
        vista.getBotonSalir().addActionListener(actionEvent -> salirApp());
    }

    private void cerrarSesion() {

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
