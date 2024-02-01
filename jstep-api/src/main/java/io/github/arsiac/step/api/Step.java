package io.github.arsiac.step.api;

/**
 * 执行步骤
 *
 * @author arsiac
 * @since 2023/08/24
 */
public interface Step {

    /**
     * 前置步骤
     *
     * @param context 步骤上下文
     */
    default void before(io.github.arsiac.step.api.StepContext context) {}

    /**
     * 后置步骤
     *
     * @param context 步骤上下文
     */
    default void after(io.github.arsiac.step.api.StepContext context) {}

    /**
     * 执行步骤
     *
     * @param context 步骤上下文
     * @param chain   步骤链
     */
    default void doStep(io.github.arsiac.step.api.StepContext context, io.github.arsiac.step.api.StepChain chain) {
        context.setCurrentStep(this);
        before(context);
        chain.doStep(context);
        after(context);
    }

    /**
     * 获取步骤名称
     *
     * @return 步骤名称
     */
    default String getStepName() {
        return getClass().getSimpleName();
    }

}
