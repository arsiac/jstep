package com.github.arsiac.step.api;

import java.util.Iterator;

/**
 * 步骤注册
 *
 * @author arsiac
 * @since 2023/08/24
 */
public interface StepRegistry {

    /**
     * 获取排序好的步骤
     *
     * @return 步骤数组
     */
    Step[] getSteps();

    /**
     * 获取步骤数量
     *
     * @return 步骤数量
     */
    int getStepCount();

    /**
     * 获取步骤
     *
     * @param index 步骤索引
     * @return 步骤
     */
    Step getStep(int index);

    /**
     * 注册步骤
     *
     * @param step 步骤
     */
    void registerStep(Step step);

    /**
     * 步骤迭代器
     *
     * @return 步骤迭代器
     */
    Iterator<Step> iterator();

}
