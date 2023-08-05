package app.netlify.clementgombauld.dimondprinter.infra;

import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;
import org.jline.reader.LineReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
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
    @ShellMethod
    public String getInput(String input) {
        return lineReader.readLine(input);
    }
}
