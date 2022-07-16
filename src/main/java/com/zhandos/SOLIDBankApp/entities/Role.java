package com.zhandos.SOLIDBankApp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id @Column("id")
    private int id;

    @Column("name")
    private String name;
}