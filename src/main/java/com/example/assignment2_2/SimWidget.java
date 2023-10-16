package com.example.assignment2_2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SimWidget extends BaseWidget {
    double minWidth;
    double maxWidth;
    double prefHeight;


    private VerticalPosition verticalPosition;

    public SimWidget(double minWidth, double maxWidth, double prefHeight, BaseWidget.VerticalPosition verticalPosition) {
        this(minWidth, maxWidth, prefHeight, VerticalPosition.TOP);
        VerticalPosition vp = VerticalPosition.TOP;
        switch (verticalPosition) {
            case TOP -> vp = VerticalPosition.TOP;
            case FILL -> vp = VerticalPosition.FILL;
            case MIDDLE -> vp = VerticalPosition.MIDDLE;
        }
        this.verticalPosition = vp;
    }

    public SimWidget(double minWidth, double maxWidth, double prefHeight, VerticalPosition verticalPosition) {
        super();
        this.minWidth = minWidth;
        this.maxWidth = maxWidth;
        this.prefHeight = prefHeight;
        this.rectangle.setFill(Color.YELLOW);
        this.rectangle.setStroke(Color.BLACK);

        this.verticalPosition = verticalPosition;
    }

    public enum VerticalPosition {
        TOP, MIDDLE, FILL
    }

    @Override
    public double calculateVIS() {
        return minWidth;
    }

    @Override
    public double getMaxWidth() {
        return maxWidth;
    }

    @Override
    public double getPrefHeight() {
        return prefHeight;
    }

    /**
     * 计算垂直布局
     *
     * @param parcelTop    上边坐标
     * @param parcelBottom 下边坐标
     */
    @Override
    public void doVerticalLayout(double parcelTop, double parcelBottom) {
        this.myTop = parcelTop;
        double availableHeight = parcelBottom - parcelTop;
        myHeight = Math.min(prefHeight, availableHeight);
        if (this.verticalPosition == VerticalPosition.MIDDLE) {
            myTop += (availableHeight - myHeight) / 2;

        } else if (this.verticalPosition == VerticalPosition.FILL) {
            this.myHeight = parcelBottom - parcelTop;
        }
    }
}

