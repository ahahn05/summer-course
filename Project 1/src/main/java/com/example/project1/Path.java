package com.example.project1;

import java.util.ArrayList;
import java.util.List;

public class Path {
    /**
     * @param rawPoints Array of X,Y points.  Duplicate points are discarded
     *                  A path must have at least 2 non-identical points
     */
    private List<WayPoint> wayPoints;
    private double pathDistance;


    public Path(Point[] rawPoints){
        if(rawPoints.length<2){
            throw new IllegalArgumentException("Path must have at least two points");
        }
        wayPoints = new ArrayList<>();
        pathDistance=0;
        wayPoints.add(new WayPoint(rawPoints[0],0,0,0,0));
        for (int i = 1; i < rawPoints.length; i++) {
            double deltx = rawPoints[i].getX()-rawPoints[i-1].getX();
            double delty = rawPoints[i].getY()-rawPoints[i-1].getY();
            double dist = rawPoints[i].distanceToPoint(rawPoints[i-1]);
            pathDistance += dist;
            if(dist>0) {
                wayPoints.add(new WayPoint(rawPoints[i], deltx, delty, dist, pathDistance));
            }
        }
        if(wayPoints.size()<2){
            throw new IllegalArgumentException("Path must have at least two unique points");
        }
    }

    public List<WayPoint> getWayPoints() {
        return wayPoints;
    }

    /**
     * @return total distance of the path
     */
    public double totalDistance() {

        double total= 0;
        for (int i = 0; i <wayPoints.size() ; i++) {
            total+= wayPoints.get(i).distanceFromPrevious;

        }
        return total;

    }
    /**
     * @return a point at the supplied distance along the path from the supplied current position
     * Note that the point will usually be interpolated between the points that originally defined the com.example.project1.Path
     */
    public Path.WayPoint targetPoint(Point current, double distance) {
        int i = 1;
        while(componentAlongPath(current,wayPoints.get(i))<=0){
            i++;
        }
        double remainingDistance =distance - componentAlongPath(current,wayPoints.get(i));
        while(remainingDistance>0){
            i++;
            remainingDistance-=wayPoints.get(i).distanceFromPrevious;
        }
        remainingDistance += wayPoints.get(i).distanceFromPrevious;
        LineSegment lis = new LineSegment(wayPoints.get(i-1).point,wayPoints.get(i).point);
        Point a = wayPoints.get(i-1).point;
        Point b = wayPoints.get(i).point;
        Point target = lis.interpolate(remainingDistance);
        return new WayPoint(target,target.getX()-a.getX(),target.getY()-b.getY(),remainingDistance,0);
    }

    public static class WayPoint {
        public Point point;
        public double deltaXFromPrevious;
        public double deltaYFromPrevious;
        public double distanceFromPrevious;
        public double distanceFromBeginning;

        public WayPoint(Point point, double deltaXFromPrevious, double deltaYFromPrevious, double distanceFromPrevious, double distanceFromBeginning) {
            this.point = point;
            this.deltaXFromPrevious = deltaXFromPrevious;
            this.deltaYFromPrevious = deltaYFromPrevious;
            this.distanceFromPrevious = distanceFromPrevious;
            this.distanceFromBeginning = distanceFromBeginning;

        }
    }
    /**
     * Calculates the projection in the direction of the path from the current point to the
     * supplied WayPoint
     * @param current The source point
     * @param wayPoint A point on the path
     * @return The dot product between vectors normalized by the length of the path segment leading to wayPoint
     */
    private double componentAlongPath(Point current, WayPoint wayPoint) {
        double deltaXToWayPoint = wayPoint.point.getX() - current.getX();
        double deltaYToWayPoint = wayPoint.point.getY() - current.getY();

        double dp = deltaXToWayPoint * wayPoint.deltaXFromPrevious + deltaYToWayPoint * wayPoint.deltaYFromPrevious;
        return dp / wayPoint.distanceFromPrevious;
    }


}
