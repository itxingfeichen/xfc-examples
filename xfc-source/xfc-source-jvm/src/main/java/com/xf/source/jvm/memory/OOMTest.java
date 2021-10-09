package com.xf.source.jvm.memory;

import com.xf.source.jvm.common.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest {

   public static List<Object> list = new ArrayList<>();

   // JVM设置/Users/xingfei/IdeaProjects/xfc-examples/xfc-source/xfc-source-jvm
   // -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/xingfei/IdeaProjects/xfc-examples/xfc-source/xfc-source-jvm/jvm.dump
   public static void main(String[] args) {
      List<Object> list = new ArrayList<>();
      int i = 0;
      int j = 0;
      while (true) {
         list.add(new User(i++, UUID.randomUUID().toString()));
         new User(j--, UUID.randomUUID().toString());
      }
   }
}