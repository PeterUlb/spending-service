package io.mybartab.spendingservice.controller;

import io.mybartab.spendingservice.dto.CreateSpendingDto;
import io.mybartab.spendingservice.service.SpendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/spending")
@Slf4j
public class SpendingController {
    private final SpendingService spendingService;

    public SpendingController(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @PostMapping
    public ResponseEntity<CreateSpendingDto> test(@Valid @RequestBody CreateSpendingDto createSpendingDto) {
        spendingService.sendToPubSub(createSpendingDto);
        return ResponseEntity.ok(createSpendingDto);
    }

    @GetMapping("/sum/{externalId}")
    public ResponseEntity<BigDecimal> getSum(@PathVariable String externalId) {
        return ResponseEntity.ok(BigDecimal.ONE);
    }
}
