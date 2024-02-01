package io.github.arsiac.step.http;

import io.github.arsiac.step.api.Step;
import io.github.arsiac.step.api.StepContext;
import io.github.arsiac.step.core.DefaultStepContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 步骤上下文
 *
 * @author arsiac
 * @since 2023/08/21
 */
public class HttpStepContext implements StepContext {

    /**
     * 默认上下文
     */
    private final StepContext context;

    /**
     * HTTP请求
     */
    private final HttpServletRequest request;

    /**
     * HTTP响应
     */
    private final HttpServletResponse response;

    public HttpStepContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        context = new DefaultStepContext(new Object[]{request, response});
    }

    public HttpServletRequest getHttpRequest() {
        return request;
    }

    public HttpServletResponse getHttpResponse() {
        return response;
    }

    @Override
    public Step getCurrentStep() {
        return context.getCurrentStep();
    }

    @Override
    public void setCurrentStep(Step step) {
        context.setCurrentStep(step);
    }

    @Override
    public Object[] getArguments() {
        return context.getArguments();
    }

    @Override
    public void setAttribute(String name, Object value) {
        context.setAttribute(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return context.getAttribute(name);
    }

    @Override
    public <T> T getAttribute(String name, Class<T> clazz) {
        return context.getAttribute(name, clazz);
    }

}
