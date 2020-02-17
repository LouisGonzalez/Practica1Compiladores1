package pollitos;

import java.util.ArrayList;

/**
 *
 * @author luisGonzalez
 */
public class PolloCSV {
    
    private int fila;
    private int columna;
    private Object datoColumna;
    private String tipo;
    private int tipoValor;

    public int getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(int tipoValor) {
        this.tipoValor = tipoValor;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Object getDatoColumna() {
        return datoColumna;
    }

    public void setDatoColumna(Object datoColumna) {
        this.datoColumna = datoColumna;
    }

    
    
            
}
