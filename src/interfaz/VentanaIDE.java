package interfaz;
import java.awt.Component;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.*;


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
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCarpeta = new javax.swing.JTree();
        abrirProyecto = new javax.swing.JButton();
        panelArchivos = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textoErrores = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoConsultas = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoPrueba = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arbolCarpeta.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(arbolCarpeta);

        abrirProyecto.setText("Abrir Proyecto");
        abrirProyecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirProyectoActionPerformed(evt);
            }
        });

        textoErrores.setColumns(20);
        textoErrores.setRows(5);
        jScrollPane2.setViewportView(textoErrores);

        textoConsultas.setColumns(20);
        textoConsultas.setRows(5);
        jScrollPane3.setViewportView(textoConsultas);

        textoPrueba.setColumns(20);
        textoPrueba.setRows(5);
        jScrollPane4.setViewportView(textoPrueba);

        jButton1.setText("lexico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sintactico");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(abrirProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelFondoLayout.createSequentialGroup()
                                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelFondoLayout.createSequentialGroup()
                                                .addGap(0, 5, Short.MAX_VALUE)
                                                .addComponent(panelArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(panelFondoLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2)
                                        .addGap(57, 57, 57)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3))
                        .addContainerGap())))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(abrirProyecto)
                .addGap(18, 18, 18)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(panelFondoLayout.createSequentialGroup()
                                .addComponent(panelArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)))
                        .addComponent(jScrollPane3))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirProyectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirProyectoActionPerformed
            JFileChooser chooser;
            chooser = new JFileChooser();
            String seleccion = "Porfavor seleccione el folder del proyecto";
            chooser.setCurrentDirectory(new File("."));
            chooser.setDialogTitle(seleccion);
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        
            chooser.setAcceptAllFileFilterUsed(false);
        
            if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
                System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
                proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
            } else {
                System.out.println("No hubo ninguna seleccion");
            }
            DefaultMutableTreeNode dt;
            dt = agregarNodos(null, proyecto);
            model = new DefaultTreeModel(dt, true);
            arbolCarpeta.setModel(model);
            arbolCarpeta.setCellRenderer(new ArbolCompleto());
            arbolCarpeta.addTreeSelectionListener(new TreeSelectionListener(){
            @Override
                public void valueChanged(TreeSelectionEvent e) {
                    DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
                    System.out.println("Has elegido " + nodo);
                        File seleccion = new File(nodo.toString());
                        if(nodo.toString().endsWith(".csv")){
                            
                            //CONTINUAR AQUI HACIENDO QUE HABRA EL ARCHIVO .CSV EN PESTA;AS DENTRO DEL PANEL DINAMICO
                       
                            
                            
                            
                            
                            System.out.println("FUNCIONANDO");
                        } 
                }
            });
            
    }//GEN-LAST:event_abrirProyectoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String texto = this.textoPrueba.getText();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void analizarLexico(){
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton abrirProyecto;
    private javax.swing.JTree arbolCarpeta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane panelArchivos;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextArea textoConsultas;
    private javax.swing.JTextArea textoErrores;
    private javax.swing.JTextArea textoPrueba;
    // End of variables declaration//GEN-END:variables
}
