package com.lq.rank.api;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * 创建索引
 *
 * @author LQ
 * @date 2021/04/11 17:19
 */
public class EsClientIndexCreate {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient =
                new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.186.129", 9200, "http")));
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("car");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        boolean acknowledged = createIndexResponse.isAcknowledged();
        if (acknowledged) {
            System.out.println("创建成功");
        }
        restHighLevelClient.close();
    }
}
