package com.lq.rank.api;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
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
public class EsClientIndexDelete {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient restHighLevelClient =
                new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.186.129", 9200, "http")));
        DeleteIndexRequest request = new DeleteIndexRequest("car");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        if (delete.isAcknowledged()) {
            System.out.println("索引删除成功");
        }
        restHighLevelClient.close();
    }
}
