package com.lms.bff.repository;

import com.lms.bff.entity.UserEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface AccountDetailsRepo extends ReactiveCrudRepository<UserEntity, Integer> {
  Flux<UserEntity> findByAccessLevel(String accessLevel);
}
