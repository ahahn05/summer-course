package com.example.project1;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceFromOrigin() {
        assertEquals(5, new Point(3,4).distanceFromOrigin(), .000001);

    }
    @Test
    public void getQuadrant() {
        assertEquals("Quadrant 1", new Point(2,3).getQuadrant());
    }
    @Test
    public void distanceToPoint() {
        Point tree = new Point (5,4);
        assertEquals(5, new Point(1,1).distanceToPoint((new Point (5,4))),.0000001);
    }
    @Test
    public void closestPoint(){
        Point[] pints = {new Point (3,3), new Point(5,5),new Point(9,4),new Point(.5,.5)};
        Point orig = new Point(1,1);
        assertEquals(pints[3], orig.closestPoint(pints));

    }
    @Test
    public void distanceBetweenTwoPoints(){
        Point a = new Point(5,5);
        Point b = new Point(9,8);
        assertEquals(5,Point.distanceBetweenTwoPoints(a,b), .00000001);
    }
    @Test
    public void midPoint(){
        Point c = new Point (1,1);
        Point d = new Point (3,3);
        assertEquals(2,Point.midPoint(c,d).getX(),.000001);
    }

}