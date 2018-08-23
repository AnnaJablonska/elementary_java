package vocabulator_app.gui;

import javax.swing.*;
import java.awt.*;

public class SwingDemo {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() { //fragment
            public void run() { // kodu odpowiedzialny za umieszczenie wywołania
                // w specjalnym dla Swinga wątku event dispatcher
                createAndShowGUI(); // kod do odpalenia
            }
        });
    }


    private static void createAndShowGUI() {
        //Stwórz okno
        JFrame frame = new JFrame("Tytuł okna");
        //co zrobić po kliknięciu krzyżyka
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // ustaw minimalny rozmiar okna
        frame.setMinimumSize(new Dimension(300, 300));
        //Stwórz pasek menu
        JMenuBar greenMenuBar = new JMenuBar();
        //ustaw kolor tła
        greenMenuBar.setBackground(new Color(154, 165, 127));
        //ustaw preferowany rozmiar paska menu
        greenMenuBar.setPreferredSize(new Dimension(1000, 50));
        //Ustaw pasek jako pasek stworzonego okna
        frame.setJMenuBar(greenMenuBar);
        // dopasuj okno do wewnętrznych elementów
        frame.pack();
        //Wyświetl okno
        frame.setVisible(true);
    }
}
