package io.mybartab.spendingservice.service;

import io.mybartab.spendingservice.dto.SpendingMessageDto;
import io.mybartab.spendingservice.message.PubsubOutboundGateway;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SpendingServiceImpl implements SpendingService {
    private final PubsubOutboundGateway pubsubOutboundGateway;

    public SpendingServiceImpl(PubsubOutboundGateway pubsubOutboundGateway) {
        this.pubsubOutboundGateway = pubsubOutboundGateway;
    }

    @Override
    public void sendToPubSub(String s) {
        pubsubOutboundGateway.sendSpending(new SpendingMessageDto("971559", UUID.randomUUID().toString(), "17.34", "EUR"));
    }
}
