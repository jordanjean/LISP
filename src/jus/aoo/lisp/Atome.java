package jus.aoo.lisp;

/*
 * Cette classe définit un atome.
 * Un atome est un symbole dénoté par une chaîne de caractères ne contenant pas ', (, ) et de blanc.
 */
public abstract class Atome implements SExpr {

	public boolean isAtome() {return true;}

	public boolean isListe() {return false;}

	@Override
	public SExpr car() {throw new LispException("car not applicable in Atome");}

	@Override
	public SExpr cdr() {throw new LispException("cdr not applicable in Atome");}
}