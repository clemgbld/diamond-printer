package app.netlify.clementgombauld.dimondprinter.core.domain;


import app.netlify.clementgombauld.dimondprinter.core.domain.exceptions.NotLetterException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DiamondSideSequenceTest {
    @Test
    void shouldGenerateDiamondSideSequenceBasedOnLetter() {
       assertEquals("A", DiamondSideSequence.generate("A"));
       assertEquals("ABCBA",DiamondSideSequence.generate("C"));
    }

    @Test
    void shouldGenerateDiamondSideSequenceThatIsUpperCased(){
        assertEquals("ABCBA",DiamondSideSequence.generate("c"));
    }

    @Test
    void shouldThrowAnErrorWhenInputIsNotALetter(){
        assertThrows(NotLetterException.class,()-> DiamondSideSequence.generate("cbie"));
        assertThrows(NotLetterException.class,()-> DiamondSideSequence.generate("@"));
        assertThrows(NotLetterException.class,()-> DiamondSideSequence.generate(""));
    }



}