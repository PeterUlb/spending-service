package io.mybartab.spendingservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.Optional;

@FeignClient(name = "spending-worker")//, url = "http://spending-worker:8081")
public interface SpendingClient {
    @GetMapping("/{id}")
    Optional<BigDecimal> getSum(@PathVariable String id);
}
