package com.vikki.camelspringa.route.c;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyActiveMqSenser extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:active-mq-timer?period=10000")
		.transform().constant("My Message for Active MQ")
		.to("activemq:my-activemq-queue");
	
	}

}
