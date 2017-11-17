package jus.aoo.lisp;

/*
 * Dans cette classe se trouve la méthode permettant d'appliquer la primitive LISP cdr à la liste d'arguments effectifs passée en paramètre.
 * cdr délivre la valeur de la liste passée en argument privée de son primier élément.
 * cdr appliqué à Nil délivre Nil par convention.
 */
public class Cdr extends SubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {
		if (largs == Nil.NIL) {
			return Nil.NIL;
		}
		if (largs.car().isListe()) {
			return largs.car().cdr();
		}
		throw new LispException("cdr not applicable to " + largs.cdr().toString());
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
