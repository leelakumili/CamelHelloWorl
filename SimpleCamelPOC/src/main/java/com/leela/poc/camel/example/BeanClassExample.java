package com.leela.poc.camel.example;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class BeanClassExample {


	public static void main(String[] args) throws Exception {

		

		
		Employee e = new Employee("Leela", "IT");
		
		SimpleRegistry registry = new SimpleRegistry();
		registry.put("employee", e);
		CamelContext context = new DefaultCamelContext(registry);
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				//from("direct:start").to("class:com.leela.poc.camel.example.Employee?method=hello");
				from("direct:start").to("bean:employee?method=display");
				
			}
		});

		

		ProducerTemplate producer = context.createProducerTemplate();
		context.start();
		
		producer.sendBody("direct:start", e);
	}



}
