package io.mybartab.spendingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSpendingDto {
    @NotEmpty
    String idempotencyKey;

    @NotEmpty
    @Size(min = 5, max = 9)
    String spendingGroupId;

    @NotNull
    BigDecimal amount;
}
