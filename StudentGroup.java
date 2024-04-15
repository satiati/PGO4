import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
public String name;
public List<Student> students = new ArrayList<>();

public StudentGroup(String name) {
this.name = name;
}
public void add(Student s1) {
if (students.contains(s1)) {
throw new IllegalStateException("Student " + s1.fname + " " + s1.lname + " is already in the group.");
}
if (students.size() >= 15) {
throw new IllegalStateException("Group is already full. Cannot add more students.");
}
students.add(s1);
}
public void printStudents() {
System.out.println("Students in group " + name + ":");
for (Student student : students) {
System.out.println(student);
}
}
}
