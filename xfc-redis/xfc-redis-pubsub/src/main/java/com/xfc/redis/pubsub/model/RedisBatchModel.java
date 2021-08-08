package com.xfc.redis.pubsub.model;

import lombok.Data;

/**
 * redis批量写入测试
 *
 * @author xf.chen
 * @date 2021/8/8 16:37
 * @since 1.0.0
 */
@Data
public class RedisBatchModel {

    /**
     * id
     */
     private Long id;

     /**
      * age
      */
      private Integer age;

      /**
       * username
       */
       private String username;



}
