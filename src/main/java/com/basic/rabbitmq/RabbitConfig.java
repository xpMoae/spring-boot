package com.basic.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

public class RabbitConfig {
	@Bean
	public Queue QueueTest() {
		return new Queue("hello");
	}
}
