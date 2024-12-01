//package com.lq.rank;
//
//import com.lq.rank.entity.Car;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//
//import java.util.List;
//
///**
// * @author LQ
// * @date 2021/04/11 23:45
// */
//@SpringBootTest
//public class CarRepositoryTest {
//    @Autowired
//    private ElasticsearchRestTemplate elasticsearchRestTemplate;
//    @Autowired
//    CarRepository carRepository;
//
//    @Test
//    public void create() {
//        System.out.println("索引创建成功");
//    }
//
//    @Test
//    public void save() {
//        Car car = new Car();
//        car.setId(5L);
//        car.setName("小米");
//        car.setPrice(885600D);
//        Car save = carRepository.save(car);
//        System.out.println(save);
//    }
//
//    @Test
//    public void findById() {
//        Car car = carRepository.findById("1").get();
//        System.out.println(car);
//    }
//
//    @Test
//    public void findAll() {
//        Iterable<Car> all = carRepository.findAll();
//        all.forEach(System.out::println);
//
//    }
//
//    @Test
//    public void search() {
////        Car car = carRepository.findByNameAndPrice("小鹏", 368500D);
////        System.out.println(car);
//        List<Car> cars = carRepository.findAllByOrderByPriceDesc();
//        System.out.println(cars);
//    }
//}
