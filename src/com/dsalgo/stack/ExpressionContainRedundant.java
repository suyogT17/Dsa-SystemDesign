package com.dsalgo.stack;

/**
 * Given a string of balanced expressions, find if it contains a redundant parenthesis or not. A set of parenthesis is redundant if the same sub-expression is surrounded by unnecessary or multiple brackets. Print ‘Yes‘ if redundant, else ‘No‘.
 *
 * Note: Expression may contain ‘+‘, ‘*‘, ‘–‘ and ‘/‘ operators. Given expression is valid and there are no white spaces present.
 *
 * Examples:
 *
 * Input: str = “((a+b))”
 * Output: YES
 * Explanation: ((a+b)) can reduced to (a+b), this Redundant
 *
 * Input: str = “(a+(b)/c)”
 * Output: YES
 * Explanation: (a+(b)/c) can reduced to (a+b/c) because b is surrounded by () which is redundant.
 */
public class ExpressionContainRedundant {
}
