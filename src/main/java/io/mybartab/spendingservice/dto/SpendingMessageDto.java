package io.mybartab.spendingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SpendingMessageDto {
    private String spendingGroupId;
    private String idempotencyKey;
    private String amount; //TODO: Cents instead
    private String currencyId;
}
