public class StudentStorage {
    private Student[] arrayStudent;
    private int size;

    public StudentStorage(int capacity) {
        arrayStudent = new Student[capacity];
    }

    public StudentStorage() {
        arrayStudent = new Student[15];
    }

    public void add(Student students) {
        if (size == arrayStudent.length) {
            extend();
        }
        arrayStudent[size++] = students;
    }

    private void extend() {
        Student[] tmp = new Student[arrayStudent.length + 10];
        System.arraycopy(arrayStudent, 0, tmp, 0, arrayStudent.length);
        arrayStudent = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arrayStudent[i]);
        }
    }


    public Student getStudentByName(String name) {
        for (int i = 0; i < size; i++) {
            if (name.equals(arrayStudent[i].getName())) {
                return arrayStudent[i];
            }
        }
        return null;
    }

    public void printByLessonName(String name) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < arrayStudent[i].getLessons().length; j++) {
                if (arrayStudent[i].getLessons()[j].getName().equals(name)) {
                    System.out.println(arrayStudent[i]);
                }
            }
        }
    }
}
