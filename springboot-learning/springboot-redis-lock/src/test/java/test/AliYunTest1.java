package test;

/**
 * @author : chenxingfei
 * @date: 2019-07-20  17:30
 * @description:
 */
public class AliYunTest1 {

    static int i;

    public static void main(String args[]) {
        System.out.println(i);
//
//        int num = 64;
//        char a = (char)num;


//        System.out.println((int)'A');

//        System.out.println(10%2 == 1 && 10/3 == 0);
//
//        System.out.println(0%3);
//
//        int a = 2147483647;
//
//        Long num = a+2L;
//        System.out.println(num);
//
//        System.out.println(num++*2);
//        System.out.println(a);

//        int a = 20;
//        double b = 20.2;
//        long z = 10L;
//        System.out.println(""+a+b+z);
//        String a = "";
//        for (int i = 0; i < 5; i++) {
//            a+=i;
//        }
//
//        System.out.println(a);

        test2();

    }

    private static void test1() {
        int i = 1;
        int j = i++;
        if((i==(++j))&&((i++)==j))     {
            i+=j;
        }

        System.out.println("i = " + i);
    }

    private static void test2(){


        int i = 9;

        switch (i){

            default:
                System.out.println("default");
            case 0:
                System.out.println("0");break;
            case 1:
                System.out.println("case1");
            case 2:
                System.out.println("case2");
        }
    }


}
