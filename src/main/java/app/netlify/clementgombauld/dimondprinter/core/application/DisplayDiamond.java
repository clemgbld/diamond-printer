package app.netlify.clementgombauld.dimondprinter.core.application;

import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;
import app.netlify.clementgombauld.dimondprinter.core.domain.DiamondSideSequence;
import app.netlify.clementgombauld.dimondprinter.core.domain.exceptions.NotLetterException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DisplayDiamond {
    public static final String ENTER_A_LETTER = "Enter a letter: ";
    public static final String SEPARATOR = " ";
    private final CommandLine commandLine;
    public DisplayDiamond(CommandLine commandLine) {
        this.commandLine = commandLine;
    }

    public void display() {
        try {
            String input = commandLine.getInput(ENTER_A_LETTER);
            String diamondSideSequence = DiamondSideSequence.generate(input);
            int sequenceUniqueLetterLength = Arrays.stream(diamondSideSequence.split(""))
                    .collect(Collectors.toSet())
                    .size() ;

            logDiamondLines(diamondSideSequence,sequenceUniqueLetterLength,0,0);
        }catch (NotLetterException e){
            commandLine.log("Please provide a correct single letter");
            display();
        }

    }

    private void logDiamondLines(String diamondSideSequence, int sequenceUniqueLetterLength, int i, int intSeparator){
        if(i >= diamondSideSequence.length()) return;
        commandLine.log(buildDiamondLine(diamondSideSequence, sequenceUniqueLetterLength, i, intSeparator));
        logDiamondLines(diamondSideSequence, sequenceUniqueLetterLength, i + 1, isAfterMiddle(diamondSideSequence, i) ? intSeparator - 1 : intSeparator + 1);
    }

    private String buildDiamondLine(String diamondSideSequence, int sequenceUniqueLetterLength, int i, int intSeparator) {
        return buildSeparator(sequenceUniqueLetterLength, intSeparator) + buildDiamondLineCenter(diamondSideSequence, i, intSeparator) + buildSeparator(sequenceUniqueLetterLength, intSeparator);
    }

    private static String buildDiamondLineCenter(String diamondSideSequence, int i, int intSeparator) {
        return diamondSideSequence.charAt(i) == 'A' ? diamondSideSequence.charAt(i) + "" : diamondSideSequence.charAt(i) + SEPARATOR.repeat(intSeparator) + diamondSideSequence.charAt(i);
    }

    private  String buildSeparator(int sequenceUniqueLetterLength, int i) {
        int count = sequenceUniqueLetterLength - i -1;
        return SEPARATOR.repeat(Math.max(count, 0));
    }

    private boolean isAfterMiddle (String sequence, int i){
        return i >= sequence.length() / 2;
    }
}
