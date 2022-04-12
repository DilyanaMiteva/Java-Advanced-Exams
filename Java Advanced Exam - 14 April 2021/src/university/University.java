package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        if (this.students.size() >= this.capacity) {
            return "No seats in the university";
        } else if (this.students.contains(student)) {
            return "Student is already in the university";
        } else {
            this.students.add(student);
            String firstName = student.getFirstName();
            String lastName = student.getLastName();
            return String.format("Added student %s %s",
                    firstName, lastName);
        }
    }

    public String dismissStudent(Student student) {
        if (!this.students.contains(student)) {
            return "Student not found";
        }
        this.students.remove(student);
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        return "Removed student " + firstName + " " + lastName;
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream().filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {

        StringBuilder out = new StringBuilder();
        this.students.forEach(student -> out.append("==Student: ")
                .append("First Name = ").append(student.getFirstName())
                .append(", Last Name = ").append(student.getLastName())
                .append(", Best Subject = ").append(student.getBestSubject())
                .append(System.lineSeparator()));
        return out.toString().trim();

    }

}
