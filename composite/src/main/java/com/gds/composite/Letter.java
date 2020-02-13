package com.gds.composite;

/**
 * @author zhanglifeng
 * @since 2020-01-21 11:47
 */
public class Letter extends LetterComposite {

    private char character;

    public Letter(char character) {
        this.character = character;
    }

    @Override
    protected void printThisBefore() {
        System.out.print(character);
    }

}
