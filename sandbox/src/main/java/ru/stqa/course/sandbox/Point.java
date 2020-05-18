package ru.stqa.course.sandbox;

public class Point {

    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(double х, double у) {
        double dx = this.x - х;
        double dy = this.y - у;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double distance(Point p) {
        return distance(p.x, p.y);
    }
}



