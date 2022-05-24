package controlador.reservas;

import controlador.logueo.ControladorLogin;
import helpers.Fechas;
import modelo.dao.reserva.ReservaDAO;
import modelo.dao.reserva.ReservaDAOImpl;
import modelo.dao.usuario.Usuario;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import vista.logueo.Login;
import vista.reservas.Reserva;
import helpers.Fechas.*;
import javax.swing.*;
import java.sql.SQLException;

public class ControladorReservas {
    private ReservaDAO modelo;
    private Reserva vista;
    private Usuario usuario;
    private JFrame ventanaLogin;

    public ControladorReservas(Usuario usuario, JFrame ventanaLogin) {
        this.modelo = new ReservaDAOImpl();
        this.vista = new Reserva();
        this.usuario = usuario;
        this.ventanaLogin = ventanaLogin;
        inicializarVista();
    }

    private void inicializarVista() {
        vista.getVentanaReservas().setVisible(true);
        vista.getTextoUsuario().setText(usuario.getNombre());
        try {
            if (modelo.obtenerReservarPorUsuario(usuario.getDni()).isEmpty()) {
                vista.getTextoFecha().setText("-");
                vista.getTextoDuracion().setText("-");
                vista.getTextoHoraEntrada().setText("-");
                vista.getTextoTipoReserva().setText("-");
            }
           else {
                String fecha = Fechas.convertirFormatoFechaEspannol(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).
                        getFecha());
                vista.getTextoFecha().setText(fecha);
                vista.getTextoDuracion().setText(String.valueOf(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).getDuracion()));
                vista.getTextoHoraEntrada().setText(String.valueOf(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).getHoraEntrada()));
                vista.getTextoTipoReserva().setText(String.valueOf(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0).getTipoReserva()));
            }
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
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que desea cerrar sesión?",
                "CERRAR SESIÓN", JOptionPane.YES_NO_OPTION);
        if (opcion == 0) {
            vista.getVentanaReservas().setVisible(false);
            ventanaLogin.setVisible(true);
        }
    }

    private void borrarReserva() {
        try {
            if (modelo.obtenerReservarPorUsuario(usuario.getDni()).isEmpty()) {
                JOptionPane.showInternalMessageDialog(null, "No puedes borrar una reserva que no existe",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else if (modelo.eliminarReserva(modelo.obtenerReservarPorUsuario(usuario.getDni()).get(0)) == true) {
                inicializarVista();
            } else {
                inicializarVista();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void salirApp() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de salir?",
                "SALIR", JOptionPane.YES_NO_OPTION);
        if (opcion == 0)
            System.exit(0);
    }
}
