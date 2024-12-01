//package com.lq.rank.repository;
//
//import com.lq.rank.entity.Car;
//import org.springframework.data.elasticsearch.annotations.Query;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
///**
// * @author LQ
// * @date 2021/04/11 23:26
// */
//@Repository
//public interface CarRepository extends ElasticsearchRepository<Car, String> {
//    Car findByNameAndPrice(String name, Double price);
//
//    @Query("\"bool\": {\n" +
//            "      \"must\": [\n" +
//            "        {\n" +
//            "          \"match\": {\n" +
//            "            \"name\": \"?0\"\n" +
//            "          }\n" +
//            "        }\n" +
//            "      ]\n" +
//            "    }")
//    List<Car> searchByName(String name);
//    List<Car> findAllByOrderByPriceDesc();
//}
