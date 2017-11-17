/* Generated By:JavaCC: Do not edit this line. ReaderConstants.java */
package jus.aoo.lisp;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface ReaderConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int SL_COMMENT = 37;
  /** RegularExpression Id. */
  int ML_COMMENT = 38;
  /** RegularExpression Id. */
  int DOT = 40;
  /** RegularExpression Id. */
  int LPAR = 41;
  /** RegularExpression Id. */
  int RPAR = 42;
  /** RegularExpression Id. */
  int QUOTE = 43;
  /** RegularExpression Id. */
  int SYMBOL = 44;
  /** RegularExpression Id. */
  int DIGIT = 45;
  /** RegularExpression Id. */
  int LETTER = 46;
  /** RegularExpression Id. */
  int SPECIAL = 47;

  /** Lexical state. */
  int DEFAULT = 0;
  /** Lexical state. */
  int IN_SL_COMMENT = 1;
  /** Lexical state. */
  int IN_ML_COMMENT = 2;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
    "\"\\u0000\"",
    "\"\\u0001\"",
    "\"\\u0002\"",
    "\"\\u0003\"",
    "\"\\u0004\"",
    "\"\\u0005\"",
    "\"\\u0006\"",
    "\"\\u0007\"",
    "\"\\b\"",
    "\"\\u000b\"",
    "\"\\f\"",
    "\"\\u000e\"",
    "\"\\u000f\"",
    "\"\\u0010\"",
    "\"\\u0011\"",
    "\"\\u0012\"",
    "\"\\u0013\"",
    "\"\\u0014\"",
    "\"\\u0015\"",
    "\"\\u0016\"",
    "\"\\u0017\"",
    "\"\\u0018\"",
    "\"\\u0019\"",
    "\"\\u001a\"",
    "\"\\u001b\"",
    "\"\\u001c\"",
    "\"\\u001d\"",
    "\"\\u001e\"",
    "\"\\u001f\"",
    "\"\\u007f\"",
    "\"//\"",
    "\"/*\"",
    "<SL_COMMENT>",
    "\"*/\"",
    "<token of kind 39>",
    "\".\"",
    "\"(\"",
    "\")\"",
    "\"\\\'\"",
    "<SYMBOL>",
    "<DIGIT>",
    "<LETTER>",
    "<SPECIAL>",
  };

}
