package com.personal.TravelPlanner.repository;

import com.personal.TravelPlanner.entity.Token;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TokenRepository extends MongoRepository<Token,String> {

    List<Token> findByUser_IdAndExpiredIsFalseAndRevokedIsFalse(String userId);

    Optional<Token> findByToken(String jwt);

}
