package com.mq;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by macg11 on 2018/4/16.
 */
public class ConnectionUtils {

    public static Connection getConnection()throws Exception{
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("mcg");
        factory.setPort(5672);
        factory.setPassword("mcg");
        factory.setVirtualHost("/testmq");
        return factory.newConnection();
    }


}
