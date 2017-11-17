package jus.aoo.lisp;

import jus.util.IO;

public class Console {
	public static void prompt(String s){ System.out.print(s);}
	public static void print(String s){ IO.print(s);}
	public static void println(String s){IO.println(s);}
	public static void println(){IO.println();}
	public static void resetOut() {IO.resetOut();}
	public static void setOut(){IO.setOut();}
	public static void setOut(String s){IO.setOut(s);}
	public static void debug(String s) {
		if(System.getProperty("DEBUG")!=null) System.err.println(s);
	}
	public static void printStack(Throwable e) {
		if(System.getProperty("DEBUG")!=null) e.printStackTrace();
	}
}