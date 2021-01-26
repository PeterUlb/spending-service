package io.mybartab.spendingservice.controller;

import io.mybartab.spendingservice.service.SpendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spending")
@Slf4j
public class SpendingController {
    private final SpendingService spendingService;

    public SpendingController(SpendingService spendingService) {
        this.spendingService = spendingService;
    }

    @GetMapping
    public ResponseEntity<String> test() {
        spendingService.sendToPubSub("Test");
        return ResponseEntity.ok("Test");
    }
}
