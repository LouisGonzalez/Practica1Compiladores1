package principal;
import gramaticas.VentanaIDE;
import java.io.File;
import javax.swing.JPanel;

public class Main extends JPanel {

    public static void main(String[] args){
      //  String rutaLex = "/home/luisitopapurey/Escritorio/Compiladores 1/Practica 1/src/gramaticas/LexerMysql.flex";
        //String[] rutaS = {"-parse", "Sintax", "/home/luisitopapurey/Escritorio/Compiladores 1/Practica 1/src/gramaticas/SintaxMysql.cup"};
        
        VentanaIDE ventana = new VentanaIDE();
        ventana.setVisible(true);
    }
    
  /*  public static void generar(String rutaLex, String[] rutaS){
       File archivo;
       archivo = new File(rutaLex);
       JFlex.Main.generate(archivo);
       JFlex
       
    }*/
}