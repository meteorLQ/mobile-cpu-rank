package com.lq.rank.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Setting;

@Builder
@Data
@Document(indexName = "book")
@Setting(useServerConfiguration = true)
public class Book {
    private String name;
    private String price;
    private String img;
}
