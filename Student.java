import java.util.ArrayList;
import java.util.List;

public class Student {
public String fname;
public String lname;
public String indexNumber;
public String email;
public String address;
public List<Double> grades = new ArrayList<>();

public Student(String fname, String lname, String indexNumber, String email, String address) {
this.fname = fname;
this.lname = lname;
this.indexNumber = indexNumber;
this.email = email;
this.address = address;
}

public double calculateAverageGrade() {
if (grades.isEmpty()) {
throw new IllegalArgumentException("Grades are missing");
} else {
double sum = 0;
for (Double grade : grades) {
sum += grade;
}
double average = sum / grades.size();
double[] roundingList = {2, 2.5, 3, 3.5, 4, 4.5, 5};
double minDifference = Double.MAX_VALUE;
double closestValue = average;
for (double value : roundingList) {
double difference = Math.abs(value - average);
if (difference < minDifference) {
minDifference = difference;
closestValue = value;
}
}
return closestValue;
}
}

@Override
public String toString() {
double averageGrade;
try {
averageGrade = calculateAverageGrade();
} catch (IllegalArgumentException e) {
return "Student{" +
"fname='" + fname + '\'' +
", lname='" + lname + '\'' +
", indexNumber='" + indexNumber + '\'' +
", email='" + email + '\'' +
", address='" + address + '\'' +
", grades=" + grades +
", averageGrade=Grades are missing}";
}
return "Student{" +
"fname='" + fname + '\'' +
", lname='" + lname + '\'' +
", indexNumber='" + indexNumber + '\'' +
", email='" + email + '\'' +
", address='" + address + '\'' +
", grades=" + grades +
", averageGrade=" + averageGrade +
'}';
}

public void addGrades(double grade) {
if (grades.size() >= 20) {
throw new IllegalStateException("Cannot add more than 20 grades for a student.");
}
grades.add(grade);
}
}
