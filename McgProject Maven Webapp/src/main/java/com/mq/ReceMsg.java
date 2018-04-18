package com.mq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by macg11 on 2018/4/16.
 */
public class ReceMsg {

    private static String QEUE_NAME="testmq";

    public static void main(String[] args)throws Exception{
        Connection connection=ConnectionUtils.getConnection();

        Channel  channel=connection.createChannel();

        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);

            }
        };
    }


}
