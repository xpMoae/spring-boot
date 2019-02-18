package com.basic.ribbitmq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectTest {
	
	 private final static String QUEUE_NAME = "hello";  
	 
	    public static void main(String[] args) throws IOException, TimeoutException {  
	        ConnectionFactory factory = new ConnectionFactory();  
	        factory.setHost("127.0.0.1");
	        factory.setUsername("guest");
	        factory.setPassword("guest");
	        factory.setPort(5672);
	        Connection connection = factory.newConnection();  
	        Channel channel = connection.createChannel();  
	 
	        channel.queueDeclare(QUEUE_NAME, false, false, false, null);  
	        String message = "Hello World!";  
	        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());  
	        System.out.println(" [x] Sent '" + message + "'");  
	 
	        channel.close();  
	        connection.close();  
	    }  

}
