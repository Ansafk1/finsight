package com.finsight.kafka;
import org.springframework.kafka.core.KafkaTemplate;
import com.finsight.model.Transaction;
import org.springframework.stereotype.Component;
@Component
public class TransactionProducer {
    private KafkaTemplate<String, Transaction> kafkaTemplate;
    public TransactionProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendTransaction(Transaction transaction){
        kafkaTemplate.send("transactions.raw", transaction);
    }
}
