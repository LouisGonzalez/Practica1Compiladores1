package pollitos;

/**
 *
 * @author luisGonzalez
 */
public class DatosColumna {
    
    private Object nombreColumna;
    private String tipo;
    private int numColumna;
    private int numColumnaInsercion;

    public int getNumColumnaInsercion() {
        return numColumnaInsercion;
    }

    public void setNumColumnaInsercion(int numColumnaInsercion) {
        this.numColumnaInsercion = numColumnaInsercion;
    }
    
    public int getNumColumna() {
        return numColumna;
    }

    public void setNumColumna(int numColumna) {
        this.numColumna = numColumna;
    }

    public Object getNombreColumna() {
        return nombreColumna;
    }

    public void setNombreColumna(Object nombreColumna) {
        this.nombreColumna = nombreColumna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
