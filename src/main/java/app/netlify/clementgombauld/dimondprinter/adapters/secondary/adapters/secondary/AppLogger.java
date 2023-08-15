package app.netlify.clementgombauld.dimondprinter.adapters.secondary.adapters.secondary;

import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.Logger;
import org.springframework.stereotype.Component;

@Component
public class AppLogger implements Logger {
    @Override
    public void log(Object input) {
        System.out.println(input);
    }
}
