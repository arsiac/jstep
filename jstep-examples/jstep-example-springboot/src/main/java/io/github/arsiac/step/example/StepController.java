package io.github.arsiac.step.example;

import io.github.arsiac.step.http.HttpStepInvoker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/step")
public class StepController {

    private final HttpStepInvoker httpStepInvoker;

    public StepController(HttpStepInvoker httpStepInvoker) {
        this.httpStepInvoker = httpStepInvoker;
    }

    @PostMapping("/invoke")
    public void invokeStep(HttpServletRequest request, HttpServletResponse response) {
        httpStepInvoker.invoke(request, response);
    }
}
