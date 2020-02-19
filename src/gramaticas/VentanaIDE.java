package gramaticas;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import paneles.PanelModelo;
import pollitos.ArchivosIDE;

/**
 *
 * @author luisGonzalez
 */
public class VentanaIDE extends javax.swing.JFrame {

    private File proyecto;
    private DefaultTreeModel model;
    private String archivoPrincipal = "";
 
    public VentanaIDE() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        panelIDE = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolCarpeta = new javax.swing.JTree();
        opcionesMenu = new javax.swing.JMenuBar();
        barra1 = new javax.swing.JMenu();
        opcion1 = new javax.swing.JMenuItem();
        opcion2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelFondo.add(panelIDE, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 760, 570));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arbolCarpeta.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolCarpeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolCarpetaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(arbolCarpeta);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 10, 130, 560));

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
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        ArrayList<ArchivosIDE> archivos = new ArrayList<>();
        JFileChooser chooser;
        chooser = new JFileChooser();
        String path = "";
        String seleccion = "Porfavor seleccione el folder del proyecto";
        chooser.setCurrentDirectory(new File("."));
        chooser.setDialogTitle(seleccion);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
            System.out.println("getSelectedFile(): " + chooser.getSelectedFile());
            archivoPrincipal = chooser.getSelectedFile().toString();
            proyecto = new File(chooser.getSelectedFile().getAbsolutePath());
            path = chooser.getSelectedFile().toString();
        } else {
            JOptionPane.showMessageDialog(null, "No hubo ninguna seleccion");
        }
        File ide = new File(path+"/DATA.ide");
        if (ide.exists()) {
            String ideGramatica = "";
            String linea;
            try {
                FileReader fr = new FileReader(ide);
                BufferedReader br = new BufferedReader(fr);
                while((linea = br.readLine())!=null){
                    ideGramatica += linea;
                }
                AnalizadorLexico2 lexico = new AnalizadorLexico2(new StringReader(ideGramatica));
        try {
            new SintacticoIDE(lexico, archivos).parse();
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
                        System.out.println(seleccion.getName());
                        String texto = new String();
                        FileReader fr = null;
                        BufferedReader entrada = null;
                        try {
                            fr = new FileReader(nodo.toString());
                            entrada = new BufferedReader(fr);
                            while (entrada.ready()) {
                                texto += entrada.readLine() + "\n";

                            }
                               abrirPanel(seleccion.getName(), texto, seleccion.toString());
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            if (null != fr) {
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
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error de gramatica dentro del ide");
        }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El archivo que deseas abrir no es un proyecto compatible");
        }
    }//GEN-LAST:event_opcion1ActionPerformed

    
    private void opcion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion2ActionPerformed
        NuevoProyecto nuevo = new NuevoProyecto(this, true);
        nuevo.setVisible(true);
    }//GEN-LAST:event_opcion2ActionPerformed

    private void arbolCarpetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolCarpetaMouseClicked
        ArrayList<String> filasIDE = new ArrayList<>();
        if(evt.getButton() == 3){
            String direccion = "";
            TreePath tp = arbolCarpeta.getPathForLocation(evt.getX(), evt.getY());
            tp.getPath();
            System.out.println(tp.getLastPathComponent());
            String a = tp.getLastPathComponent().toString();
            File file = new File(a);
            file.getName();
            if(file.exists()){
                direccion = a.replace(file.getName(), "");
                System.out.println(direccion);
            }
            String[] paths = direccion.split("/");
            try {
                FileReader fr = new FileReader(archivoPrincipal+"/DATA.ide");
                BufferedReader br = new BufferedReader(fr);
                String linea;
                int contador = 0;
                int aux = 0;
                while((linea = br.readLine()) != null){
                    contador++;
                    filasIDE.add(linea);
                    if(linea.equals("<PROYECTO nombre=\""+paths[paths.length-1]+"\">") || linea.equals("<CARPETA nombre=\""+paths[paths.length-1]+"\">")){
                        System.out.println("se encontro una coincidencia en la linea "+contador);
                        aux = contador;
                    }
                }
                NuevoElementoProyecto nuevo = new NuevoElementoProyecto(this, true, aux, filasIDE, direccion);
                nuevo.setVisible(true);
                retornarTexto(filasIDE, archivoPrincipal+"/DATA.ide");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VentanaIDE.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_arbolCarpetaMouseClicked
    private void retornarTexto(ArrayList<String> list, String path) {
        String texto = "";
        for (String c : list) {
            texto += c + "\n";
        }
        try {
            System.out.println("Todo funcionando a la perfeccion");
            borrarArchivo(path);
            actualizarArchivo(path, texto);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void actualizarArchivo(String path, String texto) throws IOException {
        FileWriter flWriter = null;
        flWriter = new FileWriter(path, true);
        BufferedWriter bfwriter = new BufferedWriter(flWriter);
        bfwriter.write(texto);
        bfwriter.close();
        System.out.println("Archivo modificado satisfactoriamente..");
    }

    private void borrarArchivo(String path) {
        File archivo = new File(path);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
    
    private void abrirPanel(String titulo, String texto, String path){
        PanelModelo panel = new PanelModelo(texto, path);
        panelIDE.addTab(titulo, panel);
        panelIDE.setTabComponentAt(panelIDE.getTabCount()-1, crearCabecera(titulo));
        
    }
    
    public JPanel crearCabecera(String texto) {
        final String titulo = texto;
        JPanel pnlTab = new JPanel();
        pnlTab.setLayout(new BoxLayout(pnlTab, BoxLayout.LINE_AXIS));
        pnlTab.setOpaque(false);
        JButton btnCerrar = new JButton("x");
        btnCerrar.setPreferredSize(new java.awt.Dimension(10,10));
        JLabel lblTitulo = new JLabel(texto + "    ");
        btnCerrar.setBorderPainted(false);
        btnCerrar.setOpaque(false);
        btnCerrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            int i;
            for (i = 0; i <= panelIDE.getTabCount() - 1; i++){
                if (titulo.equals(panelIDE.getTitleAt(i))) {
                    break;
                }
            }
            panelIDE.removeTabAt(i);
        }
    });
    pnlTab.add(lblTitulo);
    pnlTab.add(btnCerrar);
    return pnlTab;
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
            super.getTreeCellRendererComponent(arbol, valor, boleano1, boleano2, boleano3, filas, boleano4);
            if(valor instanceof DefaultMutableTreeNode){
                valor = ((DefaultMutableTreeNode)valor).getUserObject();
                if(valor instanceof File){
                    File archivo = (File) valor;
                    if(archivo.isFile()){
                        setIcon(archivoVista.getSystemIcon(archivo));
                        setText(archivo.getName());
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem opcion1;
    private javax.swing.JMenuItem opcion2;
    private javax.swing.JMenuBar opcionesMenu;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTabbedPane panelIDE;
    // End of variables declaration//GEN-END:variables
}
