import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PostionRoulet extends JFrame {
    private JFrame mainframe;
    private JPanel mainPanel;
    private JLabel names;
    private JTextField tfName;
    private JLabel lbPostions;
    private JTextField tfPostions;
    private JList resultlist;
    private JLabel lbResults;
    private JButton btnrandom;
    private JButton btnClear;
    private JButton infoButton;

    public PostionRoulet() {
        mainframe = new JFrame();
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.add(mainPanel);
        mainframe.setVisible(true);
        resultlist.setBorder(new LineBorder(Color.BLUE));
        tfName.setBorder(new LineBorder(Color.BLUE));
        tfName.setBackground(Color.YELLOW);
        tfPostions.setBorder(new LineBorder(Color.BLUE));
        tfPostions.setBackground(Color.GREEN);
        resultlist.setBackground(Color.CYAN);
        mainPanel.setBorder(new LineBorder(Color.YELLOW));
        mainPanel.setBackground(Color.LIGHT_GRAY);
        btnrandom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomizeNamesAndPositions();
            }

        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfName.setText("");
                tfPostions.setText("");
                DefaultListModel<String> listModel = new DefaultListModel<>();
                resultlist.setModel(listModel);
            }
        });
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel<String> listModel = new DefaultListModel<>();
                listModel.add(0, "Om namen en posities te scheiden gebruik de comma");
                listModel.add(1, "Als je één positie twee keer wil terug zien voer hem twee keer in");
                listModel.add(2, "Even aantal aan namen en functies nodig");
                resultlist.setModel(listModel);
            }
        });
        tfName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomizeNamesAndPositions();
            }
        });
        tfPostions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                randomizeNamesAndPositions();
            }
        });
    }
    private void randomizeNamesAndPositions() {
        // Same code for randomizing and assigning roles as before
        // ...
        String namesInput = tfName.getText();
        List<String> namesList = Arrays.asList(namesInput.split("\\s*,\\s*")); // Assumes names are separated by commas

        String positionsInput = tfPostions.getText();
        List<String> positionsList = Arrays.asList(positionsInput.split("\\s*,\\s*")); // Assumes positions are separated by commas

        // Shuffle the names and positions randomly
        Collections.shuffle(namesList);
        Collections.shuffle(positionsList);

        // Ensure there are enough positions for each name
        if (namesList.size() > positionsList.size()) {
            JOptionPane.showMessageDialog(PostionRoulet.this, "Not enough positions for all names.");
            return;
        }

        // Pair names with positions
        List<String> assignments = new ArrayList<>();
        for (int i = 0; i < namesList.size(); i++) {
            assignments.add(namesList.get(i) + ": " + positionsList.get(i));
        }

        // Display the assignments in the JList
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String assignment : assignments) {
            listModel.addElement(assignment);
        }
        resultlist.setModel(listModel);
    }
    public static void main(String[] args) {
        PostionRoulet gui = new PostionRoulet();
        gui.setContentPane(gui.mainPanel);
        gui.setName("Position roulering");
        gui.setVisible(true);
        gui.setSize(683, 384);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
