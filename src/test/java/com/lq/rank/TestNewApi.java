package com.lq.rank;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.InfoResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class TestNewApi {
    @Autowired
    @Qualifier("getEsClient")
    ElasticsearchClient elasticsearchClient;

    @Test
    public void test() throws Exception {
        InfoResponse info = elasticsearchClient.info();
//        elasticsearchClient.
        System.out.println("info.name() = " + info.tagline());
        System.out.println("info.version() = " + info.version().number());
        System.out.println("info.clusterName() = " + info.clusterName());
    }
}
