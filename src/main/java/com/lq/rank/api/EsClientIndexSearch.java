package com.lq.rank.api;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * 创建索引
 *
 * @author LQ
 * @date 2021/04/11 17:19
 */
public class EsClientIndexSearch {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient =
                new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.186.129", 9200, "http")));
        GetIndexRequest getIndexRequest = new GetIndexRequest("car");
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);

        System.out.println(getIndexResponse.getAliases());
        System.out.println(getIndexResponse.getSettings());
        System.out.println(getIndexResponse.getMappings());
        restHighLevelClient.close();
    }
}
