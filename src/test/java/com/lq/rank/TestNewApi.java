package com.lq.rank;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.InfoResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.*;
import co.elastic.clients.util.ObjectBuilder;
import com.lq.rank.entity.Processor;
import com.lq.rank.util.HtmlParseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

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

    @Test
    public void create() throws IOException {
        ElasticsearchIndicesClient indices = elasticsearchClient.indices();
        CreateIndexRequest createIndexRequest = CreateIndexRequest.of(builder -> builder.index("rank-ladder"));
        indices.create(createIndexRequest);
        elasticsearchClient.close();
    }
    @Test
    public void get() throws IOException {
        ElasticsearchIndicesClient indices = elasticsearchClient.indices();
        GetIndexResponse getIndexResponse = indices.get(req->req.index("rank-ladder"));
        IndexState indexState = getIndexResponse.get("rank-ladder");
        System.out.println(indexState);
        elasticsearchClient.close();
    }

    //查询Index
    @Test
    public void indices() throws Exception {
        GetIndexResponse cpu = elasticsearchClient.indices().get(i -> i.index("cpu"));
        System.out.println("cpu = " + cpu);
    }

    @Test
    public void deleteIndices() throws Exception {
        DeleteIndexResponse cpu = elasticsearchClient.indices().delete(i -> i.index("cpu"));
        System.out.println("cpu = " + cpu.acknowledged());

    }

    @Test
    public void addDocument() throws Exception {
        List snapdragonCPUInfo = HtmlParseUtil.getSnapdragonCPUInfo();
        for (int j = 0; j < snapdragonCPUInfo.size(); j++) {
            int finalJ = j;
            elasticsearchClient.create(i->i.index("rank-ladder").id(finalJ +"").document(snapdragonCPUInfo.get(finalJ)));
        }

    }

    @Test
    public void search() throws Exception {
        SearchResponse<Processor> cpu = elasticsearchClient.search(s -> s.index("cpu").from(0).size(20), Processor.class);
        List<Hit<Processor>> hits = cpu.hits().hits();
        hits.forEach(h-> System.out.println("h.source() = " + h.source()));
    }



}
