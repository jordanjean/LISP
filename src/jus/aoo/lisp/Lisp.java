package jus.aoo.lisp;

/*
 * main-classe de l'interprèteur LISP
 * Boucle d'intéraction avec l'utilisateur
 */
public class Lisp {
	/*
	 * arrêt de la machine lisp
	 */
	public static void quit() {
		System.out.println("LispExit");
		System.exit(0);
	}

	public static void main(String[] args) {
		System.out.println("LispEnter");
		Reader parser = new Reader(System.in);
		while (true) {
			System.out.print(">");
			try {
				System.out.println(Reader.SEXPRESSION().eval());
			} catch (LispException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("unexpectedException");
				e.printStackTrace();
			} finally {}
		}
	}

}
