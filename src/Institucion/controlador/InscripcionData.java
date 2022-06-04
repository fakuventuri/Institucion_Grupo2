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
    Conexion conexion;

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

    public boolean setNota(int idAlumno, int idMateria, double nota) {
        String sql = "UPDATE inscripcion SET nota=? WHERE idAlumno=? AND idMateria=?";

        try {
            //ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, nota);
                ps.setInt(2, idAlumno);
                ps.setInt(3, idMateria);
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
    
    
    public ArrayList<Materia> getMateriasNoInscriptas(int idAlumno) {
        String sql = "SELECT materia.* FROM materia WHERE materia.idMateria NOT in (select materia.idMateria from inscripcion, materia where inscripcion.idMateria = materia.idMateria and inscripcion.idAlumno = ?)";
                ArrayList<Materia> materiasNoInscriptas = new ArrayList<>();

        try {
            ResultSet rs;
            try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, idAlumno);
                rs = ps.executeQuery();
                }
            
                while (rs.next()) {
                    Materia materia = new Materia();

                    materia.setIdMateria(rs.getInt(1));
                    materia.setNombre(rs.getString(2));
                    materia.setAnioMateria(rs.getInt(3));
                    materia.setActivo(rs.getBoolean(4));
                    materiasNoInscriptas.add(materia);
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Sintaxis incorrecta de consulta");
            }
        return materiasNoInscriptas;
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
    
    public ArrayList<Inscripcion> listarInscripcionesXAlumno(int idAlumno){    
      

        ArrayList<Inscripcion> inscripciones = new ArrayList<>();

        try {
            String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?;";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, idAlumno);

            ResultSet resultSet = statement.executeQuery();

            Inscripcion inscripcion;

            while (resultSet.next()) {

                inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(resultSet.getInt("idInscripcion"));

                Alumno a = buscarAlumno(resultSet.getInt("idAlumno"));
                inscripcion.setAlumno(a);

                Materia m = buscarMateriaPorId(resultSet.getInt("idMateria"));
                inscripcion.setMateria(m);
                inscripcion.setNota(resultSet.getInt("nota"));

                inscripciones.add(inscripcion);
            }
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los alumnos: " + ex.getMessage());
        }

        return inscripciones;
    
        
    }
    
    
      /*  public Alumno buscarAlumno(int idAlumno) {

            AlumnoData ad = new AlumnoData(conexion);
            return ad.buscarAlumno(idAlumno);

        }*/
        
        
           public Alumno buscarAlumno(int idAlumno) {
        Alumno alumno = null;
        String sql = "SELECT * FROM alumno WHERE activo=1 AND idAlumno LIKE ?";

        //ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion al buscar Alumnos");
        }
        return alumno;
    }

    /*    public Materia buscarMateria(int idMateria) {

            MateriaData md = new MateriaData(conexion);
            return md.buscarMateriaPorId(idMateria);

        }*/
           
           public Materia buscarMateriaPorId(int idMateria) {
                
               Materia materia = null; 
                String sql = "SELECT * FROM materia WHERE idMateria LIKE ?";

            

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            ps.close();
            while (rs.next()) {
                materia = new Materia();

                materia.setIdMateria(rs.getInt(1));
                materia.setNombre(rs.getString(2));
                materia.setAnioMateria(rs.getInt(3));
                materia.setActivo(rs.getBoolean(4));
                
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de conexion");
        }
        return materia;

}
    
    
}
