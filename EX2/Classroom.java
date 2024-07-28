import java.util.*;

public class Classroom {
    private String name;
    private Set<Student> students;
    private Map<String, Assignment> assignments;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashSet<>();
        this.assignments = new HashMap<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addAssignment(Assignment assignment) {
        assignments.put(assignment.getDetails(), assignment);
    }

    public boolean submitAssignment(String studentID, String assignmentDetails) {
        Assignment assignment = assignments.get(assignmentDetails);
        if (assignment != null) {
            assignment.addSubmission(new Submission(studentID));
            return true;
        }
        return false;
    }
}
