package org.example;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel=new ConfigPanel(this);  //add in north?
    ControlPanel controlPanel=new ControlPanel(this);  //sud
    DrawingPanel canvas=new DrawingPanel(this);

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        configPanel =new ConfigPanel(this);
        controlPanel=new ControlPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);


        //invoke the layout manager
        pack();
    }
}

