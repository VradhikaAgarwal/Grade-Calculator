
package studentgradecalculator;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradeCalculator extends JFrame implements ActionListener{

    private JTextField nameField, exam1Field, exam2Field, finalExamField;
    private JLabel nameLabel, exam1Label, exam2Label, finalExamLabel, resultLabel;

    public StudentGradeCalculator() {
        // Set up the JFrame
        setTitle("Student Grade Calculator");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and configure components
        nameLabel = new JLabel("Enter the student's name:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 30));
      //  nameLabel.setBackground(Color.YELLOW);
      //  nameLabel.setOpaque(true); 
      
        nameField = new JTextField(20);
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setPreferredSize(new Dimension(200, 40));
      //  nameField.setBackground(Color.LIGHT_GRAY);
      //  nameField.setOpaque(true); 
        
        exam1Label = new JLabel("Enter the marks for Physics:");
        exam1Label.setFont(new Font("Arial", Font.PLAIN, 30));
        
        exam1Field = new JTextField(5);
        exam1Field.setFont(new Font("Arial", Font.PLAIN, 20));
        exam1Field.setPreferredSize(new Dimension(200, 40));

        
        exam2Label = new JLabel("Enter the marks for Chemistry:");
        exam2Label.setFont(new Font("Arial", Font.PLAIN, 30));
        exam2Field = new JTextField(5);
        exam2Field.setFont(new Font("Arial", Font.PLAIN, 20));
        exam2Field.setPreferredSize(new Dimension(200, 40));

        finalExamLabel = new JLabel("Enter the marks for Maths:");
        finalExamLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        finalExamField = new JTextField(5);
        finalExamField.setFont(new Font("Arial", Font.PLAIN, 20));
        finalExamField.setPreferredSize(new Dimension(200, 40));


        JButton calculateButton = new JButton("Calculate Grade");
        calculateButton.addActionListener(this);
        calculateButton.setFont(new Font("Arial", Font.PLAIN, 30));

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 22));
        resultLabel.setBackground(Color.WHITE);
        resultLabel.setOpaque(true); 
     //   resultLabel.setPreferredSize(new Dimension(200, 40));
        
        // Create a panel to hold components
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        panel.setBackground(Color.cyan);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(nameLabel, gbc);

        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(exam1Label, gbc);

        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(exam1Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(exam2Label, gbc);

        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(exam2Field, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(finalExamLabel, gbc);

        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(finalExamField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(calculateButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        panel.add(resultLabel, gbc);

        // Add the panel to the frame
        add(panel);

        // Display the JFrame
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Calculate Grade")) {
            String studentName = nameField.getText();
            double Physics = Double.parseDouble(exam1Field.getText());
            double Chemistry = Double.parseDouble(exam2Field.getText());
            double Maths = Double.parseDouble(finalExamField.getText());
            
            double TotalSum=Physics+Chemistry+Maths;
            double averageScore = (TotalSum) / 3.0;
            char grade;

            if (averageScore >= 90) {
                grade = 'A';
            } else if (averageScore >= 80) {
                grade = 'B';
            } else if (averageScore >= 70) {
                grade = 'C';
            } else if (averageScore >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }

            resultLabel.setText("   Student Name: " + studentName + "   \nTotal Sum: "+ TotalSum+   "   \n Average Percentage: " + averageScore + "   \n Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentGradeCalculator();
        });
    }
}
    

