package com.example.demo.service.impl;

import com.example.demo.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {


       // List<String> children= (List<String>) jsonObject.get("children");
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<4;i++){
            list.add(i);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        System.out.println(" ");
        list=new ArrayList<>();
        for(int i=5;i<8;i++){
            list.add(i);
        }
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        /*String id="123454321";
        String  Id=id.substring(4,6);
        System.out.println(Id);*/
        /*int i=0;
        Scanner in=new Scanner(System.in);
        i=in.nextInt();

        switch (i){
            case 1:
                i++;
                System.out.println(i);
            case 2:
                i++;
                System.out.println(i);
                break;
                default:
                    System.out.println(111);
        }*/
        /*Person person=new Person();
        if(person.getId()==null||person.getId()!=1){
            System.out.println(1);
        }*/
    }
}
