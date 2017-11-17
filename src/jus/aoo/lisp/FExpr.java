package jus.aoo.lisp;

/*
 * Cette classe définit l'application des fonctions utilisateurs de type Flambda.
 * Les paramètres effectifs d'une fonction lambda sont évalués avant application.
 * L'application d'une fonction utilisateur a deux attributs, les paramètres formels 
 * et le corps à évaluer dans le contexte augmenté des associations des paramètres formels et effectifs. 
 */
public class FExpr extends Reducer {

	private SExpr largs_formels;
	private SExpr corps;

	public FExpr(SExpr a_f, SExpr corps) {
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
