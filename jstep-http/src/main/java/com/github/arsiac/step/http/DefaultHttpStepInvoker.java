package com.github.arsiac.step.http;

import com.github.arsiac.step.api.StepChain;
import com.github.arsiac.step.api.StepContext;
import com.github.arsiac.step.api.StepRegistry;
import com.github.arsiac.step.core.DefaultStepChain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 默认HTTP步骤执行器
 *
 * @author arsiac
 * @since 2023/08/24
 */
public class DefaultHttpStepInvoker extends AbstractHttpStepInvoker {

    /**
     * 步骤执行器
     */
    private final StepRegistry registry;

    public DefaultHttpStepInvoker(StepRegistry registry) {
        this.registry = registry;
    }

    @Override
    public StepChain getStepChain() {
        return new DefaultStepChain(registry);
    }

    @Override
    protected StepContext createContext(HttpServletRequest request, HttpServletResponse response) {
        return new HttpStepContext(request, response);
    }

}
