package vocabulator_app;

import vocabulator_app.controller.DemoController;
import vocabulator_app.gui.SimpleGUI;

public class GUIControllerDemo {
    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI();
        DemoController controller = new DemoController(gui);

    }
}
