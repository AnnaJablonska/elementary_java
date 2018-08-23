package vocabulator_app.gui;

import java.awt.*;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        System.out.println(Arrays.toString(fonts));
    }
}
