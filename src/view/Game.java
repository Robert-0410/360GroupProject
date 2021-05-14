package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends JPanel {

    private static Game uniqueInstance;

    private ArrayList<GUIPanel> myPanels;

    private Game() {
        buildGame();
    }

    public static Game getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Game();
        }
        return uniqueInstance;
    }

    private void buildGame() {
        fetchPanels();
        prepGamePanel();
        addPanels();
    }

    private void fetchPanels() {
        var buttonPanel = ButtonPanel.getInstance();
        myPanels.add(2, buttonPanel);
    }

    private void prepGamePanel() {
        setLayout(new BorderLayout());
    }

    private void addPanels() {
        add(myPanels.get(2), BorderLayout.SOUTH);
    }
}
