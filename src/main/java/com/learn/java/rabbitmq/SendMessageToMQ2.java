package com.learn.java.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 发送消息到消息队列
 * @author liuzhaowei
 * @date 2022/2/11 11:22
 */
@Slf4j
public class SendMessageToMQ2 {

    // 队列名称
    private static final String QUEUE_NAME = "STUDENT";

    public static void main(String[] args) {
        // 创建连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // rabbitmq服务地址
        connectionFactory.setHost("localhost");
        // 端口
        connectionFactory.setPort(5672);
        // 连接超时时间
        connectionFactory.setConnectionTimeout(2000);
        // 用户名
        connectionFactory.setUsername("guest");
        // 密码
        connectionFactory.setPassword("guest");

        try {
            // 获取连接
            Connection connection = connectionFactory.newConnection();
            // 获取channel
            Channel channel = connection.createChannel();
            // 声明一个exchange
            channel.exchangeDeclare("exchange-student", "");
            // 声明一个队列
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "I'm a student";

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        }catch (Exception e) {
            log.error("获取连接异常", e);
        }
    }
}
