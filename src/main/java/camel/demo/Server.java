package camel.demo;

import org.apache.camel.ConsumerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class Server
{
    private static final Logger LOGGER= LoggerFactory.getLogger(Server.class);

    public static void main(String[] args)
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/server.spring.xml");
        ConsumerTemplate template = ctx.getBean("serverTemplate", ConsumerTemplate.class);
        LOGGER.info("Started server, waiting for input over Camel...");
        while(true)
        {
            String message = template.receiveBody("file://target/camelmsg", String.class);
            LOGGER.info("Got message: '{}", message);
        }
        
    }
}
