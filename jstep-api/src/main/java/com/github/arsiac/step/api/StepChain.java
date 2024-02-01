package com.github.arsiac.step.api;

/**
 * 步骤链
 *
 * @author arsiac
 * @since 2023/08/24
 */
public interface StepChain {

    /**
     * 执行步骤
     *
     * @param context 场景
     */
    void doStep(StepContext context);

}
