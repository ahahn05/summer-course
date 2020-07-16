package com.example.project1;

import com.example.project1.Point;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void testDuplicatesRemoved() {

        // Make some points
        Point[] points;
        points = new Point[]{new Point(0, 0), new Point(3, 4), new Point(3, 4), new Point(5, 5)};
        Path path = new Path(points);
        Point[] pointsExpected = new Point[]{new Point(0, 0), new Point(3, 4), new Point(5, 5)};

        // Check to make sure that you got rid of the duplicates
        Assert.assertEquals(pointsExpected[0], path.getWayPoints().get(0).point);
        Assert.assertEquals(pointsExpected[1], path.getWayPoints().get(1).point);
        Assert.assertEquals(pointsExpected[2], path.getWayPoints().get(2).point);

    }

    @Test
    public void totalDistance2() {
        Point[] points = new Point[]{new Point(0, 0), new Point(3, 4), new Point(6, 8),new Point(6,8)};
        Path path = new Path(points);
        Assert.assertEquals(10, path.totalDistance(), .00001);
    }

    @Test
    public void targetPointTest() {
        Point[] points = new Point[]{new Point(0, 0), new Point(3, 4), new Point(6, 8)};
        Path path = new Path(points);
        Point origpoint = new Point(0, 0);
        assertEquals(new Point(6, 8), path.targetPoint(origpoint, 10).point);
    }

    @Test
    public void distFromBeginning() {
        Point[] points = new Point[]{new Point(0, 0), new Point(3, 4)};
        Path path = new Path(points);
        assertEquals(5, path.getWayPoints().get(1).distanceFromBeginning, .00001);

    }

    @Test
    public void rejectsInvalidPath() {
        try{
            Point[] points = new Point[]{new Point(0, 0)};
            Path path = new Path(points);
            fail("expected illegal argument exception");
        }catch(IllegalArgumentException e){
            //what we expected
        }
        try{
            Point[] points = new Point[]{new Point(0, 0),new Point(0,0)};
            Path path = new Path(points);
            fail("expected illegal argument exception");
        }catch(IllegalArgumentException e){
            //what we expected
        }

    }
}


