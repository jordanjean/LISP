package jus.aoo.lisp;

/*
 * Dans cette classe se trouve la méthode permettant d'appliquer la primitive LISP cond à la liste d'arguments effectifs passée en paramètre.
 * cond recherche la première alternative qui a une condition vrai et retourne la valeur de la forme associéé.
 * Si aucune condition n'est satisfaite, on retourne Nil par convention.
 */
public class Cond extends FSubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {
		SExpr di = largs.car();
		SExpr ci = di.car();
		SExpr ai = di.cdr();
		if (ci.eval() != Nil.NIL) {
			if (ai.car().isAtome()) {
				return ai.car().eval();
			}
			if (ai.car().car().eval() instanceof Primitives) {
				return ai.car().eval();
			}
			throw new LispException("cond not applicable to " + ai.car().toString());
		}
		if (largs.cdr() != Nil.NIL) {
			return apply(largs.cdr());
		}
		return Nil.NIL;
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
