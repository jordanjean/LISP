package jus.aoo.lisp;

/*
 * Dans cette classe se trouve la méthode permettant d'appliquer la primitive LISP cons à la liste d'arguments effectifs passée en paramètre.
 * cons retourne la liste formée des deux SExpr passées en paramètres.
 */
public class Cons extends SubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {
			if(largs == Nil.NIL){
				return new SCons(Nil.NIL, Nil.NIL);
			}
			else if(largs.car().isListe() || largs.car().isAtome()){
				return new SCons(largs.car(), largs.cdr().car());
			}
		throw new LispException("cons not applicable to " + largs.car().toString());
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
	public boolean eq(SExpr s) {return this == s;}
}
