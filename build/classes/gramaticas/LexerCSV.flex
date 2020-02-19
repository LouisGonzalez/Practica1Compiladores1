package gramaticas;
import java_cup.runtime.Symbol;

%%
%public
%class AnalizadorLexico3
%cup
%cupdebug
%line
%column

/*Identificadores*/

Letra = [a-zA-Z]   
Numero = [0123456789]
Numero2 = [123456789]
Simbolo = [-_@$#%*{}:;&!?]
Punto = [.]
enter = [\n]
coma = [,]
espacio = [" "]+


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
    ","                                                                 {return symbol(sym3.COMA);}
    "\n"                                                                {return symbol(sym3.ENTER);}
    {coma}{enter}                                                       {return symbol(sym3.COMA_ENTER);}
    ({Letra}|{Simbolo})({Letra}|{Numero}|{Simbolo}|{espacio})*                                {return symbol(sym3.DATO_ALFANUMERICO, new String(yytext()));}
    ("(-"{Numero}+")") | {Numero}+                                      {return symbol(sym3.DATO_NUMERICO, new Integer(yytext()));}
    ({Numero2}{Numero}*{Punto}|{Punto}){Numero}*{Numero2}               {return symbol(sym3.DATO_DECIMAL, new Integer(yytext()));}
    .                                                                   {System.out.println(yyline+" "+yycolumn);}
}
