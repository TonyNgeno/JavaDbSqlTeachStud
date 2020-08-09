package com.tony.ngeno;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class MainClass implements MainClassI {

    @Override
    public void showMainMenu() throws SQLException, ClassNotFoundException {
        System.out.println("---PLEASE SELECT YOUR OPTION---");
        System.out.println("1. Teachers Details");
        System.out.println("2. Students Details");
        System.out.println("3. Subjects Details");
        System.out.println("4. Results Details");
        System.out.println("X. Exit");
        System.out.println("");

        int choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    try {
                        // method open teachers menu
                        showTeachersMenu();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case '2': {
                    // method open students menu
                    showStudentsMenu();
                    break;
                }
                case '3': {
                    // method open subjects menu
                    showSubjectsMenu();
                    break;
                }
                case '4': {
                    // method open results menu
                    showResultsMenu();
                    break;
                }
                case 'x': {
                    System.out.println("Thank You for using system.Bye!");
                    break;
                }

                default:
                    System.out.println("Invalid Choice!!");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void showTeachersMenu() throws SQLException, ClassNotFoundException {
        System.out.println("");
        System.out.println("---Teachers Details---");
        System.out.println("1. View All Teachers");
        System.out.println("2. Add Teacher(s)");
        System.out.println("3. Delete Teacher(s)");
        System.out.println("4. Update Teacher(s)");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    //method to view teachers
                    viewTeacher();
                    break;
                }
                case '2': {
                    //method to add teachers records
                    addTeacher();
                    break;
                }
                case '3': {
                    //method to delete teacher records
                    deleteTeacher();
                    break;
                }
                case '4': {
                    //method to update teacher details
                    updateTeacher();
                    break;
                }

                case 'x': {
                    //back to main menu
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid Choice!!");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void viewTeacher() throws SQLException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        Map<Integer, Teacher> teachers = teacher.getTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No Records Available");
        } else {
            for (Integer integer : teachers.keySet()) {
                Teacher teacher1 = teachers.get(integer);
                System.out.println(teacher1.toString());
            }
        }
        //back to menu
        showTeachersMenu();
    }

    @Override
    public void addTeacher() throws SQLException, ClassNotFoundException {
        System.out.println("---Add Teacher(s)---");
        char optionA = 'y';
        do {
            System.out.println("Enter Teacher's Name");
            Scanner in = new Scanner(System.in);
            String name = in.nextLine();

            Teacher teacher = new Teacher();
            if (!teacher.addTeacher(new Teacher(name))) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionA = in.nextLine().toLowerCase().charAt(0);
            if (optionA == 'n') {
                showTeachersMenu();
            } else {
                optionA = 'y';
            }

        } while (optionA == 'y');
    }

    @Override
    public void updateTeacher() throws SQLException, ClassNotFoundException {
        Teacher teacher = new Teacher();
        System.out.println("---Update Teacher(s)---");
        char optionB = 'y';
        do {
            System.out.println("Enter Teacher's Id");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter Teacher's Name");
            String name = new Scanner(System.in).nextLine();
            if (!teacher.updateTeacher(id, new Teacher(name))) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionB = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionB == 'n') {
                showTeachersMenu();
            } else {
                optionB = 'y';
            }

        } while (optionB == 'y');
    }

    @Override
    public void deleteTeacher() throws SQLException, ClassNotFoundException {
        System.out.println("---Delete Teacher(s) records---");
        char optionC = 'y';
        do {
            System.out.println("Enter Teacher's Id");
            int id = new Scanner(System.in).nextInt();

            Teacher teacher = new Teacher();
            if (!teacher.deleteTeacher(id)) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionC = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionC == 'n') {
                showTeachersMenu();
            } else {
                optionC = 'y';
            }

        } while (optionC == 'y');
    }

    @Override
    public void showSubjectsMenu() throws SQLException, ClassNotFoundException {
        System.out.println("");
        System.out.println("--- Subjects Details ---    ");
        System.out.println("1. View All Students");
        System.out.println("2. Add Subject(s)");
        System.out.println("3. Delete Subject(s)");
        System.out.println("4. Update Subject(s)");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    viewSubjects();
                    break;
                }
                case '2': {
                    addSubject();
                    break;
                }
                case '3': {
                    deleteSubject();
                    break;
                }
                case '4': {
                    updateSubject();
                    break;
                }

                case 'x': {
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void viewSubjects() throws SQLException, ClassNotFoundException {
        Subject subject = new Subject();
        Map<Integer, Subject> subjectMap = subject.getSubjects();
        for (Integer integer :
                subjectMap.keySet()) {
            System.out.println(subjectMap.get(integer).toString());
        }

        showSubjectsMenu();
    }

    @Override
    public void addSubject() throws SQLException, ClassNotFoundException {
        System.out.println("---Add Subject(s)---");
        char optionD = 'y';
        do {
            System.out.println("Enter Subject's Title");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter Teacher's Name");
            String teacher = new Scanner(System.in).nextLine();

            Subject subject = new Subject();

            if (!subject.addSubject(new Subject(
                    name,
                    new Teacher(
                            teacher
                    )
            ))) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionD = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionD == 'n') {
                showSubjectsMenu();
            } else {
                optionD = 'y';
            }

        } while (optionD == 'y');
    }

    @Override
    public void updateSubject() throws SQLException, ClassNotFoundException {
        System.out.println("---Update Subject(s)---");
        char optionE = 'y';
        do {
            System.out.println("Enter Subject Id");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter Subject's Title");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter Teacher's Name");
            String teacher = new Scanner(System.in).nextLine();

            Subject subject = new Subject();
            if (!subject.updateSubject(id, new Subject(
                    name,
                    new Teacher(
                            teacher
                    )
            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionE = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionE == 'n') {
                showSubjectsMenu();
            } else {
                optionE = 'y';
            }

        } while (optionE == 'y');
    }

    @Override
    public void deleteSubject() throws SQLException, ClassNotFoundException {
        System.out.println("Delete Subject(s):");
        char optionF = 'y';
        do {
            System.out.println("Enter subject's Id");
            int id = new Scanner(System.in).nextInt();

            Subject subject = new Subject();
            if (!subject.deleteSubject(id)) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionF = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionF == 'n') {
                showTeachersMenu();
            } else {
                optionF = 'y';
            }

        } while (optionF == 'y');

        showSubjectsMenu();
    }

    @Override
    public void showStudentsMenu() throws SQLException, ClassNotFoundException {
        System.out.println("");
        System.out.println("---Students Details--- ");
        System.out.println("1. View All");
        System.out.println("2. Add Student(s)");
        System.out.println("3. Delete Student(s)");
        System.out.println("4. Update Student(s)");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    viewStudents();
                    break;
                }
                case '2': {
                    addStudent();
                    break;
                }
                case '3': {
                    deleteStudent();
                    break;
                }
                case '4': {
                    updateStudent();
                    break;
                }

                case 'x': {
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');

    }

    @Override
    public void viewStudents() throws SQLException, ClassNotFoundException {
        Student student = new Student();
        Map<Integer, Student> subjectMap = student.getStudents();
        for (Integer integer :
                subjectMap.keySet()) {
            System.out.println(subjectMap.get(integer).toString());
        }

        showStudentsMenu();
    }

    @Override
    public void addStudent() throws SQLException, ClassNotFoundException {
        System.out.println("---Add Student(s)---");
        char optionG = 'y';
        do {
            System.out.println("Enter Student's Name");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter Student's Adm No:");
            String admNo = new Scanner(System.in).nextLine();

            Student student = new Student();
            if (!student.addStudent(new Student(
                    name,
                    admNo
            ))) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionG = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionG == 'n') {
                showStudentsMenu();
            } else {
                optionG = 'y';
            }

        } while (optionG == 'y');
    }

    @Override
    public void updateStudent() throws SQLException, ClassNotFoundException {
        System.out.println("---Update Student(s)---");
        char optionF = 'y';
        do {
            System.out.println("Enter Student's Id");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter Student's Name");
            String name = new Scanner(System.in).nextLine();
            System.out.println("Enter Student's Adm No:");
            String admNo = new Scanner(System.in).nextLine();

            Student student = new Student();
            if (!student.updateStudent(id, new Student(
                    name,
                    admNo
            ))) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionF = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionF == 'n') {
                showStudentsMenu();
            } else {
                optionF = 'y';
            }

        } while (optionF == 'y');
    }

    @Override
    public void deleteStudent() throws SQLException, ClassNotFoundException {
        System.out.println("---Delete Student(s)---");
        char optionI = 'y';
        do {
            System.out.println("Enter Students's Id");
            int id = new Scanner(System.in).nextInt();

            Student student = new Student();
            if (!student.deleteStudent(id)) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionI = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionI == 'n') {
                showStudentsMenu();
            } else {
                optionI = 'y';
            }

        } while (optionI == 'y');
    }

    @Override
    public void showResultsMenu() throws SQLException, ClassNotFoundException {
        System.out.println("");
        System.out.println("---Results---    ");
        System.out.println("6. View For Student");
        System.out.println("1. View All");
        System.out.println("2. Add Result(s)");
        System.out.println("3. Delete Result(s)");
        System.out.println("4. Update Result(s)");
        System.out.println("5. Clear All");
        System.out.println("X. Back");
        char choice = '0';
        do {

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextLine().toLowerCase().charAt(0);

            switch (choice) {
                case '1': {
                    viewResults();
                    break;
                }
                case '2': {
                    addResult();
                    break;
                }
                case '3': {
                    deleteResult();
                    break;
                }
                case '4': {
                    updateResult();
                    break;
                }

                case '5': {
                    clearResults();
                    break;
                }

                case '6': {
                    viewStudentResult();
                    break;
                }

                case 'x': {
                    showMainMenu();
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                    choice = '0';
            }

        } while (choice == '0');
    }

    @Override
    public void addResult() throws SQLException, ClassNotFoundException {
        System.out.println("---Add Result(s)---");
        char optionJ = 'y';
        do {
            System.out.println("Enter Student's admission NO:");
            String admNo = new Scanner(System.in).nextLine();
            System.out.println("Enter Subject Title");
            String subject = new Scanner(System.in).nextLine();
            System.out.println("Enter Student's Score");
            double score = new Scanner(System.in).nextDouble();

            Result result = new Result();
            if (!result.addResult(new ResultM(
                    -1,
                    admNo,
                    subject,
                    score

            ))) {
                System.out.println("Failed, please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionJ = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionJ == 'n') {
                showResultsMenu();
            } else {
                optionJ = 'y';
            }

        } while (optionJ == 'y');
    }

    @Override
    public void updateResult() throws SQLException, ClassNotFoundException {
        System.out.println("Update Result(s):");
        char optionK = 'y';
        do {
            System.out.println("Enter Id:");
            int id = new Scanner(System.in).nextInt();
            System.out.println("Enter Student's score");
            double score = new Scanner(System.in).nextDouble();

            Result result = new Result();
            if (!result.updateResult(id, new ResultM(
                    -1,
                    "",
                    "",
                    score

            ))) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionK = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionK == 'n') {
                showResultsMenu();
            } else {
                optionK = 'y';
            }

        } while (optionK == 'y');
    }

    @Override
    public void deleteResult() throws SQLException, ClassNotFoundException {
        System.out.println("---Delete Student(s)---");
        char optionL = 'y';
        do {
            System.out.println("Enter Students's Id");
            int id = new Scanner(System.in).nextInt();

            Student student = new Student();
            if (!student.deleteStudent(id)) {
                System.out.println("Failed, Please try again");
            } else {
                System.out.println("Success!");
            }

            System.out.println("Proceed? (Y/N)");
            optionL = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionL == 'n') {
                showResultsMenu();
            } else {
                optionL = 'y';
            }

        } while (optionL == 'y');
    }

    @Override
    public void viewResults() throws SQLException, ClassNotFoundException {
        Result result = new Result();
        ArrayList<ResultM> resultMS = result.viewAll();
        for (ResultM resultM :
                resultMS) {
            System.out.println(resultM.toString());
        }

        showResultsMenu();
    }

    @Override
    public void viewStudentResult() throws SQLException, ClassNotFoundException {
        Result result = new Result();
        System.out.println("Delete Student(s):");
        char optionM = 'y';
        do {
            System.out.println("Enter students's admission NO:");
            String adm = new Scanner(System.in).nextLine();

            Result result1 = result.getResults(adm);
            System.out.println(result1.toString());

            System.out.println("Proceed? (Y/N)");
            optionM = new Scanner(System.in).nextLine().toLowerCase().charAt(0);
            if (optionM == 'n') {
                showResultsMenu();
            } else {
                optionM = 'y';
            }

        } while (optionM == 'y');

        showResultsMenu();
    }

    @Override
    public void clearResults() throws SQLException, ClassNotFoundException {
        Result result = new Result();
        result.clearAll();
    }
}
