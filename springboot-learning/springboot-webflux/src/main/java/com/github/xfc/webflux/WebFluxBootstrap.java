package com.github.xfc.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : chenxingfei
 * @date: 2019-07-14  19:39
 * @description: 启动类
 */
@SpringBootApplication
public class WebFluxBootstrap {


    public static void main(String[] args) {

//        System.out.println(Thread.currentThread().getName());
//
//        Flux<String> flux = Flux.generate( () -> 0,
//                (value, sink) -> {
//                    sink.next("value : " + value);
//                    if (value == 10) sink.complete();
//                    return value + 1;
//                });
//
//        flux.subscribe(value-> System.out.println(Thread.currentThread().getName() +"  " + value));
//
//        Flux.range(0, 10).handle((item, sink) -> {
//            if (item % 2 == 0) {
//                sink.next("Even : " + item);
//            }
//        }).subscribe(value-> System.out.println(value));

        SpringApplication.run(WebFluxBootstrap.class);

    }


}
