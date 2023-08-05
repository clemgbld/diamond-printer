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

            commandLine.log("");
            logDiamondLines(diamondSideSequence,sequenceUniqueLetterLength,0,0,-1);
        }catch (NotLetterException e){
            commandLine.log("Please provide a correct single letter");
            display();
        }

    }

    private void logDiamondLines(String diamondSideSequence, int sequenceUniqueLetterLength, int i, int intSeparator,int intSeparatorCenter){
        if(i >= diamondSideSequence.length()) return;
        commandLine.log(buildDiamondLine(diamondSideSequence, sequenceUniqueLetterLength, i, intSeparator,intSeparatorCenter));
        logDiamondLines(diamondSideSequence,
                sequenceUniqueLetterLength,
                i + 1,
                isAfterMiddle(diamondSideSequence, i) ? intSeparator - 1 : intSeparator + 1,
                isAfterMiddle(diamondSideSequence, i) ? intSeparatorCenter - 2 : intSeparatorCenter + 2
                );

    }

    private String buildDiamondLine(String diamondSideSequence, int sequenceUniqueLetterLength, int i, int intSeparator,int intSeparatorCenter) {
        return buildSeparator(sequenceUniqueLetterLength, intSeparator) + buildDiamondLineCenter(diamondSideSequence, i, intSeparatorCenter) + buildSeparator(sequenceUniqueLetterLength, intSeparator);
    }

    private static String buildDiamondLineCenter(String diamondSideSequence, int i ,int intSeparatorCenter) {
        return diamondSideSequence.charAt(i) == 'A' ? diamondSideSequence.charAt(i) + "" : diamondSideSequence.charAt(i) + SEPARATOR.repeat(intSeparatorCenter) + diamondSideSequence.charAt(i);
    }

    private  String buildSeparator(int sequenceUniqueLetterLength, int i) {
        int count = sequenceUniqueLetterLength - i -1;
        return SEPARATOR.repeat(Math.max(count, 0));
    }

    private boolean isAfterMiddle (String sequence, int i){
        return i >= sequence.length() / 2;
    }
}
