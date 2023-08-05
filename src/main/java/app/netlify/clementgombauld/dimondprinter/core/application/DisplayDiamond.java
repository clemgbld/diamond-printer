package app.netlify.clementgombauld.dimondprinter.core.application;

import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;

public class DisplayDiamond {
    public static final String ENTER_A_LETTER = "Enter a letter: ";
    private CommandLine commandLine;
    public DisplayDiamond(CommandLine commandLine) {
        this.commandLine = commandLine;
    }

    public void display() {
        commandLine.log(commandLine.getInput(ENTER_A_LETTER));
    }
}
