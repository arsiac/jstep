package io.github.arsiac.step.core;

import io.github.arsiac.step.api.Step;
import io.github.arsiac.step.api.StepContext;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象步骤上下文
 *
 * @author arsiac
 * @since 2024/01/31
 */
public class DefaultStepContext implements StepContext {

    /**
     * 当前步骤
     */
    private Step currentStep;

    /**
     * 执行参数
     */
    private final Object[] arguments;

    /**
     * 用户信息
     */
    private final Map<String, Object> attributeMap = new HashMap<>();

    public DefaultStepContext(Object[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Step getCurrentStep() {
        return currentStep;
    }

    @Override
    public void setCurrentStep(Step step) {
        this.currentStep = step;
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributeMap.put(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return attributeMap.get(name);
    }

    @Override
    public <T> T getAttribute(String name, Class<T> clazz) {
        return clazz.cast(getAttribute(name));
    }

}
