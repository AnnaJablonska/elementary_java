package vocabulator_app.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleActionListener implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Hej, to ja, Simple Action Listener!");
    }
}
