package com.github.arsiac.step.core;

import com.github.arsiac.step.api.Step;
import com.github.arsiac.step.api.StepRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 默认步骤注册器
 *
 * @author arsiac
 * @since 2024/01/04
 */
public final class DefaultStepRegistry implements StepRegistry {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultStepRegistry.class);

    /**
     * 步骤列表
     */
    private final List<Step> stepList = new ArrayList<>();

    @Override
    public Step[] getSteps() {
        return stepList.toArray(new Step[0]);
    }

    @Override
    public int getStepCount() {
        return stepList.size();
    }

    @Override
    public Step getStep(int index) {
        return stepList.get(index);
    }

    @Override
    public void registerStep(Step step) {
        LOGGER.info("Register step '{}'", step.getStepName());
        stepList.add(step);
    }

    @Override
    public Iterator<Step> iterator() {
        return new NotDeleteStepIterator();
    }

    /**
     * 仅遍历迭代器
     */
    class NotDeleteStepIterator implements Iterator<Step> {

        private final Iterator<Step> delegate = stepList.iterator();

        @Override
        public boolean hasNext() {
            return delegate.hasNext();
        }

        @Override
        public Step next() {
            return delegate.next();
        }

    }

}
