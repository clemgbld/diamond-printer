package app.netlify.clementgombauld.dimondprinter.adapters.secondary;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.application.LogWithRandomColor;
import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;
import org.jline.reader.LineReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SpringShellCommandLine implements CommandLine {

    private final LineReader lineReader;
    private final LogWithRandomColor logWithRandomColor;

    @Autowired
    @Lazy
    public SpringShellCommandLine(LineReader lineReader,LogWithRandomColor logWithRandomColor) {
        this.lineReader = lineReader;
        this.logWithRandomColor = logWithRandomColor;
    }

    @Override
    public void log(Object obj) {
        logWithRandomColor.log(obj);
    }

    @Override
    public String getInput(String input) {
        return lineReader.readLine(input);
    }
}
