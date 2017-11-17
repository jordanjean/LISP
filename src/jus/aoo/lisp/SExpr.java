package jus.aoo.lisp;

/*
 * Cette interface spécifie les S-expressions LISP.
 */
public interface SExpr {

	public SExpr car();

	public SExpr cdr();

	public boolean isAtome();

	public boolean isListe();

	public SExpr eval();

	public SExpr apply(SExpr largs);

	public boolean eq(SExpr s);

}