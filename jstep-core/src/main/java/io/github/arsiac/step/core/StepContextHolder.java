package io.github.arsiac.step.core;

import io.github.arsiac.step.api.StepContext;

/**
 * 步骤上下文
 *
 * @author arsiac
 * @since 2024/01/31
 */
public final class StepContextHolder {

    /**
     * 步骤上下文
     */
    private static final ThreadLocal<StepContext> CONTEXT = new ThreadLocal<>();

    /**
     * 获取步骤上下文
     *
     * @return 步骤上下文
     */
    public static StepContext getContext() {
        return CONTEXT.get();
    }

    /**
     * 设置步骤上下文
     *
     * @param context 步骤上下文
     */
    public static void setContext(StepContext context) {
        CONTEXT.set(context);
    }

    /**
     * 清除步骤上下文
     */
    public static void removeContext() {
        CONTEXT.remove();
    }

    private StepContextHolder() {
        final String name = getClass().getName();
        throw new AssertionError("不要建立 " + name + " 实例");
    }

}
