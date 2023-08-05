package app.netlify.clementgombauld.dimondprinter.adapters.secondary;
import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;
import org.jline.reader.LineReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SpringShellCommandLine implements CommandLine {

    private LineReader lineReader;

    @Autowired
    @Lazy
    public SpringShellCommandLine(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    @Override
    public void log(Object obj) {
        System.out.println(obj);
    }

    @Override
    public String getInput(String input) {
        return lineReader.readLine(input);
    }
}
