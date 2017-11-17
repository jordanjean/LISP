package jus.aoo.lisp;

/*
 * Cette classe abstraite regroupe les primitives LISP.
 * Elle contient la méthode qui permet d'évaluer les arguments dans le cas d'une primitive SUBR,
 * et d'appliquer la fonction à la liste d'arguments.
 */
public abstract class Primitives extends Atome implements _Reducer {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp._Reducer#reduction(jus.aoo.lisp.SExpr)
	 */
	public SExpr reduction(SExpr largs) {
		if (this instanceof FSubR) {
			return this.apply(largs);
		}
		if (this instanceof SubR) {
			return this.apply(eval_largs(largs));
		}
		throw new LispException("REDUCTION: " + this.toString() + "is neither FSubR nor SubR");
	}

	private SExpr eval_largs(SExpr largs) {
		if (largs == Nil.NIL) {
			return Nil.NIL;
		}
		return new SCons(largs.car().eval(), eval_largs(largs.cdr()));
	}

}
