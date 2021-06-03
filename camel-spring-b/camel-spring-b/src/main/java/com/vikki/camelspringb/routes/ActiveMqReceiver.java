package com.vikki.camelspringb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqReceiver extends RouteBuilder{



	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		from("activemq:my-activemq-queue")
		.to("log:received-msg");		
	}
}