package Institucion.controlador;

import Institucion.modelo.Alumno;
import Institucion.modelo.Inscripcion;
import Institucion.modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InscripcionData {

    private Connection con = null;

    public InscripcionData(Conexion conexion) {
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            //System.exit(0);
        }
    }

    public boolean insertInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (idMateria, idAlumno, nota) VALUES (?,?,?)";

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, inscripcion.getMateria().getIdMateria());
                ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
                ps.setDouble(3, inscripcion.getNota());
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();
            }

            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            return false;
        }
    }

    public boolean deleteInscripcion(int idInscripcion) {
        String sql = "DELETE FROM inscripcion WHERE idInscripcion=?";

        try {
            //ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idInscripcion);
                ps.executeUpdate();
                return true; // falta hacer que retorne true solo si encontro y pudo modificar el alumno
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            return false;
        }
    }

    public boolean setNota(int idInscripcion, double nota) {
        String sql = "UPDATE inscripcion SET nota=? WHERE idInscripcion=?";

        try {
            //ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(2, nota);
                ps.setInt(1, idInscripcion);
                ps.executeUpdate();
                return true; // falta hacer que retorne true solo si encontro y pudo modificar el alumno
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
            return false;
        }
    }
    
    public ArrayList<Alumno> getAlumnosEnMateria(int idMateria) {
        String sql = "SELECT a.* FROM alumno a, materia m, inscripcion i WHERE i.idMateria = m.idMateria AND a.idAlumno = i.idAlumno AND i.idMateria = ? AND a.activo = 1 AND m.activo = 1";

        ArrayList<Alumno> alumnosEnMateria = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idMateria);
                rs = ps.executeQuery();
            }
            
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                alumnosEnMateria.add(alumno);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return alumnosEnMateria;
    }
    
    public ArrayList<Materia> getMateriasDeAlumno(int idAlumno) {
        String sql = "SELECT m.* FROM alumno a, materia m, inscripcion i WHERE i.idMateria = m.idMateria AND a.idAlumno = i.idAlumno AND i.idAlumno = ? AND a.activo = 1 AND m.activo = 1";

        ArrayList<Materia> materiasDeAlumno = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idAlumno);
                rs = ps.executeQuery();
            }
            
            while (rs.next()) {
                Materia materia = new Materia();

                materia.setIdMateria(rs.getInt(1));
                materia.setNombre(rs.getString(2));
                materia.setAnioMateria(rs.getInt(3));
                materia.setActivo(rs.getBoolean(4));
                materiasDeAlumno.add(materia);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return materiasDeAlumno;
    }
    
    
    public ArrayList<Alumno> getAlumnosNoInscrptos(int idAlumno) {
        String sql = "SELECT `idMateria`, `nombre`, `anioMateria`, `activo` FROM `materia m , inscripcion i` WHERE idMateria NOT in (select m.idMateria from inscripcion i, materia m where i.idMateria = m.idMateria and i.idAlumno = ?)";
                ArrayList<Alumno> alumnosNoInscriptos = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, idAlumno);
                rs = ps.executeQuery();
            }
            
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                alumnosNoInscriptos.add(alumno);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return alumnosNoInscriptos;
}
    
    public void borrarInscripcionDeUnAlumnoDeUnaMateria(int idAlumno, int idMateria){
        try {
            String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setDouble(1, idAlumno);
                ps.setInt(2, idMateria);
                ps.executeUpdate();
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
    }
    
    
}
