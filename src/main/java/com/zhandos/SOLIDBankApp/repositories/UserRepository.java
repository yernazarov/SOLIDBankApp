package com.zhandos.SOLIDBankApp.repositories;

import com.zhandos.SOLIDBankApp.entities.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM users WHERE username = :username")
    User findUserByUsername(String username);
}
