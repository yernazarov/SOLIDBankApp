package com.zhandos.SOLIDBankApp.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private @Id @Column("id") int userID;
    private @Column("username") String username;
    private @Column("password") String password;
}