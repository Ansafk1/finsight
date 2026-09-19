package com.finsight.kafka;

import com.finsight.model.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionConsumer {
    @KafkaListener(topics = "transactions.raw")
    public void receiveTransactions(Transaction transaction){
        System.out.println(transaction);
    }
}
