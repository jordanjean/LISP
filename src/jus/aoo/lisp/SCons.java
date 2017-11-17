package jus.aoo.lisp;

/*
 * Cette classe implémente le constructeur de liste.
 * La représentation d'une liste est un S-GRAPHE.
 * Chaque élément de liste est représenté par un doublet (car, cdr).
 * LISP étant un language fonctionelle l'évaluation d'une liste correspond à l'évaluation d'une fonction.
 * Si le premier élément de la liste ne peut être reconnu comme un foncteur l'évaluation ne peut se faire.
 */
public class SCons implements Liste {
	private SExpr car, cdr;

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#car()
	 */
	public SExpr car() {return car;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#cdr()
	 */
	public SExpr cdr() {return cdr;}

	public boolean isListe() {return true;}

	public boolean isAtome() {return false;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eval()
	 */
	public SExpr eval() {
		SExpr fct = car();
		SExpr largs = cdr();
		/* Si fct est un atome on a à faire à une primitive ou a une fonction utilisateur,
		 * il faut alors évaluer fct.
		 */
		if (fct.isAtome()) {
			fct = fct.eval();
			if (fct instanceof Primitives) {
				return ((Primitives) fct).reduction(largs);
			}
		}
		/* Si fct est une liste on a à faire à une fonction lambda ou flambda définit dans la SExpr fct. */
		if (fct.isListe()) {
			SExpr type = fct.car();
			SExpr largs_formels = fct.cdr().car();
			SExpr corps = fct.cdr().cdr().car();
			if (type.eq(Symbol.newSymbol("lambda"))) {
				Expr f = new Expr(largs_formels, corps);
				return f.reduction(largs);
			}
			if (type.eq(Symbol.newSymbol("flambda"))) {
				FExpr f = new FExpr(largs_formels, corps);
				return f.reduction(largs);
			}
		}
		throw new LispException("EVAL: undefined function " + car().toString());
	}

	public SCons(SExpr s1, SExpr s2) {
		car = s1;
		cdr = s2;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "(" + toString(this) + ")";
	}

	private String toString(SExpr sexpr) {
		if (sexpr.cdr() == Nil.NIL) {
			return sexpr.car().toString();
		}
		if (!sexpr.cdr().isListe()) {
			return sexpr.car().toString() + " . " + sexpr.cdr().toString();
		}
		return sexpr.car().toString() + " " + toString(sexpr.cdr());
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eq(jus.aoo.lisp.SExpr)
	 */
	public boolean eq(SExpr s) {
		if (s == Nil.NIL) {return false;}
		if (s.isAtome()) {return false;}
		return this == s;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr a_e) {throw new LispException("apply not applicable in SCons");}

}
