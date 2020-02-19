package paneles;
import com.sun.glass.events.KeyEvent;
import gramaticas.AnalizadorLexico3;
import gramaticas.AnalizadorLexico4;
import gramaticas.SintacticoPersonal;
import gramaticas.SintaxCSV;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import operacionMysql.OperacionActualizar;
import operacionMysql.OperacionEliminar;
import operacionMysql.OperacionInsertar;
import operacionMysql.OperacionSeleccionar;
import pollitos.DatosColumna;
import pollitos.Filtros;
import pollitos.PolloCSV;
import pollitos.Sentencias;
import pollitos.ValoresInsercion;

/**
 *
 * @author luisGonzalez
 */
public class PanelModelo extends javax.swing.JPanel {

    ArrayList<PolloCSV> list = new ArrayList<>();
    private OperacionSeleccionar seleccion;
    private OperacionInsertar insercion;
    private OperacionActualizar actualizacion;
    private OperacionEliminar eliminacion;
    String path;
    
     private JLabel L;
  private JButton B;
  private int size=10;

    /**
     * Creates new form PanelModelo
     * @param texto
     * @param path
     * @param listaArchivos
     */
    public PanelModelo(String texto, String path) {
        initComponents();
        this.path = path;
        panelTexto.setText(texto);
        AnalizadorLexico3 lexico = new AnalizadorLexico3(new StringReader(texto));
        try {
            new SintaxCSV(lexico, list).parse();
            System.out.println("Todo funcionando a la perfeccion");
        } catch (Exception ex) {
            System.out.println("Ha ocurrido un error D:");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        panelTexto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelConsultas = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        panelResultados = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        panelHistorial = new javax.swing.JTextArea();
        btnModificar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        panelErrores = new javax.swing.JTextArea();
        btnLimpieza = new javax.swing.JButton();

        panelTexto.setColumns(20);
        panelTexto.setRows(5);
        jScrollPane1.setViewportView(panelTexto);

        panelConsultas.setColumns(20);
        panelConsultas.setRows(5);
        panelConsultas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                panelConsultasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(panelConsultas);

        panelResultados.setColumns(20);
        panelResultados.setRows(5);
        jScrollPane3.setViewportView(panelResultados);

        panelHistorial.setColumns(20);
        panelHistorial.setRows(5);
        jScrollPane4.setViewportView(panelHistorial);

        btnModificar.setText("Modificar CSV");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        panelErrores.setColumns(20);
        panelErrores.setRows(5);
        jScrollPane5.setViewportView(panelErrores);

        btnLimpieza.setText("Limpiar Historial");
        btnLimpieza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiezaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                            .addComponent(btnLimpieza, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpieza))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void panelConsultasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelConsultasKeyPressed
        String texto = panelConsultas.getText();
        String historial = panelHistorial.getText();
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
          if(texto.endsWith(";")){
              analizador();
          }
        }
    }//GEN-LAST:event_panelConsultasKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        list.clear();
        panelTexto.getText();
        try {
            borrarArchivo(path);
            actualizarArchivo(path, panelTexto.getText());
            AnalizadorLexico3 lexico = new AnalizadorLexico3(new StringReader(panelTexto.getText()));
            new SintaxCSV(lexico, list).parse();
        } catch (IOException ex) {
            Logger.getLogger(PanelModelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PanelModelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiezaActionPerformed
        panelHistorial.setText("");
    }//GEN-LAST:event_btnLimpiezaActionPerformed

    private void analizador(){
        String historial = panelHistorial.getText();
        String texto = panelConsultas.getText();
        seleccion = new OperacionSeleccionar();
        insercion = new OperacionInsertar();
        actualizacion = new OperacionActualizar();
        eliminacion = new OperacionEliminar();
        AnalizadorLexico4 lexico = new AnalizadorLexico4(new StringReader(texto));
            ArrayList<DatosColumna> listadoColumnas = new ArrayList<>();
            ArrayList<Filtros> listadoFiltro = new ArrayList<>();
            ArrayList<String> opcion = new ArrayList<>();
            ArrayList<Integer> opcionesPrincipales = new ArrayList<>();
            ArrayList<ValoresInsercion> listadoValores = new ArrayList<>();
            ArrayList<Sentencias> listadoNuevosDatos = new ArrayList<>();
            ArrayList<Integer> and_or = new ArrayList<>();
        try {
            new SintacticoPersonal(lexico, list, listadoColumnas, listadoFiltro, opcion, opcionesPrincipales, listadoValores, listadoNuevosDatos, and_or).parse();
            panelErrores.setText("Analisis realizado correctamente");
               if(historial.equals("")){
                  String modificado = panelConsultas.getText().replaceAll("\n", "");
                  panelHistorial.setText(modificado);
              } else {
                  String modificado = panelConsultas.getText().replaceAll("\n", "");
                  panelHistorial.setText(historial + "\n" + modificado);
              }
              panelConsultas.setText("");
         
            
        } catch (Exception ex) {
            Logger.getLogger(PanelModelo.class.getName()).log(Level.SEVERE, null, ex);
            panelErrores.setText("Error sintactico dentro de la sentencia");
        }
            if(null != opcionesPrincipales.get(0))
                switch (opcionesPrincipales.get(0)) {
            case 1:
                seleccion.comprobacionColumna(panelResultados, list, listadoColumnas, listadoFiltro, opcion, and_or, panelErrores);
                break;
            case 2:
                insercion.insercionDatos(panelErrores, list, listadoColumnas, listadoValores, path, panelTexto);
                break;
            case 3:
                actualizacion.actualizacionDato(panelErrores, listadoNuevosDatos, listadoFiltro, list, path, panelTexto, and_or);
                break;
            case 4:
                eliminacion.eliminacionFilas(list, listadoFiltro, panelErrores, panelTexto, path, and_or);
                break;
            default:
                break;
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

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpieza;
    private javax.swing.JButton btnModificar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea panelConsultas;
    private javax.swing.JTextArea panelErrores;
    private javax.swing.JTextArea panelHistorial;
    private javax.swing.JTextArea panelResultados;
    private javax.swing.JTextArea panelTexto;
    // End of variables declaration//GEN-END:variables
}
