//package com.lq.rank;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
//import org.elasticsearch.action.delete.DeleteRequest;
//import org.elasticsearch.action.delete.DeleteResponse;
//import org.elasticsearch.action.get.GetRequest;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.search.SearchRequest;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.action.support.master.AcknowledgedResponse;
//import org.elasticsearch.action.update.UpdateRequest;
//import org.elasticsearch.action.update.UpdateResponse;
//import org.elasticsearch.client.RequestOptions;
//import org.elasticsearch.client.RestHighLevelClient;
//import org.elasticsearch.client.core.MainResponse;
//import org.elasticsearch.client.indices.CreateIndexRequest;
//import org.elasticsearch.client.indices.GetIndexRequest;
//import org.elasticsearch.common.xcontent.XContentType;
//import org.elasticsearch.index.query.MatchQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHit;
//import org.elasticsearch.search.builder.SearchSourceBuilder;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.core.IndexOperations;
//
//import java.io.IOException;
//import java.util.Date;
//import java.util.List;
//
//@SpringBootTest
//class LqEsApiApplicationTests {
//
//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchRestTemplate;
//    @Autowired
//    @Qualifier("getEsClient")
//    RestHighLevelClient restHighLevelClient;
//    ObjectMapper mapper = new ObjectMapper();
//
//
//    @Test
//    void testClient() throws IOException {
//        MainResponse info = restHighLevelClient.info(RequestOptions.DEFAULT);
//        System.out.println("getClusterName = " + info.getClusterName());
//        System.out.println("getVersion = " + info.getVersion().getNumber());
//        System.out.println("getNodeName = " + info.getNodeName());
//
//    }
////    @Test
////    void contextLoads() {
//////		IndexCoordinates user = IndexCoordinates.of("");
//////		 elasticsearchRestTemplate.indexOps(user).create();
////        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(Car.class);
////        indexOperations.create();
////    }
//
////    @Test
////    void putDocument() throws IOException {
////        List books = HtmlParseUtil.getBooks();
////        books.forEach(b -> {
////            elasticsearchRestTemplate.save(b);
////        });
////
////
////    }
//    /**---------------------------------------es高级API---------------------------------------**/
//
//    /**
//     * 创建索引
//     *
//     * @throws IOException
//     */
//    @Test
//    void creatIndex() throws IOException {
//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("car");
//        restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//
//    }
//
//    /**
//     * 索引是否存在
//     *
//     * @throws IOException
//     */
//    @Test
//    void existIndex() throws IOException {
//        GetIndexRequest request = new GetIndexRequest("car");
//        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
//        System.out.println(exists);
//
//    }
//
//    /**
//     * 删除索引
//     *
//     * @throws IOException
//     */
//    @Test
//    void deleteIndex() throws IOException {
//        DeleteIndexRequest request = new DeleteIndexRequest("car");
//        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
//        System.out.println(delete.isAcknowledged());
//
//    }
//
//    /**
//     * 添加文档数据
//     */
//    @Test
//    void addDocument() throws IOException {
////        User user = User.builder().name("孙文静").age("25").birthday(new Date()).build();
////        IndexRequest indexRequest = new IndexRequest("user");
////        indexRequest.id("1");
//////        indexRequest.timeout("1s");
////        ObjectMapper mapper = new ObjectMapper();
////        indexRequest.source(mapper.writeValueAsString(user), XContentType.JSON);
////        restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
//    }
//
//    /**
//     * 判断文档是否存在
//     */
//    @Test
//    void existsDocument() throws IOException {
//        GetRequest getRequest = new GetRequest("user", "1");
//        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
//        System.out.println(exists);
//    }
//
//    /**
//     * 获取文档数据
//     */
//    @Test
//    void getDocument() throws IOException {
//        GetRequest getRequest = new GetRequest("user", "1");
//        GetResponse response = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
//        System.out.println(response.getSourceAsString());
//
//    }
//
//    /**
//     * 更新文档数据
//     */
////    @Test
////    void updateDocument() throws IOException {
////        UpdateRequest updateRequest = new UpdateRequest("user", "1");
////        User user = User.builder().name("兜兜").build();
////        updateRequest.doc(mapper.writeValueAsString(user), XContentType.JSON);
////        UpdateResponse response = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
////        System.out.println(response.status());
////
////    }
//
//    /**
//     * 删除文档数据
//     */
//    @Test
//    void deleteDocument() throws IOException {
//        DeleteRequest deleteRequest = new DeleteRequest("user", "1");
//        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
//        System.out.println(delete.status());
//
//    }
//
//    @Test
//    void searchDocument() throws IOException {
//        SearchRequest searchRequest = new SearchRequest("user");
//
//        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
//        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery("name", "兜");
//        searchSourceBuilder.query(matchQueryBuilder);
//        searchRequest.source(searchSourceBuilder);
//        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        System.out.println(mapper.writeValueAsString(response.getHits()));
//
//        SearchHit[] hits = response.getHits().getHits();
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }
//    }
//}
