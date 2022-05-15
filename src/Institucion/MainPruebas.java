package Institucion;

import Institucion.controlador.AlumnoData;
import Institucion.controlador.Conexion;
import Institucion.controlador.InscripcionData;
import Institucion.controlador.MateriaData;
import Institucion.modelo.Alumno;
import Institucion.modelo.Inscripcion;
import Institucion.modelo.Materia;
import java.time.LocalDate;

public class MainPruebas {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        AlumnoData ad = new AlumnoData(con);
        MateriaData md = new MateriaData(con);
        InscripcionData inscDat = new InscripcionData(con);

        Alumno a = new Alumno(5, "Venturi Coria", "Facundo Agustin", LocalDate.of(2000, 11, 20), true);
        Alumno b = new Alumno(6, "Infante", "Macarena", LocalDate.now(), true);

        //ad.insertAlumno(a);
        //ad.insertAlumno(b);
        
        //ad.deleteAlumno(5);
        
        //ad.updateAlumno(5, a);
        
        //ad.updateAlumno(5, a);
        //ad.updateAlumno(6, b);
        
        System.out.println(ad.listarAlumnos());
        
        Materia m = new Materia(2, "Desarrollo Web", 1, true);
        Materia m2 = new Materia(3, "Lab", 1, true);
        
        //md.insertMateria(m);
        //md.insertMateria(m);
        
        //md.updateMateria(2, m);
        //md.updateMateria(3, m2);

        
        //md.deleteMateria(3);
        
        System.out.println(md.listarMaterias());

        Inscripcion i = new Inscripcion(m, b, 4);
        
        //inscDat.deleteInscripcion(2);
        
        //inscDat.insertInscripcion(i);
        //System.out.println(inscDat.getMateriasDeAlumno(6));
        
        //inscDat.setNota(1, 4);

        /*System.out.println(a);
        System.out.println(m);
        System.out.println(i);
        i.setNota(10);
        System.out.println(i);*/
        
        //Maqi sin U

    }

}
