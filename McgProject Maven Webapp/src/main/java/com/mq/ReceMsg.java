package com.mq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by macg11 on 2018/4/16.
 */
public class ReceMsg {

    private static String QEUE_NAME="testtopic1";

    private static String EXCHAGE_NAME="test_exchange_topic";

    public static void main(String[] args)throws Exception{
        Connection connection=ConnectionUtils.getConnection();

        final Channel  channel=connection.createChannel();
        channel.queueDeclare(QEUE_NAME, false, false, false, null);

        channel.queueBind(QEUE_NAME,EXCHAGE_NAME,"good.add");

        channel.basicQos(1);

        final Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {

                String message = new String(body, "UTF-8");
                System.out.println("Customer Received [1]'" + message + "'");
                try{
                    Thread.sleep(2000);

                }catch (InterruptedException e){
                }finally {
                    channel.basicAck(envelope.getDeliveryTag(),false);

                }
            }
        };
        channel.basicConsume(QEUE_NAME, false, consumer);

    }


}
