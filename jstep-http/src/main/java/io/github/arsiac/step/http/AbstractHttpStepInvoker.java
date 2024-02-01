package io.github.arsiac.step.http;

import io.github.arsiac.step.api.StepContext;
import io.github.arsiac.step.core.AbstractStepInvoker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 抽象步骤执行器
 *
 * @author arsiac
 * @since 2023/08/24
 */
public abstract class AbstractHttpStepInvoker
    extends AbstractStepInvoker implements HttpStepInvoker {

    @Override
    public void invoke(HttpServletRequest request, HttpServletResponse response) {
        Object[] args = { request, response };
        invoke(args);
    }

    @Override
    protected StepContext createContext(Object... args) {
        return createContext((HttpServletRequest) args[0], (HttpServletResponse) args[1]);
    }

    /**
     * 创建步骤上下文
     *
     * @param request  HTTP请求
     * @param response HTTP响应
     * @return 步骤上下文
     */
    protected abstract StepContext createContext(HttpServletRequest request,
                                                 HttpServletResponse response);

}
