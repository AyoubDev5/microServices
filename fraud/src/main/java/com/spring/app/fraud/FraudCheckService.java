package com.spring.app.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final  FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public  boolean isFraudCustomerId(Integer customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .createAt(LocalDateTime.now())
                        .build()
        );
        return  false;
    }
}
