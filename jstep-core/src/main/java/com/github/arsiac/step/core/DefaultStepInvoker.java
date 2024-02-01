package com.github.arsiac.step.core;

import com.github.arsiac.step.api.StepChain;
import com.github.arsiac.step.api.StepContext;
import com.github.arsiac.step.api.StepRegistry;

/**
 * 默认的步骤执行器
 *
 * @author arsiac
 * @since 2024/02/01
 */
public class DefaultStepInvoker extends AbstractStepInvoker {

    /**
     * 步骤注册器
     */
    private final StepRegistry stepRegistry;

    public DefaultStepInvoker(StepRegistry stepRegistry) {
        this.stepRegistry = stepRegistry;
    }

    @Override
    public StepChain getStepChain() {
        return new DefaultStepChain(stepRegistry);
    }

    @Override
    protected StepContext createContext(Object[] args) {
        return new DefaultStepContext(args);
    }

}
