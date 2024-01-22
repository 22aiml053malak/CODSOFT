import java.util.*;

class Grade {
    public String calculateGrade(int averageMarks) {
        switch (averageMarks / 10) {
            case 10:
                return "A+";
            case 9:
                return "A";
            case 8:
                return "B+";
            case 7:
                return "B";
            case 6:
                return "C+";
            default:
                if (averageMarks / 10 < 6)
                    return "C-";
                else
                    return "F";
        }
    }
}

public class Task02 {
    public static void main(String[] args) {
        Grade gg = new Grade();
        Scanner sc = new Scanner(System.in);

        // user input
        System.out.println("Enter the total number of subjects:");
        int totalSub = sc.nextInt();

        int totalMarks = 0;

        for (int i = 0; i < totalSub; i++) {
            System.out.println("Enter marks in each subject " + (i + 1) + ":");
            int subMarks = sc.nextInt();
            totalMarks += subMarks;
        }

        // calculate average marks
        int averageMarks = totalMarks / totalSub;

        // calculate grade
        String grade = gg.calculateGrade(averageMarks);

        // displaying data
        System.out.println("Total number of subjects: " + totalSub);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Percentage: " + averageMarks + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Written by Malak Soni");
    }
}
