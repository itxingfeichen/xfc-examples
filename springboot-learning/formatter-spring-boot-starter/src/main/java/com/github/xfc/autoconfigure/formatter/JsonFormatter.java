package com.github.xfc.autoconfigure.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author : chenxingfei
 * @date: 2019-08-09  07:55
 * @description: json formtter
 */
public class JsonFormatter implements Formatter {

    private final ObjectMapper objectMapper;


    public JsonFormatter() {
        this.objectMapper = new ObjectMapper();
    }

    public JsonFormatter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * format object to change json data
     *
     * @param object
     * @return
     */
    @Override
    public String format(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("this argument is illegal " + object);
        }
    }
}
