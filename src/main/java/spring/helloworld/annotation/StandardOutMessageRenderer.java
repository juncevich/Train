package spring.helloworld.annotation;

import org.springframework.stereotype.Service;
import spring.helloworld.MessageProvider;
import spring.helloworld.MessageRenderer;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider messageProvider;
    @Override
    public void render() {
        if (messageProvider == null){
            throw new RuntimeException("You must set the property messageProvider of class:"
            + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
