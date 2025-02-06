import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ToDoList
{
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    
    public ToDoList() {
        JFrame frame = new JFrame("To-Do List");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Selected");
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String task = taskField.getText();
                if (!task.isEmpty())
                {
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });
        
        removeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) 
            {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) 
                {
                    listModel.remove(selectedIndex);
                }
            }
        });
        
        JPanel panel = new JPanel();
        panel.add(taskField);
        panel.add(addButton);
        panel.add(removeButton);
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        
        frame.setVisible(true);
    }
    
    public static void main() 
    {
        SwingUtilities.invokeLater(ToDoList::new);
    }
}
