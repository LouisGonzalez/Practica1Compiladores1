package gramaticas;
import java_cup.runtime.Symbol; 


%%
%public
%class AnalizadorLexico
%cup
%cupdebug
%line
%column

/*Identificadores*/
Letra = [a-zA-Z]
Numero = [0123456789]
espacio = [ ,\t,\r,\n]+

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
            ","                                                            {return symbol(sym.COMA);}
            ";\n"                                                           {return symbol(sym.FIN);}    
            {espacio}                                                       {/*Ignore*/}            
            "SELECCIONAR"                                                   {return symbol(sym.SELECCIONAR);}                       
            "FILTRAR"                                                       {return symbol(sym.FILTRAR);}    
            "INSERTAR"                                                      {return symbol(sym.INSERTAR);}
            "ACTUALIZAR"                                                    {return symbol(sym.ACTUALIZAR);}
            "ASIGNAR"                                                       {return symbol(sym.ASIGNAR);}
            "ELIMINAR"                                                      {return symbol(sym.ELIMINAR);}
            "EN"                                                            {return symbol(sym.EN);}
            "VALORES"                                                       {return symbol(sym.VALORES);}
            "AND"                                                           {return symbol(sym.AND);}    
            "OR"                                                            {return symbol(sym.OR);}
            "("                                                             {return symbol(sym.AGRUPACION_A);}
            ")"                                                             {return symbol(sym.AGRUPACION_B);}
            ";"                                                             {return symbol(sym.PUNTO_COMA);}
            "*"                                                             {return symbol(sym.ASTERISCO);}
            "="                                                             {return symbol(sym.IGUAL);}
            "<"                                                             {return symbol(sym.MENOR_QUE);}    
            ">"                                                             {return symbol(sym.MAYOR_QUE);}    
            "<="                                                            {return symbol(sym.MENOR_IGUAL);}
            ">="                                                            {return symbol(sym.MAYOR_IGUAL);}
            "<>"                                                            {return symbol(sym.MAYOR_MENOR);}
            "."                                                             {return symbol(sym.PUNTO);}
            "\""                                                            {return symbol(sym.COMILLA);}
            ("(-"{Numero}+")") | {Numero}+                                  {return symbol(sym.NUMERO);}
            {Letra}({Letra}|{Numero})*                                      {return symbol(sym.PALABRA, new String(yytext()));}
            .                                                               {System.out.println(yytext()+" "+yyline+" "+yycolumn);}
}
