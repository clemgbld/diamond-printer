package app.netlify.clementgombauld.dimondprinter.core.domain;

public interface CommandLine {
    void log (Object obj);

    String getInput(String input);


}
