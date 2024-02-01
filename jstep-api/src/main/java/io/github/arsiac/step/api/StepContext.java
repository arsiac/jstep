package io.github.arsiac.step.api;

/**
 * 步骤上下文
 *
 * @author arsiac
 * @since 2024/01/31
 */
public interface StepContext {

    /**
     * 获取当前步骤
     *
     * @return 当前步骤
     */
    Step getCurrentStep();

    /**
     * 设置当前步骤
     *
     * @param step 当前步骤
     */
    void setCurrentStep(Step step);

    /**
     * 获取执行参数
     *
     * @return 执行参数
     */
    Object[] getArguments();

    /**
     * 设置属性
     *
     * @param name  属性名
     * @param value 属性值
     */
    void setAttribute(String name, Object value);

    /**
     * 获取属性
     *
     * @param name 属性名
     * @return 属性值
     */
    Object getAttribute(String name);

    /**
     * 获取属性
     *
     * @param name  属性名
     * @param clazz 属性值类型
     * @param <T>   属性值类型
     * @return 属性值
     */
    <T> T getAttribute(String name, Class<T> clazz);

}
