package com.lq.rank.api;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author LQ
 * @date 2021/04/11 17:19
 */
public class EsClient {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient =
                new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.186.129", 9200, "http")));
        restHighLevelClient.close();
    }
}
