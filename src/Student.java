import java.util.Arrays;

public class Student {


    private Lesson[] lessons;
    private String name;
    private String surename;
    private int phone;
    private String email;

    public Student(Lesson[] lessons, String name, String surename, int phone, String email) {
        this.lessons = lessons;
        this.name = name;
        this.surename = surename;
        this.phone = phone;
        this.email = email;
    }

    public Student() {
    }

    public Lesson[] getLessons() {
        return lessons;
    }

    public void setLessons(Lesson[] lessons) {
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (phone != student.phone) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(lessons, student.lessons)) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (surename != null ? !surename.equals(student.surename) : student.surename != null) return false;
        return email != null ? email.equals(student.email) : student.email == null;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(lessons);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surename != null ? surename.hashCode() : 0);
        result = 31 * result + phone;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "lessons=" + Arrays.toString(lessons) +
                ", name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

}