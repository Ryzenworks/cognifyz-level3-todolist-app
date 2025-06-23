package LevelThreeTask;

import javax.swing.*;
import java.awt.*;

public class ToDoListApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        DefaultListModel<String> taskModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Selected");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(taskField, BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(removeButton, BorderLayout.CENTER);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a task.");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to remove.");
            }
        });

        frame.setVisible(true);
    }
}
