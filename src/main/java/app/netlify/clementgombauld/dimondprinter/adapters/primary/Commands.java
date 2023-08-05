package app.netlify.clementgombauld.dimondprinter.adapters.primary;

import app.netlify.clementgombauld.dimondprinter.core.application.DisplayDiamond;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class Commands {
    private DisplayDiamond displayDiamond;

    @Autowired
    public Commands(DisplayDiamond displayDiamond) {
        this.displayDiamond = displayDiamond;
    }

    @ShellMethod("Build diamond")
    public void diamond(){
        displayDiamond.display();
    }
}
