package com.lq.rank.api;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.cat.HealthResponse;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClient;

import java.io.IOException;

/**
 * @author LQ
 * @date 2021/04/11 17:19
 */
public class EsClient {

    public static void main(String[] args) throws IOException {
//        RestHighLevelClient restHighLevelClient =
//                new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.186.129", 9200, "http")));
//        restHighLevelClient.close();
        String serverUrl = "https://149.130.215.7:9200";
        String apiKey = "Vm43bGZaTUJpMmRvUVNiX0tpY3E6WGxtS0sxcHhRajJLQU4wdTFwRm5tdw==";

// Create the low-level client
        RestClient restClient = RestClient
                .builder(HttpHost.create(serverUrl))
                .setDefaultHeaders(new Header[]{
                        new BasicHeader("Authorization", "ApiKey " + apiKey)
                })
                .setHttpClientConfigCallback(httpClientBuilder -> {
                    SSLContextBuilder sscb = SSLContexts.custom();
                    try {
                        sscb.loadTrustMaterial((chain, authType) -> {
                            // 在这里跳过证书信息校验
                            return true;
                        });
                        httpClientBuilder.setSSLContext(sscb.build());

                    } catch (Exception ignored) {
                    }
                    // 这里跳过主机名称校验
                    httpClientBuilder.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE);
                    return httpClientBuilder;
                })
                .build();

// Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

// And create the API client
        ElasticsearchClient esClient = new ElasticsearchClient(transport);
        esClient.indices().create(c -> c
                .index("products")
        );
        HealthResponse health = esClient.cat().health();
        System.out.println(health);
// Close the client, also closing the underlying transport object and network connections.
        esClient.close();

    }
}
