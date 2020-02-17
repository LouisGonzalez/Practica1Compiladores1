package operacionMysql;

import com.opencsv.CSVWriter;
import gramaticas.AnalizadorLexico3;
import gramaticas.SintaxCSV;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import pollitos.DatosColumna;
import pollitos.NuevaFila;
import pollitos.PolloCSV;
import pollitos.ValoresInsercion;

/**
 *
 * @author luisGonzalez
 */
public class OperacionInsertar {
    
    public void insercionDatos(JTextArea panelResultados, ArrayList<PolloCSV> datosCSV, ArrayList<DatosColumna> listadoColumnas, ArrayList<ValoresInsercion> listadoValores, String path, JTextArea panelPrincipal){
        boolean verificadorColumna = verificadorColumnas(listadoColumnas);
        if (verificadorColumna == true) {
            if (listadoColumnas.size() != listadoValores.size()) {
                System.out.println("Error, ambos parametros deben tener la misma cantidad de objetos");
            } else {
                int i = 0;
                boolean existe = true;
                boolean[] valores = new boolean[listadoColumnas.size() + 1];
                for(DatosColumna datos: listadoColumnas){
                    i++;
                    valores[i] = false;
                    for(PolloCSV pollito: datosCSV){
                        if(pollito.getFila() ==0 && pollito.getDatoColumna().equals(datos.getNombreColumna())){
                            valores[i] = true;
                        }
                    }
                }
                for(int j=1; j < valores.length; j++){
                    System.out.println(valores[j]);
                    if(valores[j] == false){
                        existe = false;
                    }
                }
                if(existe == false){
                    panelResultados.setText("Una o mas columnas no estan bien escritas");
                } else {
                    insertarDatos(listadoColumnas, listadoValores, datosCSV, path, panelPrincipal);
                }
            }
        } else {

        }
        
    }
    
    
    private void insertarDatos(ArrayList<DatosColumna> listadoColumnas, ArrayList<ValoresInsercion> listadoValores, ArrayList<PolloCSV> list, String path, JTextArea panelPrincipal) {
        retornarDato(listadoColumnas, list);
        PolloCSV ultimoDato = list.get(list.size() - 1);
        int fila = list.get(list.size() - 1).getFila();
        ArrayList<NuevaFila> posiciones = new ArrayList<>();
        for (DatosColumna datos : listadoColumnas) {

            for (ValoresInsercion valores1 : listadoValores) {

                if (valores1.getNoDatoInsercion() == datos.getNumColumnaInsercion()) {
                    NuevaFila nuevo = new NuevaFila();
                    nuevo.setDato(valores1.getDato());
                    nuevo.setNoColumna(datos.getNumColumna());
                    posiciones.add(nuevo);
                }

            }

        }
        nuevaFila(ultimoDato, posiciones, fila+1, list, path, panelPrincipal);
    
    }
    
    
    private void nuevaFila(PolloCSV ultimoDato, ArrayList<NuevaFila> posiciones, int fila, ArrayList<PolloCSV> list, String path, JTextArea panelPrincipal) {
        Object datoColumna = null;
        int noColumna = 0;
        int noFila = 0;
        for (int i = 1; i <= ultimoDato.getColumna(); i++) {
            PolloCSV dato = new PolloCSV();
            datoColumna = "";
            noColumna = i;
            noFila = fila;
            for (int j = 0; j <= posiciones.size() - 1; j++) {
                if (i == posiciones.get(j).getNoColumna()) {
                    datoColumna = posiciones.get(j).getDato();
                    noColumna = posiciones.get(j).getNoColumna();
                    noFila = fila;
                }
            }
            dato.setDatoColumna(datoColumna);
            dato.setColumna(noColumna);
            dato.setFila(noFila);
            list.add(dato);
        }
        
        retornarTexto(list, path, panelPrincipal);

    }
    
    private void retornarTexto(ArrayList<PolloCSV> list, String path, JTextArea panelResultados){
        String texto = "";
        int x = 1;
        int totalArreglo = list.size();
        int columnaMaxima = list.get(list.size()-1).getColumna();
        for(int i = 0; i <list.size(); i++){
            if(i == (columnaMaxima*x)-1){
                texto += list.get(i).getDatoColumna()+"\n";
                x++;
            } else {
                texto += list.get(i).getDatoColumna()+ ",";
            }
        }
        try {
            list.clear();
            AnalizadorLexico3 lexico = new AnalizadorLexico3(new StringReader(texto));
            new SintaxCSV(lexico, list).parse();
            System.out.println("Todo funcionando a la perfeccion");
            panelResultados.setText("");
            panelResultados.setText(texto);
            borrarArchivo(path);
            actualizarArchivo(path, texto);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void actualizarArchivo(String path, String texto) throws IOException{
        FileWriter flWriter = null;
        flWriter = new FileWriter(path, true);
        BufferedWriter bfwriter = new BufferedWriter(flWriter);
        bfwriter.write(texto);
        bfwriter.close();
        System.out.println("Archivo modificado satisfactoriamente..");
    }
    
    private void borrarArchivo(String path){
        File archivo = new File(path);
        if(archivo.exists()){
            archivo.delete();
        }
    }
    
    private boolean verificadorColumnas(ArrayList<DatosColumna> columna){
        boolean existenColumnas = false;
        if(columna.get(0) != null){
            existenColumnas = true;
        }
        return existenColumnas;
    }
    
     private ArrayList<DatosColumna> retornarDato(ArrayList<DatosColumna> columna, ArrayList<PolloCSV> list) {
        for (PolloCSV pollito : list) {
            int contColumna = 0;
            for (DatosColumna parametro : columna) {
                if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(parametro.getNombreColumna())) {
                    parametro.setNumColumna(pollito.getColumna());
                    parametro.setNombreColumna(pollito.getDatoColumna());
                    columna.set(contColumna, parametro);
                }
                contColumna++;
            }

        }
        return columna;
    }
    
}
