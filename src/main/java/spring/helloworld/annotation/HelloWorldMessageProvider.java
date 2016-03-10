package spring.helloworld.annotation;

import org.springframework.stereotype.Service;
import spring.helloworld.MessageProvider;

@Service("messageProvider")
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
