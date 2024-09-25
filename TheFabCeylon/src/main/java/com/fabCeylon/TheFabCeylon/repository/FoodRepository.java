package com.fabCeylon.TheFabCeylon.repository;

import com.fabCeylon.TheFabCeylon.domain.user.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends MongoRepository<Food,Long> {

}
