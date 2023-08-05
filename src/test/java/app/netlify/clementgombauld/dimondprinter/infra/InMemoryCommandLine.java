package app.netlify.clementgombauld.dimondprinter.infra;

import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCommandLine implements CommandLine {
    private List<String> letters;

    private List<Object> diamondLinesLogs = new ArrayList<>();

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
        return letters.get(0);
    }

    public List<Object> getDiamondLinesLogs(){
        return diamondLinesLogs;
    };

    public String getInputSentence(){
        return inputSentence;
    }
}
