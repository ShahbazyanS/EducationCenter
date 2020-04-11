import java.util.Scanner;

public class EducationCenter {
    static Scanner scanner = new Scanner(System.in);
    static StudentStorage ss = new StudentStorage();
    static LessonStorage ls = new LessonStorage();

    private static final int EXIT = 0;
    private static final int ADD_STUDENT = 1;
    private static final int ADD_LESSON = 2;
    private static final int PRINT_STUDENTS = 3;
    private static final int PRINT_LESSONS = 4;
    private static final int CHANGE_STUDENT_LESSON = 5;
    private static final int PRINT_STUDENT_BY_LESSON_NAME = 6;

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
//            printCommands();
            String commandsStr = scanner.nextLine();
            int commands = Integer.parseInt(commandsStr);
            switch (commands) {
                case EXIT:
                    isRun = false;
                    System.out.println("(EXIT) ");
                    break;
                case ADD_STUDENT:
                    addStudents();
                    break;
                case ADD_LESSON:
                    addLessons();
                    break;
                case PRINT_STUDENTS:
                    ss.print();
                    break;
                case PRINT_LESSONS:
                    ls.print();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case PRINT_STUDENT_BY_LESSON_NAME:
                    printStudentByLessonname();
                    break;
                default:
                    System.out.println("սխալ հրաման");
            }
        }
    }


    private static void addStudents() {
        System.out.println("Առարկայի անուն");
        String s = scanner.nextLine();
        String[] a = s.split(",");
        Lesson[] array = new Lesson[a.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = ls.getByName(a[i]);
        }
        Student student = new Student();
        System.out.println("ուսանողի տվյալներ (name, sureName, price, email)");
        String stud = scanner.nextLine();
        String[] students = stud.split(",");
        student.setLessons(array);
        student.setName(students[0]);
        student.setSurename(students[1]);
        student.setPhone(Integer.parseInt(students[2]));
        student.setEmail(students[3]);
        ss.add(student);
    }

    private static void addLessons() {
        System.out.println("առարկա (name, duration, price, lecturerName)");
        String lss = scanner.nextLine();
        String[] lessons = lss.split(",");
        Lesson lesson = new Lesson();
        lesson.setName(lessons[0]);
        lesson.setDuration(Integer.parseInt(lessons[1]));
        lesson.setPrice(Double.parseDouble(lessons[2]));
        lesson.setLecturerName(lessons[3]);
        ls.add(lesson);
    }

    private static void changeStudentLesson() {
        System.out.println("ուսանողի անունը առարկան փոխելու համար");
        String s = scanner.nextLine();
        ss.getStudentByName(s);
        System.out.println("փոխվող առարկան");
        String a = scanner.nextLine();
        String[] b = a.split(",");
        Lesson[] arr = new Lesson[b.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ls.getByName(b[i]);
        }
        ss.getStudentByName(s).setLessons(arr);
    }

    private static void printStudentByLessonname() {
        System.out.println("առարկայի անունը ուսանողին գտնելու համար");
        String lessonName = scanner.nextLine();
        ss.printByLessonName(lessonName);
    }

    private static void printCommands() {
        System.out.println("Ներմուծել " + EXIT + " դուրս գալու համար");
        System.out.println("Ներմուծել " + ADD_STUDENT + " ուսանող ավելացնելու համար");
        System.out.println("Ներմուծել " + ADD_LESSON + " առարկա ավելացնելու համար");
        System.out.println("Ներմուծել " + PRINT_STUDENTS + "  ուսանողներին տեսնելու համար");
        System.out.println("Ներմուծել " + PRINT_LESSONS + " առարկան տեսնելու համար");
        System.out.println("Ներմուծել " + CHANGE_STUDENT_LESSON + " առարկան փոխելու համար");
        System.out.println("Ներմուծել " + PRINT_STUDENT_BY_LESSON_NAME + " գտնել ուսանողին առարկայի անունով");

    }

}
