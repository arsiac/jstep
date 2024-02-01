package io.github.arsiac.step.http;

import io.github.arsiac.step.api.StepInvoker;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 步骤执行器
 *
 * @author arsiac
 * @since 2023/08/24
 */
public interface HttpStepInvoker extends StepInvoker {

    /**
     * 执行步骤
     *
     * @param request  HTTP 请求
     * @param response HTTP 响应
     */
    void invoke(HttpServletRequest request, HttpServletResponse response);

}
