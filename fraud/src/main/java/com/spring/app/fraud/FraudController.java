package com.spring.app.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud_check")
@AllArgsConstructor
public class FraudController {
    private  final FraudCheckService fraudCheckService;

    @GetMapping(path="{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Integer customerID){
        boolean isFraudCustomerId = fraudCheckService.isFraudCustomerId(customerID);
        log.info("Fraud check request for customer", customerID);

        return  new FraudCheckResponse(isFraudCustomerId);
    }
}
