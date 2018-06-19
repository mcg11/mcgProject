package com.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by macg11 on 2018/4/16.
 */
public class SendMsg {

//    private static String QEUE_NAME="testmq";

    private static String EXCHAGE_NAME="test_exchange_topic";

    public static void main(String[] args)throws Exception{
        Connection connection=ConnectionUtils.getConnection();

        Channel channel=connection.createChannel();

        channel.basicQos(1);
        channel.exchangeDeclare(EXCHAGE_NAME,"topic");

        try {
            channel.txSelect();
//        for(int i=0;i<50;i++){
            String msg = "hello rabbitmq!";

            channel.basicPublish(EXCHAGE_NAME, "good.add", null, msg.getBytes());

            channel.txCommit();

//            Thread.sleep(i*20);
//        }
        }catch (Exception e){
            channel.txRollback();
        }

        channel.close();
        connection.close();

    }

}
