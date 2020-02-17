package gramaticas;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import paneles.PanelModelo;
import pollitos.PolloCSV;

/**
 *
 * @author luisGonzalez
 */
public class VentanaIDE extends javax.swing.JFrame {

    private File proyecto;
    private DefaultTreeModel model;
    

    public VentanaIDE() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoHistorial = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoPrueba = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoConsultas = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        textoPrueba2 = new javax.swing.JTextArea();
        panelIDE = new javax.swing.JTabbedPane();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCarpeta = new javax.swing.JTree();
        opcionesMenu = new javax.swing.JMenuBar();
        barra1 = new javax.swing.JMenu();
        opcion1 = new javax.swing.JMenuItem();
        opcion2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoHistorial.setColumns(20);
        textoHistorial.setRows(5);
        jScrollPane2.setViewportView(textoHistorial);

        panelFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 70, 30));

        textoPrueba.setColumns(20);
        textoPrueba.setRows(5);
        textoPrueba.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textoPruebaKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(textoPrueba);

        panelFondo.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 400, 40));

        textoConsultas.setColumns(20);
        textoConsultas.setRows(5);
        jScrollPane4.setViewportView(textoConsultas);

        panelFondo.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 540, 93));

        jButton1.setText("lexico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jButton2.setText("prueba IDE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        textoPrueba2.setColumns(20);
        textoPrueba2.setRows(5);
        jScrollPane5.setViewportView(textoPrueba2);

        panelFondo.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 403, 40));
        panelFondo.add(panelIDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 500, 340));

        jButton3.setText("Nueva pesta;a");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, -1, -1));

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jButton5.setText("ANALIZADOR3");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jButton6.setText("boton texto panel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        panelFondo.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arbolCarpeta.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolCarpeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolCarpetaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(arbolCarpeta);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 50, 130, 470));

        barra1.setText("Proyectos");

        opcion1.setText("Abrir Proyecto");
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        barra1.add(opcion1);

        opcion2.setText("Crear Proyecto");
        opcion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion2ActionPerformed(evt);
            }
        });
        barra1.add(opcion2);

        opcionesMenu.add(barra1);

        jMenu2.setText("Edit");
        opcionesMenu.add(jMenu2);

        setJMenuBar(opcionesMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        analizarLexico();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        analizarIDE();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void textoPruebaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoPruebaKeyPressed
        String historial = textoHistorial.getText();
        String sentencia = textoPrueba.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(sentencia.endsWith(";")){
                analizarLexico();
                if(historial.equals("")){
                    String modificado = textoPrueba.getText().replaceAll("\n", "");
                    textoHistorial.setText(modificado);
                } else {
                    String modificado = textoPrueba.getText().replaceAll("\n", "");
                    textoHistorial.setText(historial + "\n" + modificado);
                }
                textoPrueba.setText("");
            }
        }
    }//GEN-LAST:event_textoPruebaKeyPressed

    
    
    
    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        JFileChooser chooser;
        chooser = new JFileChooser();
        String seleccion = "Porfavor seleccione el folder del proyecto";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
            /*arbolCarpeta.addMouseListener(new MouseAdapter(){
                            @Override
                            public void mouseClicked(MouseEvent e){
                                if(e.getButton() == 3){
                               doMouseClicked(e);
                                    System.out.println(chooser.getSelectedFile().getAbsolutePath());
                                }
                            }
                        });*/

            
            
        } else {
            System.out.println("No hubo ninguna seleccion");
        }
        DefaultMutableTreeNode dt;
        dt = agregarNodos(null, proyecto);
        model = new DefaultTreeModel(dt, true);
        arbolCarpeta.setModel(model);
        arbolCarpeta.setCellRenderer(new ArbolCompleto());
        arbolCarpeta.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
                System.out.println("Has elegido " + nodo);
                File seleccion = new File(nodo.toString());
                    System.out.println(seleccion.getName());
                if (nodo.toString().endsWith(".csv") || nodo.toString().endsWith(".ide")) {
                    //CONTINUAR AQUI HACIENDO QUE HABRA EL ARCHIVO .CSV EN PESTA;AS DENTRO DEL PANEL DINAMICO
                    System.out.println(seleccion.getName());  
                    String texto = new String();
                    FileReader fr = null;
                    BufferedReader entrada = null;
                    try {
                        fr = new FileReader(nodo.toString());
                        entrada = new BufferedReader(fr);
                       // TextArea text = new TextArea();
                        //TextArea textoBj = new TextArea();
                        while(entrada.ready()){
                            texto += entrada.readLine() +"\n";
                            
                            
                            
                        }
                        
                            abrirPanel(seleccion.getName(), texto, seleccion.toString());
                        //    text.setText("asdf");
                         //   textoBj.setText("area de consultas:");
                        
                       /*arbolCarpeta.addMouseListener(new MouseAdapter(){
                            @Override
                            public void mouseClicked(MouseEvent e){
                                if(e.getButton() == 3){
                               doMouseClicked(e);
                                }
                            }
                        });*/
                       
                       
                       
                       
                       
                         
                         
                            
                        
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
                    }  catch (IOException ex) {
                        Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if(null != fr){
                            try {
                                fr.close();
                            } catch (IOException ex) {
                                Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }                    
                    
                    
                }
            }
        });


    }//GEN-LAST:event_opcion1ActionPerformed

    
    
    void doMouseClicked(MouseEvent me) {
    TreePath tp = arbolCarpeta.getPathForLocation(me.getX(), me.getY());
    int row = arbolCarpeta.getRowForLocation(me.getX(), me.getY());
    TreePath tp2 = arbolCarpeta.getPathForRow(arbolCarpeta.getRowForPath(tp));
    arbolCarpeta.getRowForPath(tp);
    arbolCarpeta.getAnchorSelectionPath();
        System.out.println(tp2);
  }
    
    private void opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ActionPerformed
        
        
        NuevoProyecto nuevo = new NuevoProyecto(this, true);
        nuevo.setVisible(true);
        
        
    }//GEN-LAST:event_opcion2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     ///   panelIDE.addTab("primer panel", panel(;
        
       System.out.println(panelIDE.getSelectedIndex());
       String asd = "";
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.out.println(panelIDE.getTabCount());
        System.out.println(panelIDE.getSelectedIndex());
        
       
        
//seguir con las ventanas del proyecto, con estos datos ya puedes volar maquina del mal xd
        
        //al momento de abrir un archivo, que se abra dentro de los textos de las pesta;as que se lleguen a abrir
        
        
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String texto = textoPrueba.getText();
        AnalizadorLexico3  lexico = new AnalizadorLexico3(new StringReader(texto));
        try {
            new SintaxCSV(lexico).parse();
            textoConsultas.setText("Analisis realizado correctamente");
        } catch (Exception ex) {
            System.out.println("error");
        }
        


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        System.out.println(panelIDE.getSelectedIndex());
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void arbolCarpetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolCarpetaMouseClicked
        if(evt.getButton() == 3){
            JOptionPane.showMessageDialog(null, "hola mushasho");
            TreePath tp = arbolCarpeta.getPathForLocation(evt.getX(), evt.getY());
            tp.getPath();
            System.out.println(tp.getLastPathComponent());
            String a = tp.getLastPathComponent().toString();
            File file = new File(a);
            file.getName();
            if(file.exists()){
                String direccion = a.replace(file.getName(), "");
                System.out.println(direccion);
            
                
                
                
                
                
                
                
                
                
                
                
            
            }
            
            
            
        }
    }//GEN-LAST:event_arbolCarpetaMouseClicked
    
    private JPanel panel(TextArea texto, TextArea texto2){
        JPanel panel = new JPanel();
        BorderLayout layout = new BorderLayout();
        panel.setLayout(layout);
        texto.setBounds(100, 50, 80, 25);
        texto2.setBounds(100, 50, 80, 25);
        panel.add(texto2);
        panel.add(texto);
        System.out.println(texto.getName());
        return panel;
    }
    
    private void abrirPanel(String titulo, String texto, String path){
        PanelModelo panel = new PanelModelo(texto, path);
        panelIDE.addTab(titulo, panel);
        
        
    }
    
    
    
    
    
    
    public void analizarLexico() {
        String texto = textoPrueba.getText();
        AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(texto));
        try {
            new SintacticoMysql(lexico).parse();
            textoConsultas.setText("Analisis realizado correctamente");
        } catch (Exception ex) {
            System.out.println("error");
        }

    }
    
    private void analizarIDE(){
        String texto = textoPrueba2.getText();
        AnalizadorLexico2 lexico = new AnalizadorLexico2(new StringReader(texto));
        try {
            new SintacticoIDE(lexico).parse();
            textoConsultas.setText("analisis realizado al 1000");
        } catch (Exception ex) {
            System.out.println("Error lexico perro");
        }
        
    }
 
    
    DefaultMutableTreeNode agregarNodos(DefaultMutableTreeNode arbol, File dir){
        DefaultMutableTreeNode modelo = new DefaultMutableTreeNode(dir);
        if(arbol != null){
            arbol.add(modelo);
        }
        File[] tmp = dir.listFiles();
        Vector<File> vectorArchivos = new Vector<File>();
        vectorArchivos.addAll(Arrays.asList(tmp));
        Collections.sort(vectorArchivos, new Comparator<File>(){
            @Override
            public int compare(File a1, File a2){
                int resultado = a1.getName().compareTo(a2.getName());
                if(a1.isDirectory() && a2.isFile()){
                    resultado = -1;
                } else if(a2.isDirectory() && a1.isFile()){
                    resultado = 1;
                }
                return resultado;
            }
        });
        for(int num = 0; num < vectorArchivos.size(); num++){
            File archivo = vectorArchivos.elementAt(num);
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(archivo);
            if(archivo.isDirectory()){
                agregarNodos(nodo, archivo);
            }
            modelo.add(nodo);
        }
        return modelo;
    }
    
    public class ArbolCompleto extends DefaultTreeCellRenderer{
        private FileSystemView archivoVista = FileSystemView.getFileSystemView();
        
        @Override
        public Component getTreeCellRendererComponent(JTree arbol, Object valor, boolean boleano1, boolean boleano2, boolean boleano3, int filas, boolean boleano4){
          //  System.out.println(valor);
            super.getTreeCellRendererComponent(arbol, valor, boleano1, boleano2, boleano3, filas, boleano4);
            if(valor instanceof DefaultMutableTreeNode){
                valor = ((DefaultMutableTreeNode)valor).getUserObject();
                if(valor instanceof File){
                    File archivo = (File) valor;
                    if(archivo.isFile()){
                        setIcon(archivoVista.getSystemIcon(archivo));
                        setText(archivo.getPath());
                    } else {
                        setIcon(archivoVista.getSystemIcon(archivo));
                        setText(archivo.getName());
                    }
                }
            }
            return this;
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolCarpeta;
    private javax.swing.JMenu barra1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JMenuItem opcion1;
    private javax.swing.JMenuItem opcion2;
    private javax.swing.JMenuBar opcionesMenu;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTabbedPane panelIDE;
    private javax.swing.JTextArea textoConsultas;
    private javax.swing.JTextArea textoHistorial;
    private javax.swing.JTextArea textoPrueba;
    private javax.swing.JTextArea textoPrueba2;
    // End of variables declaration//GEN-END:variables
}
