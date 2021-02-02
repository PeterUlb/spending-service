package io.mybartab.spendingservice.service;

import io.mybartab.spendingservice.dto.CreateSpendingDto;
import io.mybartab.spendingservice.dto.SpendingMessageDto;
import io.mybartab.spendingservice.message.PubsubOutboundGateway;
import org.springframework.stereotype.Service;

@Service
public class SpendingServiceImpl implements SpendingService {
    private final PubsubOutboundGateway pubsubOutboundGateway;

    public SpendingServiceImpl(PubsubOutboundGateway pubsubOutboundGateway) {
        this.pubsubOutboundGateway = pubsubOutboundGateway;
    }

    @Override
    public void sendToPubSub(CreateSpendingDto createSpendingDto) {
        pubsubOutboundGateway.sendSpending(
                new SpendingMessageDto(createSpendingDto.getSpendingGroupId(), createSpendingDto.getIdempotencyKey(),
                        createSpendingDto.getAmount().toString(), "EUR"));
    }
}
