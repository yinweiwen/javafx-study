package com.example.assignment2_2;

import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.ArrayList;

import static java.lang.Math.min;

public class LinearLayout extends BaseWidget {
    static int index=-1;
    double intrinsicSize;

    public LinearLayout() {
        super();
        switch (index){
            case 0:
                this.rectangle.setFill(Color.rgb(172, 223, 229));
                break;
            case 1:
                this.rectangle.setFill(Color.rgb(196, 91, 62));
                break;
            case 2:
                this.rectangle.setFill(Color.rgb(105, 204, 38));
                break;
        }
        this.rectangle.setStroke(Color.BLUE);
        index++;
    }

    public void doLayout(double width, double height) {
        doHorizontalLayout(0, width);
        doVerticalLayout(0, height);
        show();
    }

    @Override
    public void doHorizontalLayout(double parcelLeft, double parcelRight) {
        this.myLeft = parcelLeft;
        this.myWidth = parcelRight - parcelLeft;
        if (hasChildren()) {

            // Compute
            calculateVIS();
            double diff = myWidth - intrinsicSize;
            double partWidth = diff / getChildren().size();

            for (BaseWidget child : getChildren()) {
                double width = min(child.calculateVIS() + partWidth, child.getMaxWidth());
                parcelRight = parcelLeft + width;
                child.doHorizontalLayout(parcelLeft, parcelRight);

                parcelLeft = parcelRight;
            }
        }
    }

    @Override
    public void doVerticalLayout(double parcelTop, double parcelBottom) {
        this.myTop = parcelTop;
        myHeight = parcelBottom - parcelTop;
        if (hasChildren()) {
            for (BaseWidget child : getChildren()) {
                child.doVerticalLayout(parcelTop, parcelBottom);
            }
        }
    }

    public double calculateVIS() {
        intrinsicSize = 0;
        for (BaseWidget Children : getChildren()) {
            intrinsicSize = intrinsicSize + Children.calculateVIS();
        }
        return intrinsicSize;
    }

    @Override
    public double getMaxWidth() {
        double mw = 0;
        for (BaseWidget child : getChildren()) {
            mw += child.getMaxWidth();
        }
        return mw;
    }

    @Override
    public void show() {
        super.show();
        if (hasChildren()) {
            for (BaseWidget child : getChildren()) {
                child.show();
            }
        }
    }


    @Override
    public double getPrefHeight() {
        return 0;
    }
}
