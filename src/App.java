import controlador.logueo.ControladorLogin;
import controlador.reservas.ControladorReservas;
import modelo.dao.usuario.Usuario;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import vista.logueo.Login;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UsuarioDAO modelo = new UsuarioDAOImpl();
                Login vista = new Login();
                ControladorLogin controladorLogin  =
                        new ControladorLogin(modelo, vista);
                controladorLogin.inicializarControlador();
            }
        });
    }
}
