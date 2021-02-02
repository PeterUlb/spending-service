package io.mybartab.spendingservice.service;

import io.mybartab.spendingservice.dto.CreateSpendingDto;

public interface SpendingService {
    void sendToPubSub(CreateSpendingDto createSpendingDto);
}
