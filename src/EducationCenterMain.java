import java.util.Scanner;

public class EducationCenterMain implements Commands{
    static Scanner scanner = new Scanner(System.in);
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();

    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
//            printCommands();
            int commands = Integer.parseInt(scanner.nextLine());
            switch (commands) {
                case EXIT:
                    isRun = false;
                    System.out.println("(EXIT) ");
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case PRINT_STUDENT_BY_LESSON_NAME:
                    printStudentByLessonName();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }


    private static void addStudent() {
        if (lessonStorage.isEmpty()){
            System.out.println("Please add lesson first:");
            return;
        }
        Lesson[] lessons = chooseLesson();
        System.out.println("Please input Student data: name,surname,phone,email");
        Student student = new Student();
        String studentDataStr = scanner.nextLine();
        String[] studentData = studentDataStr.split(",");
        student.setLessons(lessons);
        student.setName(studentData[0]);
        student.setSurename(studentData[1]);
        student.setPhone(Integer.parseInt(studentData[2]));
        student.setEmail(studentData[3]);
        studentStorage.add(student);
        System.out.println("Thank you, Student was added");
    }



    private static void addLesson() {
        System.out.println("Please input Lesson data: name, lecturerName, duration, price");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(",");
        Lesson lesson = new Lesson();
        lesson.setName(lessonData[0]);
        lesson.setDuration(Integer.parseInt(lessonData[1]));
        lesson.setPrice(Double.parseDouble(lessonData[2]));
        lesson.setLecturerName(lessonData[3]);
        lessonStorage.add(lesson);
        System.out.println("Lesson was added!");
    }

    private static void changeStudentLesson() {
        System.out.println("Please input Student name");
        String studentName = scanner.nextLine();
        Student byName = studentStorage.getByName(studentName);
        if (byName == null){
            System.out.println("Wrong name!");
            changeStudentLesson();
        }else {
            Lesson[] lessons = chooseLesson();
            byName.setLessons(lessons);
            System.out.println("Please input Student name");
        }

    }

    private static void printStudentByLessonName() {
        String lessonName = scanner.nextLine();
        Lesson byName = lessonStorage.getByName(lessonName);
        if (byName == null){
            System.out.println("Wrong lesson name!");
            printStudentByLessonName();
        }else {
            studentStorage.printByLessonName(byName);
        }
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
    private static Lesson[] chooseLesson() {
        System.out.println("Please choose Lessons from list");
        lessonStorage.print();
        String lessonsStr = scanner.nextLine();
        String [] lessonNames = lessonsStr.split(",");
        Lesson [] lessons = new Lesson[lessonNames.length];
        int i = 0;
        for (String lessonName : lessonNames){
            Lesson byName = lessonStorage.getByName(lessonName);
            if (byName != null){
                lessons[i++] = byName;
            }
        }
        return lessons;
    }

}
