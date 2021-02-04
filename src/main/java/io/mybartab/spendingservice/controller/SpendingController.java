package io.mybartab.spendingservice.controller;

import io.mybartab.spendingservice.dto.CreateSpendingDto;
import io.mybartab.spendingservice.service.SpendingClient;
import io.mybartab.spendingservice.service.SpendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Optional;

@RestController
@RequestMapping("/spending")
@Slf4j
public class SpendingController {
    private final SpendingService spendingService;
    private final SpendingClient spendingClient;

    public SpendingController(SpendingService spendingService, SpendingClient spendingClient) {
        this.spendingService = spendingService;
        this.spendingClient = spendingClient;
    }

    @PostMapping
    public ResponseEntity<CreateSpendingDto> test(@Valid @RequestBody CreateSpendingDto createSpendingDto) {
        spendingService.sendToPubSub(createSpendingDto);
        return ResponseEntity.ok(createSpendingDto);
    }

    @GetMapping("/sum/{externalId}")
    public ResponseEntity<Optional<BigDecimal>> getSum(@PathVariable String externalId) {
        return ResponseEntity.ok(spendingClient.getSum(externalId));
    }
}
