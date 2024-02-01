# JStep

## Usage

### Create step

```java
import com.github.arsiac.step.api.Step;

public class DemoStep implements Step {

    public void before(StepContext context) {
        // do something
    }
    
}
```

### Invoke step

**Default**

```java
StepRegistry registry = new DefaultStepRegistry();
registry.register(new DemoStep());
StepInvoker invoker = new DefaultStepInvoker(registry);
invoker.invoke(args);
```

**HTTP**
```java
StepRegistry registry = new DefaultStepRegistry();
registry.register(new DemoStep());
StepInvoker invoker = new DefaultHttpStepInvoker(registry);
invoker.invoke(request, response);
```
### With Spring

```java
public DemoStepRegistry implements StepRegistry, ApplicationContextAware {
    
    private static final Class<? extends Step>[] SEQUENCE = new Class[]{
        Demo1Step.class,
        Demo2Step.class
    };
    
    private final StepRegistry registry = new DefaultStepRegistry();

    @Override
    public Step[] getSteps() {
        return registry.getSteps();
    }

    @Override
    public int getStepCount() {
        return registry.getStepCount();
    }

    @Override
    public Step getStep(int index) {
        return registry.getStep(index);
    }

    @Override
    public void registerStep(Step step) {
        registry.registerStep(step);
    }

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext context) {
        for (int i = 0; i < SEQUENCE.length; i++) {
            Step step = context.getBean(SEQUENCE[i]);
            registry.registerStep(new OrderedStep(step, i));
        }
    }
}
```

```java
@Configuration
public class StepConfig {

    @Bean
    public StepRegistry stepRegistry() {
        return new DemoStepRegistry();
    }
    
    @Bean
    public HttpStepInvoker httpStepInvoker(StepRegistry stepRegistry) {
        return new DefaultHttpStepInvoker(stepRegistry);
    }
}
```

```java
@RestController
public class DemoController {
    
    private final HttpStepInvoker stepInvoker;
    
    public DemoController(HttpStepInvoker stepInvoker) {
        this.stepInvoker = stepInvoker;
    }
    
    public void serve(HttpServletRequest request, HttpServletResponse response) {
        stepInvoker.invoke(request, response);
    }
}
```
