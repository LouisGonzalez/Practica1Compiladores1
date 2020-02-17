package gramaticas;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico2
%cup
%cupdebug
%line
%column

/*Identificadores*/

Letra = [a-zA-Z]
Numero = [0123456789]
espacio = [ ,\t,\r,\n]+
Simbolo = [-_@+*#-]
Punto = [-.]
Diagonal = [-/]
Extension = ".csv"

%{
    private Symbol symbol(int tipo){
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int tipo, Object value){
        return new Symbol(tipo, yyline+1, yycolumn+1, value);
    }
%}
%%
<YYINITIAL> {
        ">"                                                         {return symbol(sym2.MAYOR);}
        "PROYECTO"                                                  {return symbol(sym2.PROYECTO);}
        "ARCHIVO"                                                   {return symbol(sym2.ARCHIVO);}
        "CARPETA"                                                   {return symbol(sym2.CARPETA);}
        "nombre"                                                    {return symbol(sym2.NOMBRE);}
        "<"                                                         {return symbol(sym2.MENOR_QUE);}
        "</"                                                        {return symbol(sym2.FIN);}            
        "ubicacion"                                                 {return symbol(sym2.UBICACION);}
        "="                                                         {return symbol(sym2.IGUAL);}
        "\""                                                        {return symbol(sym2.COMILLA);}
        "."                                                       {return symbol(sym2.PUNTO);}
        "/"                                                        {return symbol(sym2.DIAGONAL);}
        {Letra}({Letra}|{Numero}|{Simbolo})*                {return symbol(sym2.PALABRA);}
        {Diagonal}{Letra}({Letra}|{Numero}|{Simbolo}|{Punto})*({Diagonal}{Letra}({Letra}|{Numero}|{Simbolo}|{Punto})*)*{Extension}                   {return symbol(sym2.PATH);}
        ("(-"{Numero}+")") | {Numero}+                              {return symbol(sym2.NUMERO);}
        {espacio}                                                   {/*Ignore*/}            
        .                                                           {return symbol(sym2.error, new String(yytext()));}
}
