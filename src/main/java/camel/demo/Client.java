package camel.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Client
{
    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws IOException
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/client.spring.xml");
        ProducerTemplate template = ctx.getBean("clientTemplate", ProducerTemplate.class);
        LOGGER.info("Started client, type what to send to server over camel...");
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        while (true)
        {
            String str = br.readLine();
            template.sendBody(str);
            LOGGER.info("Sent {}", str);
        }
    }

}
