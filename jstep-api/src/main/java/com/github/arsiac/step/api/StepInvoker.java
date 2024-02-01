package com.github.arsiac.step.api;

/**
 * 步骤执行器
 *
 * @author arsiac
 * @since 2023/08/24
 */
public interface StepInvoker {

    /**
     * 执行步骤
     *
     * @param args 执行参数
     */
    void invoke(Object[] args);

}
