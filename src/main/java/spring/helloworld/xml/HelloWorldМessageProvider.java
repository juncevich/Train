package spring.helloworld.xml;

import spring.helloworld.MessageProvider;


public class HelloWorldМessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World !!!";
    }
}
