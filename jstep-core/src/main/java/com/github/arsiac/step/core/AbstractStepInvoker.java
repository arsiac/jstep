package com.github.arsiac.step.core;

import com.github.arsiac.step.api.StepChain;
import com.github.arsiac.step.api.StepContext;
import com.github.arsiac.step.api.StepInvoker;

/**
 * 默认步骤执行器
 *
 * @author arsiac
 * @since 2024/01/31
 */
public abstract class AbstractStepInvoker implements StepInvoker {

    @Override
    public void invoke(Object[] args) {
        StepContext context = createContext(args);
        StepContextHolder.setContext(context);
        getStepChain().doStep(context);
        StepContextHolder.removeContext();
    }

    /**
     * 获取步骤链
     *
     * @return 步骤链
     */
    public abstract StepChain getStepChain();

    /**
     * 创建步骤上下文
     *
     * @param args 上下文参数
     * @return 步骤上下文
     */
    protected abstract StepContext createContext(Object[] args);

}
