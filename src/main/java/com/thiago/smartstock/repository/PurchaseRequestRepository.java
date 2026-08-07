package com.thiago.smartstock.repository;

import com.thiago.smartstock.entity.PurchaseRequestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRequestRepository extends MongoRepository<PurchaseRequestEntity, String> {
}
