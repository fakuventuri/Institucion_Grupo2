package Institucion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private String url = "jdbc:mysql://localhost/institucion";
    private String usuario = "root";
    private String password = "";

    private Connection conexion;

    public Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Mariadb no encontrado!");
        }

    }

    public Connection getConexion() throws SQLException {
        if (conexion == null) {
            conexion = DriverManager
                    .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                            + "&user=" + usuario
                            + "&password=" + password);
        }
        return conexion;
    }
}
