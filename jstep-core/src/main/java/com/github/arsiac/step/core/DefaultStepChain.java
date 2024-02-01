package com.github.arsiac.step.core;

import com.github.arsiac.step.api.StepChain;
import com.github.arsiac.step.api.StepContext;
import com.github.arsiac.step.api.StepRegistry;

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
