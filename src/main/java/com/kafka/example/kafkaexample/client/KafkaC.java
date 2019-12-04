package com.kafka.example.kafkaexample.client;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

/**
 * @version 1.0  2019/11/24
 * @auther <a href="mailto:fw19940314@gmail.com">jerry.feng</a>
 * @since 1.0
 */
public class KafkaC {

    public static void main(String[] args) {
          //kafka提供配置属性
//        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG;
//        ConsumerConfig.GROUP_ID_CONFIG;

        Properties properties = new Properties();
        Resource resource = new ClassPathResource("classpath:kafka.properties");
        try {
            properties.load(resource.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();

            // 创建消费者
            KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);
            for (int i = 0; i < 10; i++) {
                kafkaProducer.send(new ProducerRecord<>("firstTopic", "kafka_example_" + i));
            }
            //关闭资源
            kafkaProducer.close();

        }
    }
}
