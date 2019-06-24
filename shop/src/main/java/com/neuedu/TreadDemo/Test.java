package com.neuedu.TreadDemo;

import java.util.*;

public class Test {

    public Integer getA(){
        return 0;
    }

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap();
        map.put("123", 1);
        map.put("456", 2);
        map.put("789", 3);
        System.out.println();
    }
}
class Test2 extends Test{

    public void get(Integer id){

    }
    public Integer get(){
        return 0;
    }

    @Override
    public Integer getA(){
        return 1;
    }
}
