package com.example.assignment2_2;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

public abstract class BaseWidget {
    private ArrayList<BaseWidget> children = new ArrayList<>();
    double myLeft;
    double myTop;
    double myWidth;
    double myHeight;
    Rectangle rectangle;

    public enum VerticalPosition {
        TOP, MIDDLE, FILL
    }

    public BaseWidget() {
        this.rectangle = new Rectangle();
    }

    public void addChild(BaseWidget Children) {
        this.children.add(Children);
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public ArrayList<BaseWidget> getChildren() {
        return this.children;
    }

    public abstract double calculateVIS();

    public abstract double getMaxWidth();

    public abstract double getPrefHeight();

    public void doHorizontalLayout(double parcelLeft, double parcelRight) {
        this.myLeft = parcelLeft;
        this.myWidth = parcelRight - parcelLeft;
    }

    public void doVerticalLayout(double parcelTop, double parcelBottom) {
        this.myTop = parcelTop;
        myHeight = parcelBottom - parcelTop;
    }

    /**
     * 递归获取所有子节点
     */
    public ArrayList<Node> getAllSubs() {
        ArrayList<Node> res = new ArrayList<>();
        res.add(rectangle);
        if (hasChildren()) {
            for (BaseWidget child : getChildren()) {
                res.addAll(child.getAllSubs());
            }
        }
        return res;
    }

    public void Size(double width, double height) {
        this.myWidth = width;
        this.myHeight = height;
    }

    public void show() {
        this.rectangle.setX(myLeft);
        this.rectangle.setY(myTop);
        this.rectangle.setWidth(myWidth);
        this.rectangle.setHeight(myHeight);
    }

    public Rectangle getRectangle() {
        return this.rectangle;
    }
}
