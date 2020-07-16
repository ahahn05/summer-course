package com.example.project1;

public class LineSegment {
    private Point point1;
    private Point point2;
    private double length;

    public LineSegment(Point point1, Point point2){
        this.point1=point1;
        this.point2=point2;
        this.length = Point.distanceBetweenTwoPoints(point1,point2);

    }
    public Point[] subDivide(int subsegments){
        Point[] points = new Point[subsegments-1];
        double deltx= point2.getX() - point1.getX();
        double delty= point2.getY() - point1.getY();

        for (int i=1; i<subsegments;i++){
            double subsegmentx = (deltx/subsegments)*i+point1.getX();
            double subsegmenty = (delty/subsegments)*i+point1.getY();
            Point newPoint= new Point (subsegmentx,subsegmenty);
            points[i-1] = newPoint;

        }
        return points;
    }
    public Point interpolate(double distanceFromFirstpoint){
        double changeX = this.point2.getX()-this.point1.getX();
        double changeY = this.point2.getY()-this.point1.getY();
        double xValue = this.point1.getX()+(distanceFromFirstpoint/this.length)*changeX;
        double yValue = this.point1.getY()+(distanceFromFirstpoint/this.length)*changeY;
        Point polate = new Point(xValue,yValue);
        return polate;



    }
}
