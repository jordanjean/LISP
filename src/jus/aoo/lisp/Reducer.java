package jus.aoo.lisp;

/*
 * Cette classe abstraite regroupe les fonctions utilisateurs EXPR et FEXPR.
 * La réduction d'une fonction utilisateur comprend l'évaluation des arguments dans le cas des fonctions EXPR 
 * puis l'application de la fonction aux arguments. 
 */
public abstract class Reducer implements _Reducer {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp._Reducer#reduction(jus.aoo.lisp.SExpr)
	 */
	public SExpr reduction(SExpr largs) {
		if (this instanceof FExpr) {
			return this.apply(largs);
		}
		if (this instanceof Expr) {
			return this.apply(eval_largs(largs));
		}
		throw new LispException("REDUCTION: " + this.toString() + "is neither FExpr nor Expr");
	}
	
	private SExpr eval_largs(SExpr largs) {
		if(largs == Nil.NIL){
			return Nil.NIL;
		}
		return new SCons(largs.car().eval(), eval_largs(largs.cdr()));
	}
}
