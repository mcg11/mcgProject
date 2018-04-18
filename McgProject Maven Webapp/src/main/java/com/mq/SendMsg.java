package com.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created by macg11 on 2018/4/16.
 */
public class SendMsg {

    private static String QEUE_NAME="testmq";

    public static void main(String[] args)throws Exception{
        Connection connection=ConnectionUtils.getConnection();

        Channel channel=connection.createChannel();

        channel.queueDeclare(QEUE_NAME,false,false,false,null);

        String msg="hello rabbitmq!";

        channel.basicPublish("",QEUE_NAME,null,msg.getBytes());

        channel.close();
        connection.close();

    }

}
