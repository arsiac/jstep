package io.github.arsiac.step.core;

import io.github.arsiac.step.api.StepChain;
import io.github.arsiac.step.api.StepContext;
import io.github.arsiac.step.api.StepRegistry;

import java.util.Objects;

/**
 * 步骤链
 *
 * @author arsiac
 * @since 2023/08/24
 */
public class DefaultStepChain implements StepChain {

    /**
     * 步骤
     */
    private final StepRegistry registry;

    /**
     * 步骤索引
     */
    private int pos = 0;

    public DefaultStepChain(StepRegistry registry) {
        this.registry = Objects.requireNonNull(registry);
    }

    @Override
    public void doStep(StepContext context) {
        if (pos < registry.getStepCount()) {
            registry.getStep(pos++).doStep(context, this);
        }
    }

}
