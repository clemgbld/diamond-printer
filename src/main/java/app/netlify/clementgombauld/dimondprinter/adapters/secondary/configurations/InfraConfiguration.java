package app.netlify.clementgombauld.dimondprinter.adapters.secondary.configurations;

import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.application.LogWithRandomColor;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.Logger;
import app.netlify.clementgombauld.dimondprinter.adapters.secondary.core.domain.RandomNumGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfraConfiguration {
    @Bean
    LogWithRandomColor getLogWithRandomColor(Logger logger, RandomNumGenerator randomNumGenerator){
        return new LogWithRandomColor(logger,randomNumGenerator);
    }
}
