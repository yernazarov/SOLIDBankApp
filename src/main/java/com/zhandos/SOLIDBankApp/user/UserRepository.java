package com.zhandos.SOLIDBankApp.user;

import com.zhandos.SOLIDBankApp.account.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM users WHERE username = :username")
    User findUserByUsername(String username);
}
