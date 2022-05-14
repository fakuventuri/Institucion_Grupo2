package Institucion.controlador;

import Institucion.modelo.Alumno;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlumnoData {

    private Connection con = null;

    public AlumnoData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            //System.exit(0);
        }
    }

    public boolean insertAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumno (apellido, nombre, fechaNac, activo) VALUES (?,?,?,?)";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, alumno.getApellido());
                ps.setString(2, alumno.getNombre());
                ps.setDate(3, Date.valueOf(alumno.getFechaNac()));
                ps.setBoolean(4, alumno.isActivo());
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
            }

            if (rs.next()) {
                alumno.setIdAlumno(rs.getInt(1));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            return false;
        }
    }

    public boolean deleteAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET activo=? WHERE ?";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                //alumno.setActivo(false);
                ps.setBoolean(1, false);
                ps.setInt(2, alumno.getIdAlumno());
                ps.executeUpdate();
                return true; // faltaa hacer que retorne true solo si encontro y pudo modificar el alumno
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            return false;
        }
    }

    public ArrayList<Alumno> listarAlumnos() {
        String sql = "SELECT * FROM alumno";

        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                alumnos.add(alumno);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return alumnos;
    }

}
