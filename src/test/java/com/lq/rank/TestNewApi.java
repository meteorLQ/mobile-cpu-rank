package com.lq.rank;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.InfoResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.indices.DeleteIndexResponse;
import co.elastic.clients.elasticsearch.indices.GetIndexResponse;
import com.lq.rank.entity.Processor;
import com.lq.rank.util.HtmlParseUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    //查询Index
    @Test
    public void indices() throws Exception {
        GetIndexResponse cpu = elasticsearchClient.indices().get(i -> i.index("cpu"));
        System.out.println();

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
            elasticsearchClient.create(i->i.index("cpu").id(finalJ +"").document(snapdragonCPUInfo.get(finalJ)));
        }

    }

    @Test
    public void search() throws Exception {
        SearchResponse<Processor> cpu = elasticsearchClient.search(s -> s.index("cpu").from(0).size(20), Processor.class);
        List<Hit<Processor>> hits = cpu.hits().hits();
        hits.forEach(h-> System.out.println("h.source() = " + h.source()));
    }


}
