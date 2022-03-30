package com.lq.rank.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "car", useServerConfiguration = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String name;
    @Field(type = FieldType.Double)
    private Double price;

}
