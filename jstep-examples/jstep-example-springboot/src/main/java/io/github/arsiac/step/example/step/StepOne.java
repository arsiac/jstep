package io.github.arsiac.step.example.step;

import io.github.arsiac.step.api.Step;
import io.github.arsiac.step.api.StepContext;
import io.github.arsiac.step.http.HttpStepContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class StepOne implements Step {

    private static final Logger LOGGER = LoggerFactory.getLogger(StepOne.class);

    @Override
    public void before(StepContext context) {
        HttpStepContext ctx = (HttpStepContext) context;
        String time = ctx.getHttpRequest().getParameter("time");
        LOGGER.info("Step One > before, time={}", time);
    }

    @Override
    public void after(StepContext context) {
        LOGGER.info("Step One > after");
    }

}
