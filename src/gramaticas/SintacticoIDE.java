
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Sun Feb 09 14:18:44 CST 2020
//----------------------------------------------------

package gramaticas;

import java_cup.runtime.Symbol;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Sun Feb 09 14:18:44 CST 2020
  */
public class SintacticoIDE extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public SintacticoIDE() {super();}

  /** Constructor which sets the default scanner. */
  public SintacticoIDE(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public SintacticoIDE(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\006\000\002\002\004\000\002\002\014\000\002\004" +
    "\021\000\002\004\017\000\002\004\002\000\002\005\005" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\004\005\004\001\002\000\004\006\007\001" +
    "\002\000\004\002\006\001\002\000\004\002\001\001\002" +
    "\000\004\011\010\001\002\000\004\013\011\001\002\000" +
    "\004\014\012\001\002\000\004\020\013\001\002\000\004" +
    "\014\014\001\002\000\004\004\015\001\002\000\006\005" +
    "\017\022\ufffd\001\002\000\004\022\052\001\002\000\006" +
    "\007\020\010\021\001\002\000\004\011\035\001\002\000" +
    "\004\011\022\001\002\000\004\013\023\001\002\000\004" +
    "\014\024\001\002\000\004\020\025\001\002\000\004\014" +
    "\026\001\002\000\004\004\027\001\002\000\006\005\017" +
    "\022\ufffd\001\002\000\004\022\031\001\002\000\004\010" +
    "\032\001\002\000\004\004\033\001\002\000\006\005\017" +
    "\022\ufffd\001\002\000\004\022\ufffe\001\002\000\004\013" +
    "\036\001\002\000\004\014\037\001\002\000\004\020\040" +
    "\001\002\000\004\014\041\001\002\000\004\012\042\001" +
    "\002\000\004\013\043\001\002\000\004\014\044\001\002" +
    "\000\004\017\045\001\002\000\004\014\046\001\002\000" +
    "\004\016\047\001\002\000\004\004\050\001\002\000\006" +
    "\005\017\022\ufffd\001\002\000\004\022\uffff\001\002\000" +
    "\004\006\054\001\002\000\004\002\000\001\002\000\004" +
    "\004\055\001\002\000\004\002\ufffc\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\053\000\004\002\004\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\004\015\001\001\000\004" +
    "\005\052\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\004" +
    "\027\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\004\033\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\004\050\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$SintacticoIDE$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$SintacticoIDE$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$SintacticoIDE$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public SintacticoIDE (AnalizadorLexico2 lex){
        super(lex);
    }

    public void setAccion(String tipo, String mensaje, String accion){
        System.out.println(tipo+" "+mensaje);
    }
    
    public void syntax_error(Symbol s){
        setAccion("ERROR", "Error sintaxis token: "+s.right,"");
    };

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$SintacticoIDE$actions {
  private final SintacticoIDE parser;

  /** Constructor */
  CUP$SintacticoIDE$actions(SintacticoIDE parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$SintacticoIDE$do_action(
    int                        CUP$SintacticoIDE$act_num,
    java_cup.runtime.lr_parser CUP$SintacticoIDE$parser,
    java.util.Stack            CUP$SintacticoIDE$stack,
    int                        CUP$SintacticoIDE$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$SintacticoIDE$result;

      /* select the action based on the action number */
      switch (CUP$SintacticoIDE$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // d ::= FIN PROYECTO MAYOR 
            {
              Object RESULT =null;

              CUP$SintacticoIDE$result = parser.getSymbolFactory().newSymbol("d",3, ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-2)), ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.peek()), RESULT);
            }
          return CUP$SintacticoIDE$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // b ::= 
            {
              Object RESULT =null;

              CUP$SintacticoIDE$result = parser.getSymbolFactory().newSymbol("b",2, ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.peek()), ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.peek()), RESULT);
            }
          return CUP$SintacticoIDE$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // b ::= MENOR_QUE CARPETA NOMBRE IGUAL COMILLA PALABRA COMILLA MAYOR b FIN CARPETA MAYOR b 
            {
              Object RESULT =null;

              CUP$SintacticoIDE$result = parser.getSymbolFactory().newSymbol("b",2, ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-12)), ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.peek()), RESULT);
            }
          return CUP$SintacticoIDE$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // b ::= MENOR_QUE ARCHIVO NOMBRE IGUAL COMILLA PALABRA COMILLA UBICACION IGUAL COMILLA PATH COMILLA DIAGONAL MAYOR b 
            {
              Object RESULT =null;

              CUP$SintacticoIDE$result = parser.getSymbolFactory().newSymbol("b",2, ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-14)), ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.peek()), RESULT);
            }
          return CUP$SintacticoIDE$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // aa ::= MENOR_QUE PROYECTO NOMBRE IGUAL COMILLA PALABRA COMILLA MAYOR b d 
            {
              Object RESULT =null;

              CUP$SintacticoIDE$result = parser.getSymbolFactory().newSymbol("aa",0, ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-9)), ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.peek()), RESULT);
            }
          return CUP$SintacticoIDE$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= aa EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-1)).value;
		RESULT = start_val;
              CUP$SintacticoIDE$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.elementAt(CUP$SintacticoIDE$top-1)), ((java_cup.runtime.Symbol)CUP$SintacticoIDE$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$SintacticoIDE$parser.done_parsing();
          return CUP$SintacticoIDE$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}
