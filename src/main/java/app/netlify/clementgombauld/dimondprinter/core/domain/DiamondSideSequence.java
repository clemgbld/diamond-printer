package app.netlify.clementgombauld.dimondprinter.core.domain;

import app.netlify.clementgombauld.dimondprinter.core.domain.exceptions.NotLetterException;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiamondSideSequence {
    public static String generate(String letter) {
        if(isNotLetter(letter)){
            throw new NotLetterException();
        }
        String diamondTop = IntStream.rangeClosed(65, (int) letter.toUpperCase().charAt(0))
                .mapToObj(i -> (char) i)
                .map(Object::toString)
                .collect(Collectors.joining());

        return  diamondTop + new StringBuilder(diamondTop)
                .reverse()
                .substring(1,diamondTop.length());
    }

    private static boolean isNotLetter(String letter) {
        return letter.length() != 1 || !Character.isLetter(letter.charAt(0));
    }

}
