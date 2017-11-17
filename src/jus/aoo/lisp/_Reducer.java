package jus.aoo.lisp;

/*
 * Interface spécifiant les réducteurs de SExpr pour les primitives et les fonctions utilisateurs.  
 */
public interface _Reducer {
	public SExpr reduction(SExpr largs);
	public SExpr apply(SExpr largs);
}
