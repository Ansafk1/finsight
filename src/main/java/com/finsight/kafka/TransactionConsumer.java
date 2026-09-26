package com.finsight.kafka;

import com.finsight.model.Transaction;
import com.finsight.repository.TransactionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransactionConsumer {
    @KafkaListener(topics = "transactions.raw",groupId = "finsight")
    public void receiveTransactions(Transaction transaction){
        log.info("Received: {} amount={}", transaction.getId(), transaction.getAmount());
        transactionRepository.save(transaction);
    }
    private TransactionRepository transactionRepository;
    public TransactionConsumer(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
}
