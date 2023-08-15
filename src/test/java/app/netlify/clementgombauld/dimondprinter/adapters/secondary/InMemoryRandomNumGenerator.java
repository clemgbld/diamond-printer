package app.netlify.clementgombauld.dimondprinter.adapters.secondary;

import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.RandomNumGenerator;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRandomNumGenerator implements RandomNumGenerator {

    private List<Integer> randomNumbers;

    private List<Integer> nonInclusiveLimitNumbers = new ArrayList<>();


    private int currentIndex;

    public InMemoryRandomNumGenerator(List<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    @Override
    public int generate(int numberNonInclusiveLimit) {
        nonInclusiveLimitNumbers.add(numberNonInclusiveLimit);
        int randomNum = randomNumbers.get(currentIndex);
        currentIndex++;
        return randomNum;
    }

    public  List<Integer> getNonInclusiveLimitNumbers() {
        return nonInclusiveLimitNumbers;
    }
}
