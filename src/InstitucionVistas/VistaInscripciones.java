/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package InstitucionVistas;

import Institucion.controlador.AlumnoData;
import Institucion.controlador.Conexion;
import Institucion.controlador.InscripcionData;
import Institucion.modelo.Alumno;
import Institucion.modelo.Inscripcion;
import Institucion.modelo.Materia;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Macarena Infante
 */
public class VistaInscripciones extends javax.swing.JInternalFrame {
    
    private AlumnoData alumnoData;
    private Conexion conexion;
    private ArrayList <Alumno> listaAlumnos;
    private DefaultTableModel modelo;
    private InscripcionData inscripcionData;



    /** Creates new form VistaInscripciones */
    public VistaInscripciones() {
        initComponents();
        conexion = new Conexion();
        alumnoData = new AlumnoData(conexion);
        listaAlumnos = alumnoData.listarAlumnos();
        cargarAlumnos();
        modelo = new DefaultTableModel();   
        armarCabeceraTabla();
        inscripcionData = new InscripcionData(conexion);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        rbInscriptas = new javax.swing.JRadioButton();
        rbNoInscriptas = new javax.swing.JRadioButton();
        botonInscribir = new javax.swing.JButton();
        botonAnular = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Formulario de Inscripcion");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Alumno");

        cbAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlumnosActionPerformed(evt);
            }
        });

        tablaMaterias.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tablaMaterias.setForeground(new java.awt.Color(0, 0, 153));
        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaMaterias);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("LISTADO DE MATERIAS");

        rbInscriptas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rbInscriptas.setText("Inscriptas");
        rbInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbInscriptasActionPerformed(evt);
            }
        });

        rbNoInscriptas.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        rbNoInscriptas.setText("No Inscriptas");
        rbNoInscriptas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoInscriptasActionPerformed(evt);
            }
        });

        botonInscribir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonInscribir.setForeground(new java.awt.Color(0, 0, 153));
        botonInscribir.setText("Inscribir");
        botonInscribir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonInscribir.setEnabled(false);
        botonInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInscribirActionPerformed(evt);
            }
        });

        botonAnular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonAnular.setForeground(new java.awt.Color(0, 0, 153));
        botonAnular.setText("Anular Inscripcion");
        botonAnular.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAnular.setEnabled(false);
        botonAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnularActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonSalir.setForeground(new java.awt.Color(0, 0, 153));
        botonSalir.setText("Salir");
        botonSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rbInscriptas)
                        .addGap(312, 312, 312))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbNoInscriptas, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(129, 129, 129))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(botonInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(botonAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbInscriptas)
                    .addComponent(rbNoInscriptas))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAnular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbInscriptasActionPerformed
        // TODO add your handling code here:
        
        rbNoInscriptas.setSelected(false);
        cargarInscriptas();
        botonAnular.setEnabled(true);
        botonInscribir.setEnabled(false);
        
    }//GEN-LAST:event_rbInscriptasActionPerformed

    private void rbNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoInscriptasActionPerformed
        // TODO add your handling code here:
        
        rbInscriptas.setSelected(false);
        cargarNoInscriptas();
        botonAnular.setEnabled(false);
        botonInscribir.setEnabled(true);
        
    }//GEN-LAST:event_rbNoInscriptasActionPerformed

    private void botonInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInscribirActionPerformed
        // TODO add your handling code here:
        
         int filaSeleccionada=tablaMaterias.getSelectedRow();
    
        if(filaSeleccionada!=-1){
                
            Alumno a=(Alumno)cbAlumnos.getSelectedItem();
            
            
            int idMateria=(Integer)modelo.getValueAt(filaSeleccionada,0);
            String nombreMateria=(String)modelo.getValueAt(filaSeleccionada,1);
            int a??o=(Integer)modelo.getValueAt(filaSeleccionada, 2);
            Materia m=new Materia(idMateria,nombreMateria,a??o,true);
            
            Inscripcion c= new Inscripcion(m,a,0);
            
            
            inscripcionData.insertInscripcion(c);
            
            borrarFilasTabla();
       
        }
    

        
        
    }//GEN-LAST:event_botonInscribirActionPerformed

    private void botonAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnularActionPerformed
        // TODO add your handling code here:
        
        int filaSeleccionada=tablaMaterias.getSelectedRow();
        if(filaSeleccionada!=-1){
                    
            Alumno a=(Alumno)cbAlumnos.getSelectedItem();
                        
            int idMateria=(Integer)modelo.getValueAt(filaSeleccionada,0);
            
           
            inscripcionData.borrarInscripcionDeUnAlumnoDeUnaMateria(a.getIdAlumno(), idMateria);
            borrarFilasTabla();
      
        }
        
    

        
    }//GEN-LAST:event_botonAnularActionPerformed

    private void cbAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlumnosActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model;
        model = (DefaultTableModel) tablaMaterias.getModel();
        model.setRowCount(0);
        if (rbInscriptas.isSelected()) {
            cargarInscriptas();
        } else if (rbNoInscriptas.isSelected()){
            cargarNoInscriptas();
        }
        
    }//GEN-LAST:event_cbAlumnosActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
        
        dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    
    private void cargarAlumnos(){
    //Carga las materias al ComboBox
    for(Alumno item:listaAlumnos){
            cbAlumnos.addItem(item);
    
    }
    }
    
    private void armarCabeceraTabla(){
                ArrayList<Object> columnas=new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Nombre");
        columnas.add("A??o");
        for(Object it:columnas){
        
            modelo.addColumn(it);
        }
        tablaMaterias.setModel(modelo);
  }
    
    private void borrarFilasTabla(){
        int a = modelo.getRowCount() - 1;
        for (int i= a ; i>=0; i--){
            modelo.removeRow(i);
        }
        //Borra las filas de abajo par arriba
    }
    
    private void cargarInscriptas(){
        borrarFilasTabla();
        
       Alumno seleccionado = (Alumno)cbAlumnos.getSelectedItem();
       
       ArrayList<Materia> lista = (ArrayList)inscripcionData.getMateriasDeAlumno(seleccionado.getIdAlumno());
    
       for(Materia m:lista){
        
            modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(),m.getAnioMateria()});
        }

    
    }

    
    private void cargarNoInscriptas(){
        
        borrarFilasTabla();
        
       Alumno seleccionado = (Alumno)cbAlumnos.getSelectedItem();
       
       ArrayList<Materia> lista = (ArrayList)inscripcionData.getMateriasNoInscriptas(seleccionado.getIdAlumno());
    
       for(Materia m:lista){
        
            modelo.addRow(new Object[]{m.getIdMateria(),m.getNombre(),m.getAnioMateria()});
        }

    
    }
    
    
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAnular;
    private javax.swing.JButton botonInscribir;
    private javax.swing.JButton botonSalir;
    private javax.swing.JComboBox<Alumno> cbAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbInscriptas;
    private javax.swing.JRadioButton rbNoInscriptas;
    private javax.swing.JTable tablaMaterias;
    // End of variables declaration//GEN-END:variables

}
