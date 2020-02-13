package com.gds.composite;

import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-01-21 13:44
 */
public class Sentence extends LetterComposite {

    public Sentence(List<Word> words) {
//        words.forEach(this::add);
        for (Word word : words) {
            this.add(word);
        }
    }

    @Override
    protected void printThisAfter() {
        System.out.print(".");
    }
}
