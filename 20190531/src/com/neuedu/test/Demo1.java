package com.neuedu.test;

public class Demo1 {
    public static void main(String[] args) {

        int l = L(10, 50);
        System.out.println("l = " + l);

    }

    public static int L(int a,int b){
        int s = 0;
        try {
            System.out.println("try");
            s = a + b + 3;
            throw new Exception();
        }catch (Exception e){
            System.out.println("catch");
            s = a + b + 1;
            return s;
        }finally {
            s = a + b;
            System.out.println("finally");
        }
    }

}
