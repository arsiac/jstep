package io.github.arsiac.step.example.step;

import io.github.arsiac.step.api.Step;
import io.github.arsiac.step.api.StepContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class StepTwo implements Step {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepTwo.class);

    @Override
    public void before(StepContext context) {
        LOGGER.info("Step Two > before");
    }

    @Override
    public void after(StepContext context) {
        LOGGER.info("Step Two > after");
    }

}
