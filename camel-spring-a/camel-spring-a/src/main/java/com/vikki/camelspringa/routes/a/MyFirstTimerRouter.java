package com.vikki.camelspringa.routes.a;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Component
public class MyFirstTimerRouter extends RouteBuilder {


	@Autowired
	private GetCurrentTimeBean getCurrentTime;
	
	@Autowired
	private SimpleLogComponent LogComponent ;
	
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("timer:first-timer")
		
//		.transform().constant("My Constant Messgae")
//		.transform().constant("Time now is "+LocalDateTime.now())		
//		.bean("getCurrentTimeBean")
//		.bean(getCurrentTime)
		.bean(getCurrentTime,"getCurrenTime")
		.log("${body}")
		.bean(LogComponent)
		.log("${body}")
		
		.process(new SimpleLoggingProcess())
		.to("log:first-timer");
		
	}

}

@Component
class GetCurrentTimeBean
{
	public String getCurrenTime() {
		return "Time now is "+LocalDateTime.now();
	}
	
}

@Component
class SimpleLogComponent
{
	private Logger logger = LoggerFactory.getLogger(SimpleLogComponent.class);
	public void process(String Message) {
		logger.info("SimpleLogComponent {}",Message);
	}
	

}



 
class SimpleLoggingProcess implements Processor {
	private Logger logger = LoggerFactory.getLogger(SimpleLoggingProcess.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("SimpleLoggingProcess {}",exchange.getMessage().getBody());
		// TODO Auto-generated method stub

	}

}