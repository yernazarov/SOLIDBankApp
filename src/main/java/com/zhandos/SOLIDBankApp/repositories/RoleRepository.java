package com.zhandos.SOLIDBankApp.repositories;

import com.zhandos.SOLIDBankApp.entities.Role;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    @Query("SELECT * FROM roles WHERE name = :name")
    Role findByName(String name);

    @Query("SELECT * FROM roles WHERE id = :id")
    Role findById(int id);
}