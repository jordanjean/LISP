package jus.aoo.lisp;

/*
 * La primitive de permet de définir de nouvelles fonctions dont l'évaluation fonctionnelle correspond à celle d'une Lambda.
 * Les arguments sont le nom de la fonction, la liste de ses paramètres formels et le corps de la fonction à définir.
 */
public class De extends FSubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {
		if (!largs.cdr().isListe()) {throw new LispException("to few arguments for de");}
		Symbol nom = (Symbol) largs.car();
		SExpr param = largs.cdr().car();
		SExpr forme = largs.cdr().cdr().car();
		if (!nom.isAtome()) {throw new LispException("first argument of de must be an atome");}
		Context.define(nom, new SCons(Symbol.newSymbol("lambda"), new SCons(param, new SCons(forme, Nil.NIL))));
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
