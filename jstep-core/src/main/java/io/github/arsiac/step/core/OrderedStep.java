package io.github.arsiac.step.core;

import io.github.arsiac.step.api.Step;
import io.github.arsiac.step.api.StepChain;
import io.github.arsiac.step.api.StepContext;

/**
 * 有序步骤
 *
 * @author arsiac
 * @since 2024/01/02
 */
public class OrderedStep implements Step {

    /**
     * 步骤
     */
    private final Step step;

    /**
     * 排序
     */
    private final int order;

    public OrderedStep(Step step, int order) {
        this.step = step;
        this.order = order;
    }

    /**
     * 解包
     *
     * @return 原始步骤
     */
    public Step unwrap() {
        return step;
    }

    public int getOrder() {
        return order;
    }

    @Override
    public void before(StepContext context) {
        step.before(context);
    }

    @Override
    public void after(StepContext context) {
        step.after(context);
    }

    @Override
    public void doStep(StepContext context, StepChain chain) {
        step.doStep(context, chain);
    }

    @Override
    public String getStepName() {
        return step.getStepName();
    }

}
