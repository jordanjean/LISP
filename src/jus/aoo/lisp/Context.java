package jus.aoo.lisp;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Cette classe spécifie la notion de contexte qui définit l'ensemble des associations des noms de variables à leur valeur accessibles à un instant donné.
 * Le contexte est global au système et a été implanté grace à l'objet map. 
 * A chaque appel de fonction, le contexte augmanté des associations entre les paramètres formels et effectifs. 
 * Et ces modifications sont mémorisés dans un nouvel objet map lui même stocké dans une pile. On choisis d'associé la valeur Nil aux variables qui n'existaient pas vant l'appel affin de les distinguer. 
 * A chaque fin d'appel de fonction le contexte précédent est restauré à son état d'origine.
 */
public class Context {
	private static final Map<Symbol, SExpr> variables = new HashMap<>();
	private static final Stack<Map<Symbol, SExpr>> pile = new Stack<>();
	
	private Context() {}

	/*
	 * Définition des primitives du language et de quelques constantes pour les tests.
	 */
	static {
		define(Symbol.newSymbol("eq"), new Eq());
		define(Symbol.newSymbol("car"), new Car());
		define(Symbol.newSymbol("quote"), new Quote());
		define(Symbol.newSymbol("cdr"), new Cdr());
		define(Symbol.newSymbol("cons"), new Cons());
		define(Symbol.newSymbol("atom"), new Atom());
		define(Symbol.newSymbol("cond"), new Cond());
		define(Symbol.newSymbol("eval"), new Eval());
		define(Symbol.newSymbol("apply"), new Apply());
		define(Symbol.newSymbol("de"), new De());
		define(Symbol.newSymbol("df"), new Df());
		define(Symbol.newSymbol("quit"), new Quit());
		define(Symbol.newSymbol("nil"), Nil.NIL);
		define(Symbol.newSymbol("t"), Symbol.newSymbol("t"));
		define(Symbol.newSymbol("C1"), Symbol.newSymbol("1"));
		define(Symbol.newSymbol("C2"), Symbol.newSymbol("2"));
		define(Symbol.newSymbol("C3"), Symbol.newSymbol("3"));
		define(Symbol.newSymbol("L1"), new SCons(Symbol.newSymbol("C1"), Symbol.newSymbol("C2")));
		define(Symbol.newSymbol("L2"), new SCons(Symbol.newSymbol("C2"), Symbol.newSymbol("C3")));
	}

	/*
	 * Retourner la valeur associé au symbole s dans le contexte actuel.
	 */
	public static SExpr get(Symbol s) {
		SExpr v = variables.get(s);
		if (v == null) {
			throw new LispException("CONTEXT: " + s.toString() + " undefined");
		}
		return v;
	}

	/*
	 * On ajoute l'association du symbole s à la valeur dans le contexte actuel.
	 */
	public static void define(Symbol s, SExpr valeur) {variables.put(s, valeur);}

	public static void bind(SExpr pf, SExpr pe) {
		HashMap<Symbol, SExpr> local = new HashMap<>();
		try {
			pile.push(local);
			_bind(pf, pe, local);
		} catch (Exception e) {
			unbind();
			throw new LispException("CONTEXT: mismatch " + pf.toString() + " / " + pe.toString());
		}
	}

	/*
	 * On restaure le contexte antérieur à l'appel de fonction.
	 */
	private static void _bind(SExpr pf, SExpr pe, HashMap<Symbol, SExpr> local) {
		if (pf == Nil.NIL) {
			if (pe != Nil.NIL) {
				throw new LispException("CONTEXT: mismatch" + pf.toString() + " / " + pe.toString());
			}
			return;
		} else if (pf.car().isAtome() && pe.car() != Nil.NIL) {
			local.put((Symbol) pf.car(), variables.get(pf.car()));
			define((Symbol) pf.car(), pe.car());
			_bind(pf.cdr(), pe.cdr(), local);
			return;
		}
		if (!pe.car().isListe() || !pe.car().isListe()) {
			throw new LispException("CONTEXT: mismatch" + pf.toString() + " / " + pe.toString());
		}
		_bind(pf.car(), pe.car(), local);
		_bind(pf.cdr(), pe.cdr(), local);
	}

	public static void unbind() {
		if (pile.isEmpty()) {
			throw new LispException("CONTEXT: empty stack");
		}
		Map<Symbol, SExpr> save = pile.pop();
		for (Map.Entry<Symbol, SExpr> entry : save.entrySet()) {
			Symbol s = (Symbol) entry.getKey();
			SExpr v = (SExpr) entry.getValue();
			if (v == Nil.NIL) {
				variables.remove(s);
			} else {
				variables.replace(s, v);
			}
		}
	}

}
