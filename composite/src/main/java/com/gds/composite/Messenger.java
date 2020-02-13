package com.gds.composite;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhanglifeng
 * @since 2020-01-21 13:51
 */
public class Messenger {

    LetterComposite messageFromOrcs() {

        List<Word> words = Arrays.asList(
                new Word('W', 'h', 'e', 'r', 'e'),
                new Word('t', 'h', 'e', 'r', 'e'),
                new Word('i', 's'),
                new Word('a'),
                new Word('w', 'h', 'i', 'p'),
                new Word('t', 'h', 'e', 'r', 'e'),
                new Word('i', 's'),
                new Word('a'),
                new Word('w', 'a', 'y')
        );

        return new Sentence(words);
    }

    LetterComposite messageFromElves() {

        List<Word> words = Arrays.asList(
                new Word('M', 'u', 'c', 'h'),
                new Word('w', 'i', 'n', 'd'),
                new Word('p', 'o', 'u', 'r', 's'),
                new Word('f', 'r', 'o', 'm'),
                new Word('y', 'o', 'u', 'r'),
                new Word('m', 'o', 'u', 't', 'h')
        );

        return new Sentence(words);

    }


    public static void main(String[] args) {
        LetterComposite orcMessage = new Messenger().messageFromOrcs();
        orcMessage.print();

        System.out.println();

        LetterComposite elfMessage = new Messenger().messageFromElves();
        elfMessage.print();
    }
}
