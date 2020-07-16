package com.example.project1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

public static void main (String[] args) {
        System.out.println("    x    ");
        System.out.println("   x  x  ");
        System.out.println("  x    x  ");
        System.out.println(" x      x ");
        System.out.println("xxxx  xxxx");
        System.out.println("   x  x   ");
        System.out.println("   x  x   ");
        System.out.println("   x  x   ");
        System.out.println("xxxx  xxxx");
        System.out.println(" x      x ");
        System.out.println("  x    x  ");
        System.out.println("   x  x  ");
        System.out.println("    x    ");



        System.out.println(2 > 7);
        int num = 7 / 7;
        Point a = new Point(1, 2);
        System.out.println(a.getX());
        System.out.println(a);
        System.out.println(a.distanceFromOrigin());
        System.out.println(a.getQuadrant());
        Point point1 = new Point(1, 1);
        Point point2 = new Point(3, 3);
        LineSegment ls = new LineSegment(point1, point2);
        System.out.println(ls.subDivide(3));
        ArrayList<String> myList = new ArrayList<>();

        myList.add("goodbye");
        myList.add("so");
        myList.add("hello");
        System.out.println(myList);
        Collections.reverse(myList);
        System.out.println(myList);
        System.out.println(findstring(myList, "hello"));



}


        public static boolean findstring(ArrayList<String> stringsToSearch, String toFind) {

                boolean yarn = false;
                for (int i = 0; i == stringsToSearch.size(); i++) {
                        if(stringsToSearch.get(i).equals(toFind)) {
                                yarn = true;
                        }else{
                                yarn = false;
                        }


                }
                return yarn;

        }

}