package jus.aoo.lisp;

/*
 * Dans cette classe se trouve la méthode permettant d'appliquer la primitive LISP atom à la liste d'arguments effectifs passée en paramètre.
 * On renvoie t si l'argument est un atom, Nil sinon.
 */
public class Atom extends SubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {
			if(largs == Nil.NIL){
				return Nil.NIL;
			}
			else if(largs.car().isAtome()){
				return Symbol.newSymbol("t");
			}
			else if(largs.car().isListe()){
				return Nil.NIL;
			}
		throw new LispException("atom not applicable to " + largs.car().toString());
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eval()
	 */
	public SExpr eval() {return this;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eq(jus.aoo.lisp.SExpr)
	 */
	public boolean eq(SExpr s) {return s == this;}
}
