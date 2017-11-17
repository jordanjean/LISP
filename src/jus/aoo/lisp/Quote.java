package jus.aoo.lisp;

/*
 * La primitive quote retourne tel quel son argument.
 */
public class Quote extends FSubR {

	public Quote() {
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {return largs.car();}

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

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {return "quote";}

}
