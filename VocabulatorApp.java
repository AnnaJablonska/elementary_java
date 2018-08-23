package vocabulator_app;

import vocabulator_app.controller.VocabulatorController;
import vocabulator_app.gui.SimpleGUI;

public class VocabulatorApp {
    public static void main(String[] args) {

        VocabulatorController controller = new VocabulatorController();

        SimpleGUI gui = new SimpleGUI();

        gui.setController(controller);
        controller.setGui(gui);
    }
}
