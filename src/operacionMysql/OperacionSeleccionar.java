package operacionMysql;

import java.util.ArrayList;
import javax.swing.JTextArea;
import pollitos.DatosColumna;
import pollitos.Filtros;
import pollitos.PolloCSV;

/**
 *
 * @author luisGonzalez
 */
public class OperacionSeleccionar {

    private int contador2 = 0;
    private static String opcion1 = "Seleccion";
    private static String opcion2 = "Filtro";

    public void verificarOpcion(JTextArea panelResultados, ArrayList<PolloCSV> datosCSV, ArrayList<DatosColumna> columnas, ArrayList<Filtros> filtro, ArrayList<String> opcion) {
        if (opcion.get(0).equals("opcion1")) {
            System.out.println("no hay columnas de parametros");
        } else if (opcion.get(0).equals("opcion2")) {

        }
    }

    public void comprobacionColumna(JTextArea panelResultados, ArrayList<PolloCSV> datosCSV, ArrayList<DatosColumna> columnas, ArrayList<Filtros> filtro, ArrayList<String> opcion, ArrayList<Integer> and_or, JTextArea panelErrores) {
        String titulos = "";
        boolean existe = true;
        boolean existe2 = false;
        if (filtro.isEmpty()) {
            if (opcion.get(0).equals("opcion1")) {
                String texto = retornarTexto(datosCSV);
                panelResultados.setText(texto);
            } else {
                for (DatosColumna parametro : columnas) {
                    System.out.println(parametro.getNombreColumna()+"ssoy el nombre equisde");
                        for (PolloCSV pollito : datosCSV) {
                        if (parametro.getTipo().equals(opcion1)) {
                            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(parametro.getNombreColumna())) {
                                existe2 = true;
                            }
                        }
                    }
                }
                if(existe2 == true){
                    String texto = filtracionColumna(datosCSV, columnas);
                    panelResultados.setText(texto);
                } else {
                    panelErrores.setText("Una o mas columnas no estan bien escritas");
                }

            }
            System.out.println("no hay filtros dentro de la busqueda");
        } else {
            boolean existenParametros = false;
            int i = 0;
            boolean[] valores = new boolean[columnas.size() + 1];
            for (DatosColumna columna : columnas) {
                i++;
                valores[i] = false;
                for (PolloCSV pollito : datosCSV) {
                    if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(columna.getNombreColumna())) {
                        valores[i] = true;
                    }
                }
            }
            for (int j = 1; j < valores.length; j++) {
                System.out.println(valores[j]);
                if (valores[j] == false) {
                    existe = false;
                }
            }
            if (existe == false) {
                panelErrores.setText("Una o mas columnas no estan bien escritas");

            } else {
                for (DatosColumna columna : columnas) {
                    if (columna.getTipo().equals(opcion1)) {
                        existenParametros = true;
                    }
                }
                System.out.println(existenParametros);
                comparacionDatos(panelResultados, datosCSV, filtro, columnas, existenParametros, and_or);
            }
        }

    }

    public void comparacionDatos(JTextArea panelResultados, ArrayList<PolloCSV> list, ArrayList<Filtros> filtro, ArrayList<DatosColumna> columna, boolean existenParametros, ArrayList<Integer> and_or) {
        int contador = 0;
        String texto = "";
        int noColumna = 0;
        int contArray = 0;
        int tipoFiltro = 0;
        if(and_or.isEmpty()){
            tipoFiltro = 0;
        } else {
            tipoFiltro = and_or.get(0);
        }    
        ArrayList<Integer> filas = new ArrayList<>();
        
        if(tipoFiltro == 2){
            for (Filtros aux : filtro) {
            contador++;
            switch (aux.getTipoOperacion()) {
                case 0:
                    texto += filtracionResultados(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 1:
                    texto += filtracionIgual(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 2:
                    texto += filtracionMayorQue(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 3:
                    texto += filtracionMenorQue(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 4:
                    texto += filtracionMayor_igual(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 5:
                    texto += filtracionMenor_igual(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 6:
                    texto += filtracionMayor_menor(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
            }
        
        }
        } else {
        for (Filtros aux : filtro) {
            contador++;
            switch (aux.getTipoOperacion()) {
                case 0:
                    texto = filtracionResultados(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 1:
                    texto = filtracionIgual(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 2:
                    texto = filtracionMayorQue(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 3:
                    texto = filtracionMenorQue(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 4:
                    texto = filtracionMayor_igual(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 5:
                    texto = filtracionMenor_igual(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
                case 6:
                    texto = filtracionMayor_menor(list, aux, noColumna, contador, filas, texto, columna, existenParametros);
                    break;
            }
        
        }
            
        }
        panelResultados.setText(texto);
        System.out.println(texto);

    }

    private String retornarTexto(ArrayList<PolloCSV> list) {
        String texto = "";
        int x = 1;
        int columnaMaxima = list.get(list.size() - 1).getColumna();
        for (int i = 0; i < list.size(); i++) {
            if (i == (columnaMaxima * x) - 1) {
                texto += list.get(i).getDatoColumna() + "\n";
                x++;
            } else {
                texto += list.get(i).getDatoColumna() + ",";
            }
        }
        return texto;
    }

    private String filtracionResultados(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<DatosColumna> columna, boolean existenParametros) {
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                retornarDato(columna, list);
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (contador == 1) {
                        if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && aux.getFiltro().equals(pollito2.getDatoColumna())) {
                            texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                        }
                    } else {
                        int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                        int aux3 = filas.size();
                        for (int i = aux2; i < aux3; i++) {
                            if (pollito2.getFila() == filas.get(i) && pollito2.getColumna() == noColumna && aux.getFiltro().equals(pollito2.getDatoColumna())) {
                                texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                            }

                        }

                    }
                }
            }
        }
        return texto;
    }

    
    private String filtracionIgual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<DatosColumna> columna, boolean existenParametros, int tipoFiltro) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                retornarDato(columna, list);
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && (pollito2.getColumna() == noColumna) && (auxConvertido == datoColumnaConvertido)) {
                                texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                            }
                        } else {
                       
                            if (tipoFiltro == 1) {

                                int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                                int aux3 = filas.size();
                                for (int i = aux2; i < aux3; i++) {
                                    if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && (auxConvertido == datoColumnaConvertido)) {
                                        texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                                    }
                                }
                           } else if (tipoFiltro == 2) {
                                if (pollito2.getFila() > 0 && (pollito2.getColumna() == noColumna) && (auxConvertido == datoColumnaConvertido)) {
                                    texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                                }  
                            }
                        }
                    }
                }
            }
        }
        return texto;
    }
    
    
    private String filtracionMayorQue(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<DatosColumna> columna, boolean existenParametros) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                retornarDato(columna, list);
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido < datoColumnaConvertido) {
                                texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido < datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                                }
                            }
                        }
                    }
                }
            }
        }
        return texto;
    }


    private String filtracionMenorQue(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<DatosColumna> columna, boolean existenParametros) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                retornarDato(columna, list);
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido > datoColumnaConvertido) {
                                texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido > datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                                }
                            }
                        }
                    }
                }
            }
        }
        return texto;
    }


    private String filtracionMayor_igual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<DatosColumna> columna, boolean existenParametros) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                retornarDato(columna, list);
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido >= datoColumnaConvertido) {
                                texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido >= datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                                }
                            }
                        }
                    }
                }
            }

        }
        return texto;
    }

    private String filtracionMenor_igual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<DatosColumna> columna, boolean existenParametros) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                retornarDato(columna, list);
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido <= datoColumnaConvertido) {
                                texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido <= datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                                }
                            }
                        }
                    }
                }
            }

        }
        return texto;
    }

    private String filtracionMayor_menor(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<DatosColumna> columna, boolean existenParametros) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                retornarDato(columna, list);
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido != datoColumnaConvertido) {
                                texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido != datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                                }
                            }
                        }
                    }
                }
            }

        }
        return texto;
    }

    private int retornarAux(int contador, int valor, int valor2) {
        int aux = 0;
        if (contador == 2) {
            aux = valor;
        } else if (contador > 2) {
            aux = valor2;
        }
        return aux;
    }

    private ArrayList<DatosColumna> retornarDato(ArrayList<DatosColumna> columna, ArrayList<PolloCSV> list) {
        for (PolloCSV pollito : list) {
            int contColumna = 0;
            for (DatosColumna parametro : columna) {
                if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(parametro.getNombreColumna()) && parametro.getTipo().equals(opcion1)) {
                    parametro.setNumColumna(pollito.getColumna());
                    parametro.setNombreColumna(pollito.getDatoColumna());
                    parametro.setTipo(opcion1);
                    columna.set(contColumna, parametro);
                }
                contColumna++;
            }
        }
        return columna;
    }

    private String filtracionColumna(ArrayList<PolloCSV> list, ArrayList<DatosColumna> columna) {
        String texto = "";
        retornarDato(columna, list);
        for (PolloCSV pollito : list) {
            for (DatosColumna parametro : columna) {
                if (parametro.getTipo().equals(opcion1)) {
                    if (pollito.getColumna() == parametro.getNumColumna()) {
                        texto += pollito.getDatoColumna() + " ";
                    } 
                }
            }

        }
        texto += "\n";

        return texto;
    }

    private String retornarTexto(ArrayList<Integer> filas, ArrayList<PolloCSV> list, PolloCSV pollito2, boolean existenParametros, ArrayList<DatosColumna> columna) {
        String texto = "";
        filas.add(pollito2.getFila());
        System.out.println("Estas son las filas que deberian ingresar en el primer tiro" + pollito2.getFila());
        for (PolloCSV pollito3 : list) {
            if (pollito3.getFila() == pollito2.getFila()) {

                if (existenParametros == true) {

                    for (DatosColumna parametro : columna) {
                        if (parametro.getTipo().equals(opcion1)) {
                            if (pollito3.getColumna() == parametro.getNumColumna()) {
                                texto += pollito3.getDatoColumna() + " ";
                            }
                        }
                    }
                } else {
                    if (pollito3.getFila() == pollito2.getFila()) {
                        texto += pollito3.getDatoColumna() + " ";
                    }
                }
            }
        }
        texto += "\n";
        return texto;
    }
    

    private String retornarTexto2(ArrayList<Integer> filas, int i, ArrayList<PolloCSV> list, PolloCSV pollito2, boolean existenParametros, ArrayList<DatosColumna> columna) {
        String texto = "";
        contador2++;
        System.out.println("Estas son las filas que deberian de pasar despues de   " + filas.get(i));
        filas.add(filas.get(i));
        for (PolloCSV pollito3 : list) {
            if (pollito3.getFila() == pollito2.getFila()) {
                if (existenParametros == true) {
                    for (DatosColumna parametro : columna) {
                        if (parametro.getTipo().equals(opcion1)) {
                            if (pollito3.getColumna() == parametro.getNumColumna()) {
                                texto += pollito3.getDatoColumna() + " ";
                            }
                        }
                    }
                } else {
                    if (pollito3.getFila() == filas.get(i)) {
                        texto += pollito3.getDatoColumna() + " ";
                    }
                }
            }
        }
        texto += "\n";
        return texto;
    }

}
