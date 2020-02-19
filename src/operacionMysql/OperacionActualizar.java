package operacionMysql;

import gramaticas.AnalizadorLexico3;
import gramaticas.SintaxCSV;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JTextArea;
import pollitos.Filtros;
import pollitos.PolloCSV;
import pollitos.Sentencias;

/**
 *
 * @author luisGonzalez
 */
public class OperacionActualizar {

    private int contador2 = 0;

    public void actualizacionDato(JTextArea panelResultados, ArrayList<Sentencias> listadoNuevosDatos, ArrayList<Filtros> listadoFiltros, ArrayList<PolloCSV> list, String path, JTextArea panelTexto, ArrayList<Integer> and_or) {
        int i = 0;
        int y = 0;
        boolean existe = true;
        boolean existe2 = true;
        boolean existenParametros = true;
        boolean[] valoresS = new boolean[listadoNuevosDatos.size() + 1];
        for (Sentencias filtro : listadoNuevosDatos) {
            i++;
            valoresS[i] = false;
            for (PolloCSV pollito : list) {
                if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(filtro.getNombreColumna())) {
                    valoresS[i] = true;
                }
            }
        }
        for (int j = 1; j < valoresS.length; j++) {
            System.out.println(valoresS[j]);
            if (valoresS[j] == false) {
                existe2 = false;
            }
        }
        if (existe2 == false) {
            panelResultados.setText("La(s) columna(s) que desea actualizar no existen dentro de la base de datos");
        } else {
            if (listadoFiltros.isEmpty()) {

                retornoSinFiltro(list, listadoNuevosDatos);
                retornarTexto(list, path, panelTexto);

            } else {

                boolean[] valores = new boolean[listadoFiltros.size() + 1];
                for (Filtros filtro : listadoFiltros) {
                    y++;
                    valores[y] = false;
                    for (PolloCSV pollito : list) {
                        if (pollito.getFila() == 0 && pollito.getDatoColumna().equals(filtro.getNombreColumna())) {
                            valores[y] = true;
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
                    comparacionDatos(panelTexto, list, listadoFiltros, listadoNuevosDatos, existenParametros, path, and_or);

                }
            }

        }

    }

    public void comparacionDatos(JTextArea panelTexto, ArrayList<PolloCSV> list, ArrayList<Filtros> filtro, ArrayList<Sentencias> columna, boolean existenParametros, String path, ArrayList<Integer> and_or) {
        int contador = 0;
        String texto = "";
        int noColumna = 0;
        int tipoFiltro = 0;
        if (and_or.isEmpty()) {
            tipoFiltro = 0;
        } else {
            tipoFiltro = and_or.get(0);
        }
        ArrayList<Integer> filas = new ArrayList<>();
        for (Filtros aux : filtro) {
            contador++;
            switch (aux.getTipoOperacion()) {
                case 0:
                    filtracionResultados(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 1:
                    filtracionIgual(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 2:
                    filtracionMayorQue(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 3:
                    filtracionMenorQue(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 4:
                    filtracionMayor_igual(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 5:
                    filtracionMenor_igual(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
                case 6:
                    filtracionMayor_menor(list, aux, noColumna, contador, filas, texto, columna, existenParametros, tipoFiltro);
                    break;
            }
        }

        if (tipoFiltro == 2) {
            ArrayList<Integer> filasOr = new ArrayList<>();
            ArrayList<Integer> listaAux = (ArrayList<Integer>) filas.clone();
            while (listaAux.size() > 0) {
                int valor = listaAux.get(0);
                for (int i = 0; i < listaAux.size(); i++) {
                    if (valor == listaAux.get(i)) {
                        listaAux.remove(i);
                        i--;
                    }
                }
                filasOr.add(valor);
            }
            retornoDatos(list, columna, 0, filasOr.size(), filasOr);
        } else {
            int aux2 = retornarAux2(contador, 0, filas.size() - contador2);
            int aux3 = filas.size();
            retornoDatos(list, columna, aux2, aux3, filas);

        }
        retornarTexto(list, path, panelTexto);

    }

    private ArrayList<PolloCSV> retornoDatos(ArrayList<PolloCSV> list, ArrayList<Sentencias> columna, int parametro1, int parametro2, ArrayList<Integer> filas) {
        int contCambio = 0;
        for (PolloCSV pollito3 : list) {
            for (Sentencias parametro : columna) {
                if (pollito3.getColumna() == parametro.getNumColumna()) {
                    for (int i = parametro1; i < parametro2; i++) {
                        if (pollito3.getFila() == filas.get(i)) {
                            pollito3.setDatoColumna(parametro.getNuevoDato());
                            boolean verificador = isNumeric((String) parametro.getNuevoDato());
                            if (verificador == true) {
                                pollito3.setTipoValor(2);
                            } else {
                                pollito3.setTipoValor(1);
                            }
                            list.set(contCambio, pollito3);
                        }
                    }
                }
            }
            contCambio++;
        }
        return list;

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

    private void filtracionResultados(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<Sentencias> columna, boolean existenParametros, int tipoFiltro) {
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
                        if (tipoFiltro == 2) {
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
        }
    }

    private void filtracionIgual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<Sentencias> columna, boolean existenParametros, int tipoFiltro) {
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
                            if (tipoFiltro == 2) {
                                if (pollito2.getFila() > 0 && pollito2.getColumna() == noColumna && auxConvertido == datoColumnaConvertido) {
                                    texto += retornarTexto(filas, list, pollito2, existenParametros, columna);
                                }
                            } else {
                                int aux2 = retornarAux(contador, 0, filas.size() - contador2);
                                int aux3 = filas.size();
                                for (int i = aux2; i < aux3; i++) {
                                    if (pollito2.getFila() == filas.get(i) && (pollito2.getColumna() == noColumna) && (auxConvertido == datoColumnaConvertido)) {
                                        texto += retornarTexto2(filas, i, list, pollito2, existenParametros, columna);
                                    }

                                }
                            }
                        }

                    }
                }

            }
        }
    }

    private void filtracionMayorQue(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<Sentencias> columna, boolean existenParametros, int tipoFiltro) {
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
                            if (tipoFiltro == 2) {
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
        }
    }

    private void filtracionMenorQue(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<Sentencias> columna, boolean existenParametros, int tipoFiltro) {
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
                            if (tipoFiltro == 2) {
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
        }
    }

    private void filtracionMayor_igual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<Sentencias> columna, boolean existenParametros, int tipoFiltro) {
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
                            if (tipoFiltro == 2) {
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

        }
    }

    private void filtracionMenor_igual(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<Sentencias> columna, boolean existenParametros, int tipoFiltro) {
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
                            if (tipoFiltro == 2) {
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

        }
    }

    private ArrayList<PolloCSV> retornoSinFiltro(ArrayList<PolloCSV> list, ArrayList<Sentencias> listadoDatos) {
        retornarDato(listadoDatos, list);
        int contador = 0;
        for (PolloCSV pollito2 : list) {
            for (Sentencias sentencia : listadoDatos) {
                if (sentencia.getNumColumna() == pollito2.getColumna() && pollito2.getFila() > 0) {
                    pollito2.setDatoColumna(sentencia.getNuevoDato());
                    list.set(contador, pollito2);
                }
            }
            contador++;
        }
        return list;
    }

    private String filtracionMayor_menor(ArrayList<PolloCSV> list, Filtros aux, int noColumna, int contador, ArrayList<Integer> filas, String texto, ArrayList<Sentencias> columna, boolean existenParametros, int tipoFiltro) {
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
                            if (tipoFiltro == 2) {
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

    private int retornarAux2(int contador, int valor, int valor2) {
        int aux = 0;
        if (contador == 1) {
            aux = valor;
        } else if (contador > 1) {
            aux = valor2;
        }
        return aux;
    }

    private ArrayList<Sentencias> retornarDato(ArrayList<Sentencias> columna, ArrayList<PolloCSV> list) {
        for (PolloCSV pollito : list) {
            int contColumna = 0;
            for (Sentencias parametro : columna) {
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

    private String retornarTexto(ArrayList<Integer> filas, ArrayList<PolloCSV> list, PolloCSV pollito2, boolean existenParametros, ArrayList<Sentencias> columna) {
        String texto = "";
        filas.add(pollito2.getFila());
        System.out.println("Estas son las filas que deberian ingresar en el primer tiro" + pollito2.getFila());

        return texto;
    }

    private String retornarTexto2(ArrayList<Integer> filas, int i, ArrayList<PolloCSV> list, PolloCSV pollito2, boolean existenParametros, ArrayList<Sentencias> columna) {
        String texto = "";
        contador2++;
        System.out.println("Estas son las filas que deberian de pasar despues de   " + filas.get(i));
        filas.add(filas.get(i));
        return texto;
    }

    private static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
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

}
