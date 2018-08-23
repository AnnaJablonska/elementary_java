package vocabulator_app.gui;

import vocabulator_app.controller.SimpleActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem openFileMenuItem, saveToFileMenuItem;
    private JLabel originLabel, infoLabel;
    private JTextField translationTextField;
    private JButton checkTranslationBtn;
    private JPanel translationPanel;
    private ActionListener controller;

    public SimpleGUI() {
        initializeComponents();
    }
    public void setController(ActionListener controller){
        this.controller = controller;
        checkTranslationBtn.addActionListener(controller);
    }

    public void resetTranslationField(){
        translationTextField.setText("");
    }

    public void setInfoLabel(String text){
        infoLabel.setText(text);
    }

    public void setOriginLabel(String text){
        originLabel.setText(text);
    }

    public String getTranslationFiledText(){
       return translationTextField.getText();
    }

    private void initializeComponents() {
        //tworzenie okna
        frame = new JFrame("Vocabulator App");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(350, 200));
        //tworzenie paska menu
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(213, 123, 123));
        menuBar.setPreferredSize(new Dimension(300, 50));
        // tworzenie menu w pasku menu
        fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);
        //tworzenie podelementów menu
        openFileMenuItem = new JMenuItem("Otwórz");
        fileMenu.add(openFileMenuItem);
        saveToFileMenuItem = new JMenuItem("Zapisz");
        fileMenu.add(saveToFileMenuItem);
        // tworzenie panelu do tlumaczen
        translationPanel = new JPanel();
        // dodawanie elemntow do płótna
        originLabel = new JLabel("", SwingConstants.CENTER);
        translationTextField = new JTextField(10);
        checkTranslationBtn = new JButton("Sprawdź!");

        //dodanie action listenera (tzn. ze jak klikniemy guzik to on nam coś zrobić lub wyswietli)
        //najprostsza obsluga eventu.
        checkTranslationBtn.addActionListener(new SimpleActionListener());
        checkTranslationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Jestem anonimowym action listenerem");
            }
        });

        translationPanel.add(originLabel);
        translationPanel.add(translationTextField);
        translationPanel.add(checkTranslationBtn);

        frame.getContentPane().add(translationPanel,BorderLayout.CENTER);

        // tworzenie info label
        infoLabel = new JLabel("Tu beda informacje o wyniku.");
        frame.getContentPane().add(infoLabel, BorderLayout.PAGE_END);

        //
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);
    }
}
