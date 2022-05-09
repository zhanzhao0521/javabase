package com.estrus.juc.lock;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadDemo4 {
    public static void main(String[] args) {
        // list
        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new CopyOnWriteArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                list.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(list);
//            },String.valueOf(i)).start();
//        }

        //set
//       Set<String> set = new CopyOnWriteArraySet<>();
//        //Set<String> set = new HashSet<>();
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                set.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(set);
//            },String.valueOf(i)).start();
//        }

        //map
       //Map<String,String> map = new HashMap<>();
       Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
