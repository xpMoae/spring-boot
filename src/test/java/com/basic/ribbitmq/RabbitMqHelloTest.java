package com.basic.ribbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.basic.rabbitmq.HelloSender;
import com.basic.rabbitmq.topic.TopicSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;
    @Autowired
    private TopicSender topicSender;

    @Test
    public void hello() throws Exception {
    	topicSender.send();
    }

}
