package com.finsight.controller;
import com.finsight.model.Transaction;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.finsight.kafka.TransactionProducer;
import org.springframework.web.bind.annotation.PostMapping;
@RestController
public class TransactionController {
    private TransactionProducer transactionProducer;
    public TransactionController(TransactionProducer transactionProducer){
        this.transactionProducer = transactionProducer;
    }
    @PostMapping("/transactions")
    public void sendTransaction(@RequestBody Transaction transaction){
        transactionProducer.sendTransaction(transaction);
    }
}
