package com.zhandos.SOLIDBankApp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("users")
public class User {
    private @Id @Column("id") int userID;
    private @Column("username") String username;
    private @Column("password") String password;
    private @Column("role_id") int roleId;
}