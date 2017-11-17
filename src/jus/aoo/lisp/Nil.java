package jus.aoo.lisp;

/*
 * Cette classe définit l'élément Nil associé à la liste vide "()".
 * Nil est à la fois une liste et un atome.
 * Cette classe implémente donc l'interface Liste et hérite de la classe abstaite Atome. 
 */
public class Nil extends Atome implements Liste {

	public static final Nil NIL = new Nil();
	private Nil(){}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.Atome#isListe()
	 */
	public boolean isListe() {return true;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.Atome#cdr()
	 */
	public SExpr cdr() {return this;}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.Atome#car()
	 */
	public SExpr car() {return this;}


	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {return "nil";}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eval()
	 */
	public SExpr eval() {return Nil.NIL;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr arg_efect) {throw new LispException("apply not applicable in Nil");}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eq(jus.aoo.lisp.SExpr)
	 */
	public boolean eq(SExpr s) {return s.equals(Nil.NIL);}
}