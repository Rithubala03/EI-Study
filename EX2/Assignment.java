import java.util.*;

public class Assignment {
    private String details;
    private Set<Submission> submissions;

    public Assignment(String details) {
        this.details = details;
        this.submissions = new HashSet<>();
    }

    public String getDetails() {
        return details;
    }

    public void addSubmission(Submission submission) {
        submissions.add(submission);
    }
}
