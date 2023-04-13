package com.we3.cricpay.models.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Accessors(chain = true)
@Table("te_league")
public class League {
    @Id
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private boolean enabled;
}
