package com.fabCeylon.TheFabCeylon.repository;

import com.fabCeylon.TheFabCeylon.domain.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByContactNumber(String contactNumber);
}
