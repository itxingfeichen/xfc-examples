package com.github.xfc.lock;

/**
 * @author : chenxingfei
 * @date: 2019-09-24  22:43
 * @description:
 */
public class LockTest {

    public void test1(){

        synchronized (this){
            System.out.println("true = " + true);
        }
    }
    public synchronized void test2(){

            System.out.println("true = " + true);
    }

    public static void main(String[] args) throws Exception {

//        System.out.println(3 + (3 >> 1));
//        ClassB classB = new ClassB();

        split("我ABC",3);

    }


    public static class ClassA{
        private ClassA(){
            System.out.println("ClassA init....");
        }

        private void method(){
            System.out.println("method();");
        }
    }

    public static class ClassB extends ClassA{

        public ClassB(){
//            super();
        }
    }

    public static void split(String source,int num) throws Exception
    {
        int k=0;
        String temp="";
        for (int i = 0; i <source.length(); i++) {
            byte[] b=(source.charAt(i)+"").getBytes(); k=k+b.length;
            if(k>num)
            {
                break; }
            temp=temp+source.charAt(i); }
        System.out.println(temp); }

}
