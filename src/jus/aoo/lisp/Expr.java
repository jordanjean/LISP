package jus.aoo.lisp;

/*
 * Cette classe définit l'application des fonctions utilisateurs de type lambda.
 * Les paramètres effectifs d'une fonction lambda ne sont pas évalués avant d'être appliqués.
 * L'application d'une fonction utilisateur a deux attributs, les paramètres formels 
 * et le corps à évaluer dans le contexte augmenté des associations des paramètres formels et effectifs. 
 */
public class Expr extends Reducer {

	private SExpr largs_formels;
	private SExpr corps;

	public Expr(SExpr a_f, SExpr corps) {
		this.largs_formels = a_f;
		this.corps = corps;
	}
	
	/* Définition des accesseurs nécéssaires */
	private SExpr largs_formels(){return largs_formels;}
	private SExpr corps(){return corps;}
	
	@Override
	/*
	 * (non-Javadoc)
	 * @see jus.aoo.lisp._Reducer#apply(jus.aoo.lisp.SExpr)
	 */
	public SExpr apply(SExpr largs) {
		/* Augmentation du contexte pour la durée de l'appel fonctionelle */
		Context.bind(largs_formels(), largs);
		SExpr s = corps().eval();
		/* Restauration du contexte précédent l'appel */
		Context.unbind();
		return s;
	}

}
