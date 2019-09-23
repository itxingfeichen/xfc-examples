package com.github.xfc.stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author : chenxingfei
 * @date: 2019/9/23  18:50
 * @description: filter test
 */
@DisplayName("filter test")
public class FilterTest {


    @DisplayName("fiterSex")
    @Test
    void fiterSex() {
        List<PersonModel> data = Data.getData();

        //old
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel person : data) {
            if ("男".equals(person.getSex())) {
                temp.add(person);
            }
        }
        System.out.println(temp);
        //new
        List<PersonModel> collect = data
                .stream()
                .filter(person -> "男".equals(person.getSex()))
                .collect(toList());
        System.out.println(collect);
    }

    /**
     * 过滤所有的男性 并且小于20岁
     */
    @DisplayName("fiterSexAndAge")
    @Test
    void fiterSexAndAge() {
        List<PersonModel> data = Data.getData();

        //old
        List<PersonModel> temp = new ArrayList<>();
        for (PersonModel person : data) {
            if ("男".equals(person.getSex()) && person.getAge() < 20) {
                temp.add(person);
            }
        }

        //new 1
        data.stream()
                .filter(person -> {
                    if ("男".equals(person.getSex()) && person.getAge() < 20) {
                        return true;
                    }
                    return false;
                })
                .collect(toList()).forEach(System.out::println);
        //new 2
        data.stream()
                .filter(person -> ("男".equals(person.getSex()) && person.getAge() < 20))
                .collect(toList()).forEach(System.out::println);

    }
}
