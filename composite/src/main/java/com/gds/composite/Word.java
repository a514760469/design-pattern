package com.gds.composite;

import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-01-21 11:55
 */
public class Word extends LetterComposite {

    public Word(List<Letter> letters) {
        letters.forEach(this::add);
    }

    public Word(char... letters) {
        for (char letter : letters) {
            this.add(new Letter(letter));
        }
    }

    @Override
    protected void printThisAfter() {
        System.out.print(" ");
    }
}
