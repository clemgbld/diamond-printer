package app.netlify.clementgombauld.dimondprinter.configurations;

import app.netlify.clementgombauld.dimondprinter.core.application.DisplayDiamond;
import app.netlify.clementgombauld.dimondprinter.core.domain.CommandLine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public DisplayDiamond getDisplayDiamond(CommandLine commandLine){
        return new DisplayDiamond(commandLine);
    }
}
