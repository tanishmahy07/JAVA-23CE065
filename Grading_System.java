import java.util.Scanner;
class Student {
    private int studentID;
    private String name;
    public Student(int studentID, String name){
        this.studentID = studentID;
        this.name = name;
    }
    public int getStudentID(){
        return studentID;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString(){
        return "Student ID: " + studentID + ", Name: " + name;
    }
}
class Grade {
    private int studentID;
    private int courseID;
    private char grade;
    public Grade(int studentID, int courseID, char grade){
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }
    public int getStudentID(){
        return studentID;
    }
    public int getCourseID(){
        return courseID;
    }
    public char getGrade(){
        return grade;
    }
    @Override
    public String toString(){
        return "Student ID: " + studentID + ", Course ID: " + courseID + ", Grade: " + grade;
    }
}
class GradingSystem {
    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount;
    private int gradeCount;
    public GradingSystem(int maxStudents, int maxGrades, int maxCourses) {
        students = new Student[maxStudents];
        grades = new Grade[maxGrades];
        courseCredits = new int[maxCourses];
        studentCount = 0;
        gradeCount = 0;
    }
    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student limit reached.");
        }
    }
    public void addGrade(Grade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount++] = grade;
            System.out.println("Grade added successfully.");
        } else {
            System.out.println("Grade limit reached.");
        }
    }
    public void addCourseCredits(int courseID, int credits) {
        if (courseID >= 0 && courseID < courseCredits.length) {
            courseCredits[courseID] = credits;
            System.out.println("Course credits added successfully.");
        } else {
            System.out.println("Invalid course ID.");
        }
    }
    public double calculateGPA(int studentID) {
        int totalPoints = 0;
        int totalCredits = 0;

        for (Grade grade : grades) {
            if (grade != null && grade.getStudentID() == studentID) {
                int credits = courseCredits[grade.getCourseID()];
                totalCredits += credits;
                totalPoints += gradeToPoints(grade.getGrade()) * credits;
            }
        }
    return totalCredits == 0 ? 0 : (double) totalPoints / totalCredits;
    }
    private int gradeToPoints(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }
    public void displayAllStudents() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }
    public void displayAllGrades() {
        for (Grade grade : grades) {
            if (grade != null) {
                System.out.println(grade);
            }
        }
    }
}
public class Grading_System {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradingSystem gradingSystem = new GradingSystem(100, 200, 50);
        while (true) {
            System.out.println("Grading System Management");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Add Course Credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Display All Students");
            System.out.println("6. Display All Grades");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    gradingSystem.addStudent(new Student(studentID, name));
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseID = scanner.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade = scanner.next().charAt(0);
                    gradingSystem.addGrade(new Grade(studentID, courseID, grade));
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    courseID = scanner.nextInt();
                    System.out.print("Enter Credits: ");
                    int credits = scanner.nextInt();
                    gradingSystem.addCourseCredits(courseID, credits);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextInt();
                    double gpa = gradingSystem.calculateGPA(studentID);
                    System.out.println("GPA: " + gpa);
                    break;
                case 5:
                    gradingSystem.displayAllStudents();
                    break;
                case 6:
                    gradingSystem.displayAllGrades();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
