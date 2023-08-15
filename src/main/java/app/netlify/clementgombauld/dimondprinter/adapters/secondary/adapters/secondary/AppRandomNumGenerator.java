package app.netlify.clementgombauld.dimondprinter.adapters.secondary.adapters.secondary;

import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.RandomNumGenerator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class AppRandomNumGenerator implements RandomNumGenerator {
    private static Random random = new Random();
    @Override
    public int generate(int numberNonInclusiveLimit) {
        return random.nextInt(numberNonInclusiveLimit);
    }
}
