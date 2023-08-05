package app.netlify.clementgombauld.dimondprinter.core.application;

import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.InMemoryCommandLine;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisplayDiamondTest {

    @Test
    void shouldDisplayDiamondWithA(){
        CommandLine commandLine = new InMemoryCommandLine(List.of("A"));
        DisplayDiamond displayDiamond = new DisplayDiamond(commandLine);
        displayDiamond.display();
        InMemoryCommandLine inMemoryCommandLine = (InMemoryCommandLine) commandLine;
        List<Object> diamondLinesLogs = inMemoryCommandLine.getDiamondLinesLogs();
        assertEquals(List.of("","A"),diamondLinesLogs);
    }



    @Test
    void shouldDisplayDiamondWithB(){
        CommandLine commandLine = new InMemoryCommandLine(List.of("B"));
        DisplayDiamond displayDiamond = new DisplayDiamond(commandLine);
        displayDiamond.display();
        InMemoryCommandLine inMemoryCommandLine = (InMemoryCommandLine) commandLine;
        List<Object> diamondLinesLogs = inMemoryCommandLine.getDiamondLinesLogs();
        String inputSentence = inMemoryCommandLine.getInputSentence();
        assertEquals("Enter a letter: ",inputSentence);
        assertEquals(List.of(""," A ","B B", " A "),diamondLinesLogs);
    }

    @Test
    void shouldDisplayDiamondWithC(){
        CommandLine commandLine = new InMemoryCommandLine(List.of("C"));
        DisplayDiamond displayDiamond = new DisplayDiamond(commandLine);
        displayDiamond.display();
        InMemoryCommandLine inMemoryCommandLine = (InMemoryCommandLine) commandLine;
        List<Object> diamondLinesLogs = inMemoryCommandLine.getDiamondLinesLogs();
        assertEquals(List.of("","  A  ", " B B ", "C   C", " B B ","  A  "),diamondLinesLogs);
    }


    @Test
    void  shouldAskTheUserToEnterALetterUntilItDoes(){
        CommandLine commandLine = new InMemoryCommandLine(List.of("@","A"));
        DisplayDiamond displayDiamond = new DisplayDiamond(commandLine);
        displayDiamond.display();
        InMemoryCommandLine inMemoryCommandLine = (InMemoryCommandLine) commandLine;
        List<Object> diamondLinesLogs = inMemoryCommandLine.getDiamondLinesLogs();
        assertEquals(List.of("Please provide a correct single letter","","A"),diamondLinesLogs);

    }





}