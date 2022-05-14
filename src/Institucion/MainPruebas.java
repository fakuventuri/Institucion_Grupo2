package Institucion;

import Institucion.controlador.AlumnoData;
import Institucion.controlador.Conexion;
import Institucion.modelo.Alumno;
import Institucion.modelo.Inscripcion;
import Institucion.modelo.Materia;
import java.time.LocalDate;

public class MainPruebas {

    public static void main(String[] args) {
        Conexion con = new Conexion();
        AlumnoData ad = new AlumnoData(con);

        Alumno a = new Alumno(15, "Venturi", "Facundo", LocalDate.now(), true);
        Alumno b = new Alumno("Coria", "Agustin", LocalDate.now(), true);

        //ad.insertAlumno(a);
        //ad.insertAlumno(b);
        
        //ad.deleteAlumno(a);
        
        //System.out.println(ad.listarAlumnos().toString
        
        Materia m = new Materia("Lab", 1, true);

        Inscripcion i = new Inscripcion(m, a, 9);

        System.out.println(a);
        System.out.println(m);
        System.out.println(i);
        i.setNota(10);
        System.out.println(i);

    }

}
