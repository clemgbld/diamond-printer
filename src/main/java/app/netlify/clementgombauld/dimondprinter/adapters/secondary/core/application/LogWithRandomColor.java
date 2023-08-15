package app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.application;

import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.Logger;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.RandomNumGenerator;

public class LogWithRandomColor {
    public static final int COLOR_CODE_BASE = 30;
    public static final int COLOR_NON_INCLUSIVE_LIMIT = 8;
    private final Logger logger;
    private final RandomNumGenerator randomNumGenerator;

    public LogWithRandomColor(Logger logger, RandomNumGenerator randomNumGenerator) {
        this.logger = logger;
        this.randomNumGenerator = randomNumGenerator;
    }

    public void log(String input) {
        int colorCode = COLOR_CODE_BASE + randomNumGenerator.generate(COLOR_NON_INCLUSIVE_LIMIT);
        logger.log("\u001B[" + colorCode + "m" + input + "\u001B[0m");
    }
}
