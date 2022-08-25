package com.worker.worker.kafka.consumer;

import com.worker.worker.kafka.handlers.ConsumerThreadHandler;
import com.worker.worker.service.Worker;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.BytesDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class KafkaMultiplyThreadConsumer {
    private final KafkaConsumer<String, Object> consumer;
    private ExecutorService executor;
    private final String topic;

    public KafkaMultiplyThreadConsumer(String brokers, String clientId, String topic) {
        Properties prop = createConsumerConfig(brokers, clientId);
        this.consumer = new KafkaConsumer<>(prop);
        this.topic = topic;
        this.consumer.subscribe(Arrays.asList(this.topic));
    }

    public void execute(int numberOfThreads, Worker worker) {


        executor = new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(1000), new ThreadPoolExecutor.CallerRunsPolicy());

        while (true) {
            ConsumerRecords<String, Object> records = consumer.poll(100);
            for (final ConsumerRecord record : records) {
                int count = 0;
                count++;
                executor.submit(new ConsumerThreadHandler(record, worker, count));
            }
        }
    }

    private static Properties createConsumerConfig(String bootstrapServer, String clientId) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, clientId + "-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, BytesDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(JsonDeserializer.TYPE_MAPPINGS, "com.sibers.fluent.dto.kafka.NewFluentBookDTO:com.fluent_book_processing.FluentBookProcessing.model.kafkaModels.NewFluentBook");
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return props;
    }

    public void shutdown() {
        if (consumer != null) {
            consumer.close();
        }
        if (executor != null) {
            executor.shutdown();
        }
        try {
            if (!executor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
                System.out
                        .println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted during shutdown, exiting uncleanly");
        }
    }
}
