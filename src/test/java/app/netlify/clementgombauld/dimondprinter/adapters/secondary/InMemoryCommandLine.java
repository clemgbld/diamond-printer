package app.netlify.clementgombauld.dimondprinter.adapters.secondary;

import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCommandLine implements CommandLine {
    private final List<String> letters;

    private final List<Object> diamondLinesLogs = new ArrayList<>();

    private int i;

    private String inputSentence;

    public InMemoryCommandLine(List<String> letters) {
        this.letters = letters;
    }

    @Override
    public void log(Object obj) {
        diamondLinesLogs.add(obj);
    }

    @Override
    public String getInput(String input) {
        inputSentence = input;
        String letter = letters.get(i);
        i++;
        return letter;
    }

    public List<Object> getDiamondLinesLogs(){
        return diamondLinesLogs;
    };

    public String getInputSentence(){
        return inputSentence;
    }
}
