package app.netlify.clementgombauld.dimondprinter.core.application;

import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;
import app.netlify.clementgombauld.dimondprinter.infra.InMemoryCommandLine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisplayDiamondTest {

    @Test
    void shouldDisplayDiamond(){
        CommandLine commandLine = new InMemoryCommandLine(List.of("A"));
        DisplayDiamond displayDiamond = new DisplayDiamond(commandLine);
        displayDiamond.display();
        InMemoryCommandLine inMemoryCommandLine = (InMemoryCommandLine) commandLine;
        List<Object> diamondLinesLogs = inMemoryCommandLine.getDiamondLinesLogs();
        String inputSentence = inMemoryCommandLine.getInputSentence();
        assertEquals("Enter a letter: ",inputSentence);
        assertEquals(List.of("A"),diamondLinesLogs);
    }

}