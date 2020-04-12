public class StudentStorage {
    private Student[] students;
    private int size;

    public StudentStorage(int capacity) {
        students = new Student[capacity];
    }

    public StudentStorage() {
        students = new Student[15];
    }

    public void add(Student students) {
        if (size == this.students.length) {
            extend();
        }
        this.students[size++] = students;
    }

    private void extend() {
        Student[] tmp = new Student[students.length + 10];
        System.arraycopy(students, 0, tmp, 0, students.length);
        students = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }


    public Student getByName(String name) {
        for (int i = 0; i < size; i++) {
            if (name.equals(students[i].getName())) {
                return students[i];
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printByLessonName(Lesson byName) {
        for (int i = 0; i < size; i++) {
            for (Lesson lesson : students[i].getLessons()) {
                if (lesson.equals(byName)) {
                    System.out.println(students[i]);
                    break;
                }
            }
        }
    }
}
