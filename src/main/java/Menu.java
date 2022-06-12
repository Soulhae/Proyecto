import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends javax.swing.JFrame {
    
    private Curso curso;
    BufferedReader lector = new BufferedReader ( new InputStreamReader (System.in) );
        
    public Menu() {
        initComponents();
        /* Establecemos el tamaño de la ventana , la centramos, el título y terminar la ejecución del programa si la ventana se cierra. */
        setSize(500,500);
        setLocationRelativeTo(null);
        setTitle("Menú");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.PINK);
        this.curso  = new Curso();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        listaDatos = new javax.swing.JButton();
        buscarRecDigital = new javax.swing.JButton();
        alumnoPromedioBajo = new javax.swing.JButton();
        alumnosPromedioAzul = new javax.swing.JButton();
        generarTxt = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Opciones del menú:");

        agregar.setText("1.- Agregar elemento");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        eliminar.setText("2.- Eliminar elemento");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setText("3.- Modificar elemento");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        listaDatos.setText("4.- Ver datos de los elementos");
        listaDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaDatosActionPerformed(evt);
            }
        });

        buscarRecDigital.setText("5.- Buscar recurso digital");
        buscarRecDigital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarRecDigitalActionPerformed(evt);
            }
        });

        alumnoPromedioBajo.setText("6.- Seleccionar alumno con la nota final más baja de todos los cursos");
        alumnoPromedioBajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnoPromedioBajoActionPerformed(evt);
            }
        });

        alumnosPromedioAzul.setText("7.- Seleccion de alumnos con nota final entre 4.0 y 7.0 de todos los cursos");
        alumnosPromedioAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alumnosPromedioAzulActionPerformed(evt);
            }
        });

        generarTxt.setText("8.- Generar archivo txt");
        generarTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarTxtActionPerformed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(agregar)
                            .addComponent(eliminar)
                            .addComponent(modificar)
                            .addComponent(listaDatos)
                            .addComponent(buscarRecDigital)
                            .addComponent(alumnoPromedioBajo)
                            .addComponent(alumnosPromedioAzul)
                            .addComponent(generarTxt))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(salir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarRecDigital)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alumnoPromedioBajo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alumnosPromedioAzul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generarTxt)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        AgregarElementos agregar = new AgregarElementos(curso);
        agregar.setVisible(true);
    }//GEN-LAST:event_agregarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        EliminarElementos elim = new EliminarElementos(curso);
        elim.setVisible(true);
    }//GEN-LAST:event_eliminarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        ModificarElementos modif = new ModificarElementos(curso);
        modif.setVisible(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void listaDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaDatosActionPerformed
        ListaElementos listaElementos = new ListaElementos(curso);
        listaElementos.setVisible(true);
    }//GEN-LAST:event_listaDatosActionPerformed

    private void buscarRecDigitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarRecDigitalActionPerformed
        
        if (curso.existenAsignaturas() == false){
            System.out.println("\nNo hay asignaturas registradas, por lo tanto, no existen recursos digitales.\n");
        }
        else{
            System.out.println("Ingrese la sigla de la Asignatura que buscar el Recursos Digital: ");
            String sigla2 = null;
            try {
                sigla2 = lector.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

            while (curso.buscarAsignatura(sigla2) == null){
                System.out.println("Inténtelo nuevamente. Ingrese una sigla válida. ");
                try {
                    sigla2 = lector.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            Asignatura auxAsignatura = curso.buscarAsignatura(sigla2);
            System.out.println("Ingrese el nombre del Recurso Digital: ");

            String buscarRecDig = null;
            try {
                buscarRecDig = lector.readLine();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("\n- Recurso Digital -");

            if (auxAsignatura.buscarMapaRecDigital(buscarRecDig) == null){
                System.out.println("\nEl Recurso digital buscado no existe.\n");
            }
            else{
                System.out.println(auxAsignatura.buscarMapaRecDigital(buscarRecDig).getTipo()+" | "+auxAsignatura.buscarMapaRecDigital(buscarRecDig).getNombre()+ "\n");
            }
        }
        
    }//GEN-LAST:event_buscarRecDigitalActionPerformed

    private void alumnoPromedioBajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnoPromedioBajoActionPerformed
        
        Persona seleccionarAlumno = new Alumno(); /* Alumno con el promedio mas bajo */
        double promedioCursoBajo = 8;
        seleccionarAlumno = ((Alumno) curso.obtenerAlumnoBajo());
        promedioCursoBajo = ( (Alumno) seleccionarAlumno).obtenerPromedio();
        
        if (promedioCursoBajo == 8.0){
            System.out.println("\nNo hay notas registradas.\n");
        }
        else{
            System.out.println("\nEl alumno con el promedio más bajo ("+promedioCursoBajo+") es: "+ seleccionarAlumno.getNombre() +" - "+ seleccionarAlumno.getRut()+"\n");
        }
        
    }//GEN-LAST:event_alumnoPromedioBajoActionPerformed

    private void alumnosPromedioAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alumnosPromedioAzulActionPerformed
        System.out.println("\nLista de Alumnos con promedio entre 4.0 y 7.0");
        boolean aux;
        int cont = 0;
        aux = curso.notaRango();
        if (aux == false) cont ++;
        if (cont == 0) System.out.println("\nNo hay notas registradas.\n");
    }//GEN-LAST:event_alumnosPromedioAzulActionPerformed

    private void generarTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarTxtActionPerformed
        System.out.println("Se creara un archivo .txt con la lista de los alumnos, las asignaturas y si en estas hay recursos digitales");
        System.out.println("----GENERANDO ALUMNOS----");
        System.out.println("..........................");
        System.out.println("----GENERANDO ASIGNATURAS----");
        System.out.println("..........................");
        curso.generarTXT();
        System.out.println("----GENERANDO RECURSOS DIGITALES");
        System.out.println("..........................");
        System.out.println("Archivo generado con exito, revise la carpeta del programa para encontrarlo y poder leelo, muchas gracias");
    }//GEN-LAST:event_generarTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton agregar;
    private javax.swing.JButton alumnoPromedioBajo;
    private javax.swing.JButton alumnosPromedioAzul;
    private javax.swing.JButton buscarRecDigital;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JButton eliminar;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton generarTxt;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton listaDatos;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton modificar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JButton salir;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables


}
