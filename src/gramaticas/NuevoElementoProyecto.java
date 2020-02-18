package gramaticas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luisGonzalez
 */
public class NuevoElementoProyecto extends javax.swing.JDialog {

    
    private int aux;
    private String path;
    private ArrayList<String> filasIDE;
    

    public NuevoElementoProyecto() {
    }
    /**
     * Creates new form NuevoElementoProyecto
     */
    public NuevoElementoProyecto(java.awt.Frame parent, boolean modal, int aux, ArrayList<String> filasIDE, String path) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.aux = aux;
        this.path = path;
        this.filasIDE = filasIDE;
        
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreTxt = new javax.swing.JTextField();
        tipoElemento = new javax.swing.JComboBox<>();
        btnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        tipoElemento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Archivo", "Carpeta" }));

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(tipoElemento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoElemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrear))
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
    if(nombreTxt == null){
        JOptionPane.showMessageDialog(null, "Llene el campo de texto porfavor");
    } else{
        if(tipoElemento.getSelectedItem().equals("Archivo")){
            File archivo = new File(path+nombreTxt.getText()+".csv");
            if(archivo.exists()){
                JOptionPane.showMessageDialog(null, "Dos archivos dentro de una carpeta no pueden tener el mismo nombre");
            } else {
                try {
                    archivo.createNewFile();
                    filasIDE.add(aux, "<ARCHIVO nombre=\""+nombreTxt.getText()+"\" ubicacion=\""+path+nombreTxt.getText()+".csv"+"\"/>");
                } catch (IOException ex) {
                    Logger.getLogger(NuevoElementoProyecto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        } else if(tipoElemento.getSelectedItem().equals("Carpeta")){
            File directorio = new File(path+nombreTxt.getText());
                if(directorio.exists()){
                    JOptionPane.showMessageDialog(null, "Ya existe una carpeta con el mismo nombre dentro del directorio");
                } else {
                    if(directorio.mkdirs()){
                        JOptionPane.showMessageDialog(null, "Carpeta creada con exito");
                        filasIDE.add(aux, "<CARPETA nombre=\""+nombreTxt.getText()+"\">");
                        filasIDE.add(aux+1, "</CARPETA>");
                        File primero = new File(path+nombreTxt.getText()+"/index.bin");
                        if(!primero.exists()){
                            try {
                                primero.createNewFile();
                            } catch (IOException ex) {
                                Logger.getLogger(NuevoElementoProyecto.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "error al crear la carpeta");
                    }
                }
        }
           
            
       this.dispose();
    }//GEN-LAST:event_btnCrearActionPerformed

    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nombreTxt;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JComboBox<String> tipoElemento;
    // End of variables declaration//GEN-END:variables
}
