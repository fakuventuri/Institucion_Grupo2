package Institucion;

import Institucion.controlador.AlumnoData;
import Institucion.controlador.Conexion;
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

        Alumno a = new Alumno(15, "Venturi", "Facundo", LocalDate.now(), true);
        Alumno b = new Alumno("Coria", "Agustin", LocalDate.now(), true);

        //ad.insertAlumno(a);
        //ad.insertAlumno(b);
        
        //ad.deleteAlumno(a);
        
        //System.out.println(ad.listarAlumnos().toString());
        
        Materia m = new Materia("Web", 1, true);
        
        md.insertMateria(m);
        //md.insertMateria(m);
        
        //System.out.println(md.listarMaterias().toString());

        /*Inscripcion i = new Inscripcion(m, a, 9);

        System.out.println(a);
        System.out.println(m);
        System.out.println(i);
        i.setNota(10);
        System.out.println(i);*/

    }

}
