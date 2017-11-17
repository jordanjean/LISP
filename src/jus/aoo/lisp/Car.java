package jus.aoo.lisp;

/*
 * Dans cette classe se trouve la méthode permettant d'appliquer la primitive LISP car à la liste d'arguments effectifs passée en paramètre.
 * car délivre le premier élément d'une liste de la liste passé en paramètre.
 * car appliqué à Nil retourne Nil par convention.
 */
public class Car extends SubR {

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.Primitives#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {	
		if(largs == Nil.NIL){
			return Nil.NIL;
		}
		if(largs.car().isListe()){
			return largs.car().car();
		}
		throw new LispException("car not applicable to " + largs.car().toString());
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
