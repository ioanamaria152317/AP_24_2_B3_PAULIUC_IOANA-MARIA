package org.example;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinner;
 //...
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        //create spinners for rows and cols, and the button
 //...TODO
        add(label); //JPanel uses FlowLayout by default
        add(spinner);
    }

    public int getRows() {
        return (int) spinner.getValue();
    }

    public int getCols() {
        return (int) spinner.getValue();
    }
}
