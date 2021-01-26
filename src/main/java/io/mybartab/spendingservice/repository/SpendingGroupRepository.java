package io.mybartab.spendingservice.repository;

import io.mybartab.spendingservice.model.SpendingGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpendingGroupRepository extends JpaRepository<SpendingGroup, Long> {
    Optional<SpendingGroup> findByExternalId(String externalId);
}
