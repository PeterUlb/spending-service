package io.mybartab.spendingservice.service;

import io.mybartab.spendingservice.dto.SpendingMessageDto;
import io.mybartab.spendingservice.message.PubsubOutboundGateway;
import io.mybartab.spendingservice.repository.SpendingGroupRepository;
import io.mybartab.spendingservice.repository.SpendingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class SpendingServiceImpl implements SpendingService {
    private final PubsubOutboundGateway pubsubOutboundGateway;
    private final SpendingRepository spendingRepository;
    private final SpendingGroupRepository spendingGroupRepository;

    public SpendingServiceImpl(PubsubOutboundGateway pubsubOutboundGateway, SpendingRepository spendingRepository, SpendingGroupRepository spendingGroupRepository) {
        this.pubsubOutboundGateway = pubsubOutboundGateway;
        this.spendingRepository = spendingRepository;
        this.spendingGroupRepository = spendingGroupRepository;
    }

    @Override
    public void sendToPubSub(String s) {
        pubsubOutboundGateway.sendSpending(new SpendingMessageDto("974659", UUID.randomUUID().toString(), "17.34", "EUR"));
    }

    @Override
    public BigDecimal getSumForKey(String key) {
        var grp = spendingGroupRepository.findByExternalId(key).orElseThrow(IllegalArgumentException::new);
        return spendingRepository.getSum(grp.getId());
    }
}
