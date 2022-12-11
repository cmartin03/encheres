/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insastrasbourg.ui;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author martin
 */
public class NumericAndLengthFilter extends DocumentFilter {

    /**
     * Number of characters allowed.
     */
    private int length = 0;

    /**
     * Restricts the number of charcacters can be entered by given length.
     *
     * @param length Number of characters allowed.
     */
    public NumericAndLengthFilter(int length) {
        this.length = length;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string,
            AttributeSet attr) throws
            BadLocationException {
        if (isNumeric(string)) {
            if (this.length > 0 && fb.getDocument().getLength() + string.
                    length()
                    > this.length) {
                return;
            }
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws
            BadLocationException {
        if (isNumeric(text)) {
            if (this.length > 0 && fb.getDocument().getLength() + text.
                    length()
                    > this.length) {
                return;
            }
            super.insertString(fb, offset, text, attrs);
        }
    }

    /**
     * This method tests whether given text can be represented as number. This
     * method can be enhanced further for specific needs.
     *
     * @param text Input text.
     * @return {@code true} if given string can be converted to number;
     * otherwise returns {@code false}.
     */
    private boolean isNumeric(String text) {
        if (text == null || text.trim().equals("")) {
            return false;
        }
        for (int iCount = 0; iCount < text.length(); iCount++) {
            if (!Character.isDigit(text.charAt(iCount))) {
                return false;
            }
        }
        return true;
    }

}
