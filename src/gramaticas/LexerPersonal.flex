package gramaticas;
import java_cup.runtime.Symbol;

%%
%public 
%class AnalizadorLexico4
%cup
%cupdebug
%line
%column

/*Identificadores*/
Letra = [a-zA-Z]
Numero = [0123456789]
espacio = [ ,\t,\r,\n]+
Simbolo = [-_@$#%*{}:;$]


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
            ","                                                            {return symbol(sym4.COMA);}
            ";\n"                                                           {return symbol(sym4.FIN);}    
            {espacio}                                                       {/*Ignore*/}            
            "SELECCIONAR"                                                   {return symbol(sym4.SELECCIONAR);}                       
            "FILTRAR"                                                       {return symbol(sym4.FILTRAR);}    
            "INSERTAR"                                                      {return symbol(sym4.INSERTAR);}
            "ACTUALIZAR"                                                    {return symbol(sym4.ACTUALIZAR);}
            "ASIGNAR"                                                       {return symbol(sym4.ASIGNAR);}
            "ELIMINAR"                                                      {return symbol(sym4.ELIMINAR);}
            "EN"                                                            {return symbol(sym4.EN);}
            "VALORES"                                                       {return symbol(sym4.VALORES);}
            "AND"                                                           {return symbol(sym4.AND);}    
            "OR"                                                            {return symbol(sym4.OR);}
            "("                                                             {return symbol(sym4.AGRUPACION_A);}
            ")"                                                             {return symbol(sym4.AGRUPACION_B);}
            ";"                                                             {return symbol(sym4.PUNTO_COMA);}
            "*"                                                             {return symbol(sym4.ASTERISCO);}
            "="                                                             {return symbol(sym4.IGUAL);}
            "<"                                                             {return symbol(sym4.MENOR_QUE);}    
            ">"                                                             {return symbol(sym4.MAYOR_QUE);}    
            "<="                                                            {return symbol(sym4.MENOR_IGUAL);}
            ">="                                                            {return symbol(sym4.MAYOR_IGUAL);}
            "<>"                                                            {return symbol(sym4.MAYOR_MENOR);}
            "."                                                             {return symbol(sym4.PUNTO);}
            "\""                                                            {return symbol(sym4.COMILLA);}
            ("(-"{Numero}+")") | {Numero}+                                  {return symbol(sym4.NUMERO, new Integer(yytext()));}
            {Letra}({Letra}|{Numero}|{Simbolo})*                            {return symbol(sym4.PALABRA, new String(yytext()));}
            .                                                               {System.out.println(yytext()+" "+yyline+" "+yycolumn);}
}
