package io.github.arsiac.step.example;

import io.github.arsiac.step.api.Step;
import io.github.arsiac.step.api.StepRegistry;
import io.github.arsiac.step.core.DefaultStepRegistry;
import io.github.arsiac.step.http.DefaultHttpStepInvoker;
import io.github.arsiac.step.http.HttpStepInvoker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StepConfiguration {

    @Bean
    public StepRegistry stepRegistry(List<Step> steps) {
        DefaultStepRegistry registry = new DefaultStepRegistry();
        for (Step step : steps) {
            registry.registerStep(step);
        }
        return registry;
    }

    @Bean
    public HttpStepInvoker httpStepInvoker(StepRegistry stepRegistry) {
        return new DefaultHttpStepInvoker(stepRegistry);
    }

}
