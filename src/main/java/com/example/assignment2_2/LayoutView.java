package com.example.assignment2_2;

import javafx.scene.layout.Pane;

import java.util.Iterator;

public class LayoutView extends Pane {
    LinearLayout root = new LinearLayout();

    public LayoutView() {
        root = new LinearLayout();
        SimWidget sw1 = new SimWidget(50,200,200, SimWidget.VerticalPosition.MIDDLE);
        root.addChild(sw1);
        SimWidget sw2 = new SimWidget(100,800,100, SimWidget.VerticalPosition.TOP);
        root.addChild(sw2);
        SimWidget sw3 = new SimWidget(50,150,150, SimWidget.VerticalPosition.FILL);
        root.addChild(sw3);
        LinearLayout hbox2 = new LinearLayout();
        SimWidget sw4 = new SimWidget(25,200,400, BaseWidget.VerticalPosition.MIDDLE);
        hbox2.addChild(sw4);
        SimWidget sw5 = new SimWidget(100,200,300, BaseWidget.VerticalPosition.TOP);
        hbox2.addChild(sw5);
        LinearLayout hbox3 = new LinearLayout();
        SimWidget sw6 = new SimWidget(75, 600, 100, BaseWidget.VerticalPosition.TOP);
        hbox3.addChild(sw6);
        SimWidget sw7 = new SimWidget(50,100,150, BaseWidget.VerticalPosition.MIDDLE);
        hbox3.addChild(sw7);
        hbox2.addChild(hbox3);
        root.addChild(hbox2);


        // 将所有组件添加到页面元素中
        this.getChildren().addAll(this.root.getAllSubs());

        this.widthProperty().addListener((observable -> root.doLayout(this.getWidth(), this.getHeight())));


        this.heightProperty().addListener((observable -> root.doLayout(this.getWidth(), this.getHeight())));
    }
}
