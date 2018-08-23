package vocabulator_app.controller;

import vocabulator_app.gui.SimpleGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoController implements ActionListener {
    SimpleGUI gui;

    public DemoController(SimpleGUI gui) {
        this.gui = gui;
        gui.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.resetTranslationField();
    }
}
