package com.lq.rank.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {
    private String name;
    private String age;
    private Date birthday;
}
