package io.github.arsiac.step.core;

import java.util.Comparator;

/**
 * 有序步骤比较器
 *
 * @author arsiac
 * @since 2024/02/01
 */
public class OrderedStepComparator implements Comparator<OrderedStep> {

    @Override
    public int compare(OrderedStep o1, OrderedStep o2) {
        return o1.getOrder() - o2.getOrder();
    }

}
