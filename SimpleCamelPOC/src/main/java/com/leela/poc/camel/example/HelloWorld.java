package com.leela.poc.camel.example;

import org.apache.camel.CamelContext;
import org.apache.camel.ConsumerTemplate;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class HelloWorld {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();

		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				from("direct:start").process(new Processor() {
					
					public void process(Exchange exchange) throws Exception {
						String message = exchange.getIn().getBody(String.class);
						message = message.concat(" & processor too");
						exchange.getOut().setBody(message);
						
						
					}
				}).to("seda:end");
				
			}
		});

		

		ProducerTemplate producer = context.createProducerTemplate();
		ConsumerTemplate consumer = context.createConsumerTemplate();
		
		context.start();
		producer.sendBody("direct:start", "Hello from producer");

		String message = consumer.receiveBody("seda:end", String.class);

		System.out.println(message);
	}

}
