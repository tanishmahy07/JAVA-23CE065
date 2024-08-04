import java.util.*;
class Student {
    private int ID;
    private String name;
    private int age;
    private String department;
    public void getdata(int id, String name, int age, String department) {
        this.ID = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }
    @Override
    public String toString() {
        return "ID: " + ID + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
    public void display() {
        System.out.println(this);
    }
    public boolean search(int search_id) {
        return search_id == ID;
    }
}
public class Student_Record_System {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int choice;
        Student[] Stu = null;
        int number = 0;
        System.out.println("Enter 1 to add student data");
            System.out.println("Enter 2 to search student data");
            System.out.println("Enter 3 to add new student data");
            System.out.println("Enter 4 to display all student data");
            System.out.println("Enter 5 to exit");
            do
            {
            System.out.println("Enter your choice: ");
            choice = S.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter number of student data you want to add:");
                    number = S.nextInt();
                    Stu = new Student[number];
                    for (int i = 0; i < number; i++) {
                        Stu[i] = new Student();
                        System.out.println("Enter data of student " + (i + 1) + ":");
                        System.out.println("Enter ID: ");
                        int id = S.nextInt();
                        System.out.println("Enter Name: ");
                        S.nextLine(); 
                        String name = S.nextLine();
                        System.out.println("Enter age: ");
                        int age = S.nextInt();
                        System.out.println("Enter department: ");
                        S.nextLine(); 
                        String department = S.nextLine();
                        Stu[i].getdata(id, name, age, department);
                    }
                    break;
                case 2:
                    if (Stu != null) {
                        System.out.println("Enter the ID to search:");
                        int search_id = S.nextInt();
                        boolean found = false;
                        for (int i = 0; i < number; i++) {
                            if (Stu[i].search(search_id)) {
                                Stu[i].display();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Student not found.");
                        }
                    } else {
                        System.out.println("No student data available. Add students first.");
                    }
                    break;
                case 3:
                    System.out.println("Enter ID:");
                    int id = S.nextInt();
                    System.out.println("Enter name:");
                    S.nextLine(); 
                    String name = S.nextLine();
                    System.out.println("Enter age: ");
                    int age = S.nextInt();
                    System.out.println("Enter department");
                    S.nextLine(); 
                    String department = S.nextLine();
                    Student newStudent = new Student();
                    newStudent.getdata(id, name, age, department);
                    if (Stu == null) {
                        Stu = new Student[1];
                        Stu[0] = newStudent;
                        number = 1;
                    } else {
                        Stu = Arrays.copyOf(Stu, number + 1);
                        Stu[number] = newStudent;
                        number++;
                    }
                    break;
                case 4:
                    if (Stu != null) {
                        for (int i = 0; i < number; i++) {
                            Stu[i].display();
                        }
                    } else {
                        System.out.println("No student data available. Add students first.");
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
        S.close();
    }
}
