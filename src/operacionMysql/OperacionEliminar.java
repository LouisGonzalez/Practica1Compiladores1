package operacionMysql;

import gramaticas.AnalizadorLexico3;
import gramaticas.SintaxCSV;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextArea;
import pollitos.Filtros;
import pollitos.PolloCSV;

/**
 *
 * @author luisGonzalez
 */
public class OperacionEliminar {

    private int contador2 = 0;
   
    public void eliminacionFilas(ArrayList<PolloCSV> list, ArrayList<Filtros> listadoFiltros, JTextArea panelResultados, JTextArea panelTexto, String path) {
        int i = 0;
        boolean existe = true;
        if (listadoFiltros.isEmpty()) {
            retornoSinFiltro(list);
            retornarTexto(list, path, panelTexto);
        } else {
            boolean[] valores = new boolean[listadoFiltros.size() + 1];
            for (Filtros filtro : listadoFiltros) {
                i++;
                valores[i] = false;
                for (PolloCSV pollito : list) {
                    if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(filtro.getNombreColumna())) {
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
                panelResultados.setText("Una o mas columnas no estan bien escritas");
            } else {
                validacionFilas(list, listadoFiltros, panelTexto, path);
            }
        }
    }

    public void validacionFilas(ArrayList<PolloCSV> list, ArrayList<Filtros> listadoFiltros, JTextArea panelTexto, String path) {
        int contador = 0;
        int noColumna = 0;
        String texto = "";
        ArrayList<Integer> filas = new ArrayList<>();
        for (Filtros aux : listadoFiltros) {
            contador++;
            switch (aux.getTipoOperacion()) {
                case 0:
                    filtracionResultados(list, aux, noColumna, contador, filas, texto);
                    break;
                case 1:
                    filtracionIgual(list, aux, noColumna, contador, filas, texto);
                    break;
                case 2:
                    filtracionMayorQue(list, aux, noColumna, contador, filas, texto);
                    break;
                case 3:
                    filtracionMenorQue(list, aux, noColumna, contador, filas, texto);
                    break;
                case 4:
                    filtracionMayor_igual(list, aux, noColumna, contador, filas, texto);
                    break;
                case 5:
                    filtracionMenor_igual(list, aux, noColumna, contador, filas, texto);
                    break;
                case 6:
                    filtracionMayor_menor(list, aux, noColumna, contador, filas, texto);
                    break;
            }
        }
        int aux2 = retornarAux2(contador, 0, filas.size() - contador2);
        int aux3 = filas.size();
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).getFila() != 0) {
                for (int i = aux2; i < aux3; i++) {
                    if (list.get(j).getFila() == filas.get(i)) {
                        list.remove(j);
                        j--;
                    }
                }
            }

        }
        retornarTexto(list, path, panelTexto);

    }

    private void retornarTexto(ArrayList<PolloCSV> list, String path, JTextArea panelTexto) {
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
        try {
            list.clear();
            AnalizadorLexico3 lexico = new AnalizadorLexico3(new StringReader(texto));
            new SintaxCSV(lexico, list).parse();
            System.out.println("Todo funcionando a la perfeccion");
            panelTexto.setText("");
            panelTexto.setText(texto);
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

    private void filtracionResultados(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto) {
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (contador == 1) {
                        if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && aux.getFiltro().equals(pollito2.getDatoColumna())) {
                            texto += retornarTexto(filas, pollito2);
                        }
                    } else {
                        int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                        int aux3 = filas.size();
                        for (int i = aux2; i < aux3; i++) {
                            if (pollito2.getFila() == filas.get(i) && pollito2.getColumna() == noColumna && aux.getFiltro().equals(pollito2.getDatoColumna())) {
                                texto += retornarTexto2(filas, i);
                            }

                        }

                    }

                }
            }
        }
    }

    private void filtracionIgual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && (pollito2.getColumna() == noColumna) && (auxConvertido == datoColumnaConvertido)) {
                                texto += retornarTexto(filas, pollito2);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && (auxConvertido == datoColumnaConvertido)) {
                                    texto += retornarTexto2(filas, i);
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    private void filtracionMayorQue(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido < datoColumnaConvertido) {
                                texto += retornarTexto(filas, pollito2);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido < datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void filtracionMenorQue(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido > datoColumnaConvertido) {
                                texto += retornarTexto(filas, pollito2);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido > datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void filtracionMayor_igual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido >= datoColumnaConvertido) {
                                texto += retornarTexto(filas, pollito2);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido >= datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void filtracionMenor_igual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido <= datoColumnaConvertido) {
                                texto += retornarTexto(filas, pollito2);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido <= datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i);
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    private String filtracionMayor_menor(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto) {
        int auxConvertido = (Integer) aux.getFiltro();
        for (PolloCSV pollito : list) {
            if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(aux.getNombreColumna())) {
                noColumna = pollito.getColumna();
                texto = "";
                for (PolloCSV pollito2 : list) {
                    if (pollito2.getTipoValor() == 2) {
                        int datoColumnaConvertido = (Integer) pollito2.getDatoColumna();
                        if (contador == 1) {
                            if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido != datoColumnaConvertido) {
                                texto += retornarTexto(filas, pollito2);
                            }
                        } else {
                            int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                            int aux3 = filas.size();
                            for (int i = aux2; i < aux3; i++) {
                                if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && auxConvertido != datoColumnaConvertido) {
                                    texto += retornarTexto2(filas, i);
                                }
                            }
                        }
                    }
                }
            }
        }
        return texto;
    }

    private ArrayList<PolloCSV> retornoSinFiltro(ArrayList<PolloCSV> list) {
        Iterator<PolloCSV> eliminar = list.iterator();
        while (eliminar.hasNext()) {
            if (eliminar.next().getFila() > 0) {
                eliminar.remove();
            }
        }
        return list;
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

    private int retornarAux2(int contador, int valor, int valor2) {
        int aux = 0;
        if (contador == 1) {
            aux = valor;
        } else if (contador > 1) {
            aux = valor2;
        }
        return aux;
    }

    private String retornarTexto(ArrayList<Integer> filas, PolloCSV pollito2) {
        String texto = "";
        filas.add(pollito2.getFila());
        System.out.println("Estas son las filas que deberian ingresar en el primer tiro" + pollito2.getFila());
        return texto;
    }

    private String retornarTexto2(ArrayList<Integer> filas, int i) {
        String texto = "";
        contador2++;
        System.out.println("Estas son las filas que deberian de pasar despues de   " + filas.get(i));
        filas.add(filas.get(i));
        return texto;
    }

}
