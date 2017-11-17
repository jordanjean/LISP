package jus.aoo.lisp;

import java.util.HashMap;
import java.util.Map;

/*
 * Cette classe définit les symboles LISP.
 * Un symbole est un atome.
 */
public class Symbol extends Atome {
	
	private String valeur;
	
	static private Map<String, Symbol> symboles = new HashMap<>();

	public boolean isSymbole() {return true;}

	public static Symbol newSymbol(String s) {
		if (symboles.containsKey(s)) {
			return symboles.get(s);
		}
		Symbol new_symb = new Symbol(s);
		symboles.put(s, new_symb);
		return new_symb;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {return valeur;}

	private Symbol(String s){ valeur=s;}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {throw new LispException("apply not applicable in Symbol");}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eval()
	 */
	public SExpr eval() {return Context.get(this);}

	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp.SExpr#eq(jus.aoo.lisp.SExpr)
	 */
	public boolean eq(SExpr s) {return s == this;}

}
