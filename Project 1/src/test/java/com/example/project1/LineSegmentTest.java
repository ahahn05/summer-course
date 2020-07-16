package com.example.project1;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineSegmentTest {

    @Test
    public void subDivide() {
        Point[] pointsExpected = new Point[2];
        pointsExpected[0]=new Point(1,1); pointsExpected[1]= new Point(2,2);
        Point[] pointsActual = new LineSegment(new Point(0,0),new Point(3,3)).subDivide(3);
        assertEquals(pointsExpected.length,pointsActual.length);
        for (int i = 0; i <pointsActual.length ; i++) {

            assertEquals(pointsExpected[i].getX(),pointsActual[i].getX(),0.000001);
            assertEquals(pointsExpected[i].getY(),pointsActual[i].getY(),0.000001);

        }


    }
    @Test
    public void interpolate(){
        Point expectedPoint = new Point(4,5);
        Point origin = new Point(1,1);
        LineSegment ls = new LineSegment(origin,expectedPoint);
        Point actualPoint = ls.interpolate(5);
        assertEquals(expectedPoint,actualPoint);
    }
}