package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

//asta e pt dimensiuni , cum arata
//jpanel e gen pt o caseta
public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
    JSpinner spinner2;
    JButton create;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        //create spinners for rows and cols, and the button
        spinner2=new JSpinner(new SpinnerNumberModel(10,2, 100,1 ));

        add(spinner2);
        add(label); //JPanel uses FlowLayout by default
        add(spinner);

        create =new JButton("Create");
        //gen chiar sa schimbe daca i dau sa faca 5 col
        /*private void createAction (ActionEvent e ){

        }*/

    }

    public int getRows() {
        return (int) spinner.getValue();
    }

    public int getCols() {
        return (int) spinner2.getValue();
    }
}


