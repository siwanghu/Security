package com.auditoryworks.repository;

import com.auditoryworks.domain.MDMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MDMessageRepository extends MongoRepository<MDMessage, Integer> {
    List<MDMessage> getAllByUserName(String userName);
}