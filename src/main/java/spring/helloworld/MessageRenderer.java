package spring.helloworld;

/**
 * Created by alex on 10.03.16.
 */
public interface MessageRenderer {
        void render () ;
        void setMessageProvider(MessageProvider provider);
        MessageProvider getMessageProvider();
}
