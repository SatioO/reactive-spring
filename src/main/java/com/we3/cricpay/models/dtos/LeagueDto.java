package com.we3.cricpay.models.dtos;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LeagueDto {
    private Integer id;
    private String name;
    private String description;
    private boolean enabled;
}
