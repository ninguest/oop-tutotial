import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public class StudentScoreGUI {
    private JFrame frame;
    private JTextArea textArea;

    public StudentScoreGUI() {
        frame = new JFrame("Student Scores");
        textArea = new JTextArea();

        // Set layout manager
        frame.setLayout(new BorderLayout());

        // Add a border around the text area
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add components to frame
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Set frame properties
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        // Load CSV file
        File file = new File("student_scores.csv");
        if (file.exists()) {
            System.out.println("Found scores.csv");
            loadCSV(file);
        } else {
            JOptionPane.showMessageDialog(frame, "Could not find scores.csv. Please select a file.");
            loadCSV();    
        }

        // Make frame visible
        frame.setVisible(true);
    }

    private void loadCSV() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            loadCSV(fileChooser.getSelectedFile());
        }
    }

    private void loadCSV(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // skip header
            List<String> names = new ArrayList<>();
            List<Integer> quiz1Scores = new ArrayList<>();
            List<Integer> quiz2Scores = new ArrayList<>();
            List<Integer> assignmentScores = new ArrayList<>();
            List<Integer> examScores = new ArrayList<>();
            int topScore = 0;
            String topScorer = "";
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                names.add(values[0]);
                int quiz1Score = Integer.parseInt(values[1]);
                int quiz2Score = Integer.parseInt(values[2]);
                int assignmentScore = Integer.parseInt(values[3]);
                int examScore = Integer.parseInt(values[4]);
                int totalScore = quiz1Score + quiz2Score + assignmentScore + examScore;
                quiz1Scores.add(quiz1Score);
                quiz2Scores.add(quiz2Score);
                assignmentScores.add(assignmentScore);
                examScores.add(examScore);
                int average = totalScore / 4;
                if (average > topScore) {
                    topScore = average;
                    topScorer = values[0];
                }
            }
            displayTable(names, quiz1Scores, quiz2Scores, assignmentScores, examScores, topScorer, topScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String assignGrade(int average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    private void displayTable(List<String> names, List<Integer> quiz1Scores, List<Integer> quiz2Scores, List<Integer> assignmentScores, List<Integer> examScores, String topScorer, int topScore) {
        String[] columnNames = {"Name", "Quiz 1", "Quiz 2", "Assignment", "Exam", "Average", "Grade"};
        Object[][] data = new Object[names.size() + 1][7];
        for (int i = 0; i < names.size(); i++) {
            int totalScore = quiz1Scores.get(i) + quiz2Scores.get(i) + assignmentScores.get(i) + examScores.get(i);
            int average = totalScore / 4;
            data[i][0] = names.get(i);
            data[i][1] = quiz1Scores.get(i);
            data[i][2] = quiz2Scores.get(i);
            data[i][3] = assignmentScores.get(i);
            data[i][4] = examScores.get(i);
            data[i][5] = average;
            data[i][6] = assignGrade(average);
        }
        data[names.size()][0] = "Top Scorer: ";
        data[names.size()][1] = topScorer;
        data[names.size()][5] = topScore;
        JTable table = new JTable(data, columnNames);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.revalidate();
    }
    
    private double calculateAverage(List<Integer> scores) {
        return scores.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentScoreGUI::new);
    }
}