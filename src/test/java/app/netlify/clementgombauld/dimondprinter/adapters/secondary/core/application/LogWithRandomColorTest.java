package app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.application;

import app.netlify.clementgombauld.dimondprinter.adapters.secondary.InMemoryLogger;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.InMemoryRandomNumGenerator;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.Logger;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.RandomNumGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogWithRandomColorTest {

    @Test
    void shouldLogInputWithARandomColor(){
        Logger logger = new InMemoryLogger();
        RandomNumGenerator randomNumGenerator= new InMemoryRandomNumGenerator(List.of(2));
        LogWithRandomColor logWithRandomColor = new LogWithRandomColor(logger,randomNumGenerator);
        logWithRandomColor.log("A");
        InMemoryLogger inMemoryLogger = (InMemoryLogger) logger;
        InMemoryRandomNumGenerator inMemoryRandomNumGenerator = (InMemoryRandomNumGenerator) randomNumGenerator;
        assertEquals(List.of("\u001B[" + "32" + "m" + "A" + "\u001B[0m"),inMemoryLogger.getLogs());
        assertEquals(List.of(8),inMemoryRandomNumGenerator.getNonInclusiveLimitNumbers());

    }

}