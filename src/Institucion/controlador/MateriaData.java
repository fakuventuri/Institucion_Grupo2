package Institucion.controlador;

import Institucion.modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MateriaData {

    private Connection con = null;

    public MateriaData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            //System.exit(0);
        }
    }

    public boolean insertMateria(Materia materia) {
        String sql = "INSERT INTO materia (nombre, anioMateria, activo) VALUES (?,?,?)";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, materia.getNombre());
                ps.setInt(2, materia.getAnioMateria());
                ps.setBoolean(3, materia.isActivo());
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
            }

            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            return false;
        }
    }

    public boolean deleteMateria(int idMateria) {
        String sql = "UPDATE materia SET activo=? WHERE ?";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setBoolean(1, false);
                ps.setInt(2, idMateria);
                ps.executeUpdate();
                return true; // falta hacer que retorne true solo si encontro y pudo modificar el alumno
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            return false;
        }
    }

    public ArrayList<Materia> listarMaterias() {
        String sql = "SELECT * FROM materia";

        ArrayList<Materia> materias = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                Materia materia = new Materia();

                materia.setIdMateria(rs.getInt(1));
                materia.setNombre(rs.getString(2));
                materia.setAnioMateria(rs.getInt(3));
                materia.setActivo(rs.getBoolean(4));
                materias.add(materia);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return materias;
    }

}
