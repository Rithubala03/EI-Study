import java.util.*;

public class VirtualClassroomManager {
    private Map<String, Classroom> classrooms;

    public VirtualClassroomManager() {
        classrooms = new HashMap<>();
    }

    public void addClassroom(String className) {
        if (classrooms.containsKey(className)) {
            System.out.println("Classroom " + className + " already exists.");
        } else {
            classrooms.put(className, new Classroom(className));
            System.out.println("Classroom " + className + " has been created.");
        }
    }

    public void addStudent(String studentId, String className) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.addStudent(studentId);
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void scheduleAssignment(String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.scheduleAssignment(assignmentDetails);
            System.out.println("Assignment for " + className + " has been scheduled.");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        Classroom classroom = classrooms.get(className);
        if (classroom != null) {
            classroom.submitAssignment(studentId, assignmentDetails);
            System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        } else {
            System.out.println("Classroom " + className + " does not exist.");
        }
    }

    public static void main(String[] args) {
        VirtualClassroomManager manager = new VirtualClassroomManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            if (parts.length < 2) {
                System.out.println("Invalid command format. Please try again.");
                continue;
            }

            String command = parts[0];
            String[] arguments = parts[1].split(" ", 2);

            switch (command) {
                case "add_classroom":
                    if (arguments.length == 1) {
                        manager.addClassroom(arguments[0]);
                    } else {
                        System.out.println("Usage: add_classroom <class_name>");
                    }
                    break;
                case "add_student":
                    if (arguments.length == 2) {
                        manager.addStudent(arguments[0], arguments[1]);
                    } else {
                        System.out.println("Invalid command format for adding student. Usage: add_student <student_id> <class_name>");
                    }
                    break;
                case "schedule_assignment":
                    if (arguments.length == 2) {
                        manager.scheduleAssignment(arguments[0], arguments[1]);
                    } else {
                        System.out.println("Usage: schedule_assignment <class_name> <assignment_details>");
                    }
                    break;
                case "submit_assignment":
                    if (arguments.length == 2) {
                        String[] details = arguments[1].split(" ", 2);
                        if (details.length == 2) {
                            manager.submitAssignment(arguments[0], details[0], details[1]);
                        } else {
                            System.out.println("Invalid command format for submitting assignment. Usage: submit_assignment <student_id> <class_name> <assignment_details>");
                        }
                    } else {
                        System.out.println("Usage: submit_assignment <student_id> <class_name> <assignment_details>");
                    }
                    break;
                default:
                    System.out.println("Unknown command: " + command);
            }
        }
    }
}

class Classroom {
    private String name;
    private Set<String> students;
    private List<String> assignments;
    private Map<String, List<String>> submissions;

    public Classroom(String name) {
        this.name = name;
        this.students = new HashSet<>();
        this.assignments = new ArrayList<>();
        this.submissions = new HashMap<>();
    }

    public void addStudent(String studentId) {
        if (students.add(studentId)) {
            System.out.println("Student " + studentId + " has been enrolled in " + name + ".");
        } else {
            System.out.println("Student " + studentId + " is already enrolled in " + name + ".");
        }
    }

    public void scheduleAssignment(String assignmentDetails) {
        assignments.add(assignmentDetails);
    }

    public void submitAssignment(String studentId, String assignmentDetails) {
        if (students.contains(studentId)) {
            submissions.computeIfAbsent(studentId, k -> new ArrayList<>()).add(assignmentDetails);
        } else {
            System.out.println("Student " + studentId + " is not enrolled in " + name + ".");
        }
    }
}
