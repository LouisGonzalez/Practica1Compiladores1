package pollitos;

/**
 *
 * @author luisGonzalez
 */
public class Filtros {
    
    private Object filtro;
    private int numColumna;
    private Object nombreColumna;
    private int tipoOperacion;
    private int palabra_numero;

    public int getNumColumna() {
        return numColumna;
    }

    public void setNumColumna(int numColumna) {
        this.numColumna = numColumna;
    }

    public int getPalabra_numero() {
        return palabra_numero;
    }

    public void setPalabra_numero(int palabra_numero) {
        this.palabra_numero = palabra_numero;
    }

    public int getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(int tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    public Object getFiltro() {
        return filtro;
    }

    public void setFiltro(Object filtro) {
        this.filtro = filtro;
    }

    public Object getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(Object nombreColumna) {
        this.nombreColumna = nombreColumna;
    }
    
    
    
}
