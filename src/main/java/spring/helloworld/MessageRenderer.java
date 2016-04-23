package spring.helloworld;

public interface MessageRenderer {
        void render () ;
        void setMessageProvider(MessageProvider provider);
        MessageProvider getMessageProvider();
}
