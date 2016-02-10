package com.ecomm.repository;

import com.ecomm.entity.NomCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Silviu on 2/10/16.
 */
public interface CategoryRepository extends MongoRepository<NomCategory, Long> {

}
