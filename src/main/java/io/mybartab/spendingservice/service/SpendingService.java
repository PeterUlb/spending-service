package io.mybartab.spendingservice.service;

import java.math.BigDecimal;

public interface SpendingService {
    void sendToPubSub(String s);

    BigDecimal getSumForKey(String key);
}
