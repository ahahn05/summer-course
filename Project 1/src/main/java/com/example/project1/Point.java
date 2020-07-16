package com.example.project1;

import java.util.Objects;

public class Point {
    private double x;
    private double y;

    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public double distanceFromOrigin(){
        return Math.pow(x*x+y*y,.5);
    }
    public String getQuadrant(){
        if (x > 0 && y > 0){
            return "Quadrant 1";

    } else if (x<0 && y>0){
            return "Quadrant 2";
        } else if (x<0 && y<0){
            return "Quadrant 3";
        } else if (x>0 && y<0){
            return "Quadrant 4";
        } else if (x==0 || y==0){
            return "Axes";
        } else{
            return null;
        }

        }

    public double getY(){
        return y;
    }

    public double getX() {
        return x;
    }

    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double distanceToPoint( Point other){
        this.getX();
        this.getY();
        double yDist = this.getY()-other.getY();
        double xDist = this.getX() - other.getX();
        double distance = Math.sqrt(xDist*xDist+yDist*yDist);
        return distance;
    }
    public Point closestPoint(Point[] points){
        Point closest = points[0];
        for (int i = 1; i < points.length; i++) {
            if(this.distanceToPoint(points[i])<this.distanceToPoint(closest)){
                closest = points[i];
            }

        }
        return closest;
    }
    public static double distanceBetweenTwoPoints(Point a, Point b){
        double dist = a.distanceToPoint(b);
        return dist;
    }
    public static Point midPoint(Point a, Point b){

        return new Point((a.x+b.x)/2,(a.y+b.y)/2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
