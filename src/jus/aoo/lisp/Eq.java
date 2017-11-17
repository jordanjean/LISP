package jus.aoo.lisp;

/*
 * Dans cette classe se trouve la méthode permettant d'appliquer la primitive LISP eq à la liste d'arguments effectifs passée en paramètre.
 * eq renvoie t si les deux arguments sont identiques, Nil sinon.
 * Deux listes différentes  de Nil ne sont jamais identiques car leur S-GRAPHE sont différents.
 */
public class Eq extends SubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.Primitives#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {	
		if(largs.car().eq(largs.cdr().car())){
			return Symbol.newSymbol("t");
		}else{
			return Nil.NIL;
		}
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eq(jus.aoo.lisp.SExpr)
	 */
	public boolean eq(SExpr s) {return this == s;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eval()
	 */
	public SExpr eval() {return this;}
}
