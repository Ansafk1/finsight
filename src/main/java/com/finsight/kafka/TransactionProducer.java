package com.finsight.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import com.finsight.model.Transaction;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

@Component
public class TransactionProducer {
    private KafkaTemplate<String, Transaction> kafkaTemplate;
    public TransactionProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendTransaction(Transaction transaction){

        kafkaTemplate.send("transactions.raw", transaction.getId().toString(), transaction);
        System.out.println("Published transaction "+transaction.getId()+" to kafka");
    }

    @Scheduled(fixedRate = 1000)
    public void produceTransaction() {
        Random random = new Random();
        String[] arr = {"GROCERY", "ONLINE", "TRAVEL", "ATM", "RESTAURANT"};
        int index = random.nextInt(arr.length);
        int amount = random.nextInt(5001);
        int hour = random.nextInt(24);
        int distance = random.nextInt(501);
        Transaction tx =
                Transaction.builder()
                        .id(UUID.randomUUID())
                        .amount(new BigDecimal(amount))
                        .merchantCategory(arr[index])
                        .hourOfDay(hour)
                        .distanceFromHome(new BigDecimal(distance))
                        .createdAt(LocalDateTime.now())
                        .build();
        sendTransaction(tx);
    }
}
