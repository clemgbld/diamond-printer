package app.netlify.clementgombauld.dimondprinter.adapters.secondary;

import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.Logger;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLogger implements Logger {

    private final List<Object> logs = new ArrayList<>();

    public List<Object> getLogs(){
        return logs;
    }

    @Override
    public void log(Object input) {
        logs.add(input);
    }
}
