package camel.demo.client.routes;

import org.apache.camel.spring.SpringRouteBuilder;

public class ClientRoute extends SpringRouteBuilder
{

    @Override
    public void configure() throws Exception
    {
       from("direct:client").to("file://target/camelmsg");
    }

}
