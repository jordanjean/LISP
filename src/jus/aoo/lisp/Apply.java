package jus.aoo.lisp;

/*
 * Dans cette classe se trouve la méthode permettant d'appliquer la primitive LISP apply à la liste d'arguments effectifs passée en paramètre.
 * On applique la fonction contenue dans le fils gauche de l'arbre largs à la liste de paramètre contenue dans le fils droit.
 */
public class Apply extends SubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {
		SExpr fct = largs.car();
		SExpr args = largs.cdr();
		args = new SCons(new SCons(Symbol.newSymbol("quote"), args), Nil.NIL);
		SExpr s = new SCons(Symbol.newSymbol("cons"), new SCons(fct, args));
		return s.eval().eval();
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
