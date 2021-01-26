package io.mybartab.spendingservice.message;

import io.mybartab.spendingservice.dto.SpendingMessageDto;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@MessagingGateway
@Component
public interface PubsubOutboundGateway {
    @Gateway(requestChannel = "add-spending-v1-out")
    void sendSpending(SpendingMessageDto spendingMessageDto);
}
