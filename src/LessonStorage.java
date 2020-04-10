public class LessonStorage {
    private Lesson[] lessons;
    private int size;


    public LessonStorage(int capacity) {
        lessons = new Lesson[capacity];
    }

    public LessonStorage() {
        lessons = new Lesson[15];
    }

    public void add(Lesson lesson) {
        if (size == lessons.length) {
            extend();
        }
        lessons[size++] = lesson;
    }

    private void extend() {
        Lesson[] tmp = new Lesson[lessons.length + 15];
        System.arraycopy(lessons, 0, tmp, 0, lessons.length);
        lessons = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i]);
        }
    }

    public Lesson getByName(String lessonName) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].getName().equals(lessonName)) {
                return lessons[i];
            }
        }
        return null;
    }
}