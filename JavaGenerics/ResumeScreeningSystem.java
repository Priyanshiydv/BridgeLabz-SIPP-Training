import java.util.*;

// === Step 1: Define Abstract Base Class for Job Roles ===
abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    // Abstract method to define required skill match
    public abstract boolean isEligible();

    public abstract String getRoleName();

    @Override
    public String toString() {
        return getRoleName() + " Candidate: " + candidateName + " | Experience: " + experienceYears + " years";
    }
}

// === Step 2: Subclasses for Specific Job Roles ===

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public boolean isEligible() {
        return getExperienceYears() >= 2;
    }

    @Override
    public String getRoleName() {
        return "Software Engineer";
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public boolean isEligible() {
        return getExperienceYears() >= 3;
    }

    @Override
    public String getRoleName() {
        return "Data Scientist";
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }

    @Override
    public boolean isEligible() {
        return getExperienceYears() >= 5;
    }

    @Override
    public String getRoleName() {
        return "Product Manager";
    }
}

// === Step 3: Generic Resume Class ===
class Resume<T extends JobRole> {
    private T jobRole;

    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void display() {
        System.out.println(jobRole);
    }
}

// === Step 4: Screening Utility Class ===
class ResumeScreening {

    // Generic method to screen a single resume
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        T role = resume.getJobRole();
        System.out.println("Screening " + role.getRoleName() + " resume of " + role.getCandidateName());
        if (role.isEligible()) {
            System.out.println("✅ Eligible for " + role.getRoleName());
        } else {
            System.out.println("❌ Not Eligible for " + role.getRoleName());
        }
    }

    // Wildcard method to screen a list of any job roles
    public static void screenMultipleResumes(List<? extends JobRole> roles) {
        System.out.println("\n--- Batch Screening Start ---");
        for (JobRole role : roles) {
            System.out.println("-> " + role);
            if (role.isEligible()) {
                System.out.println("   ✅ Eligible");
            } else {
                System.out.println("   ❌ Not Eligible");
            }
        }
        System.out.println("--- Batch Screening End ---\n");
    }
}

// === Step 5: Main Class to Test the System ===
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Individual resume screening
        Resume<SoftwareEngineer> seResume = new Resume<>(new SoftwareEngineer("Alice", 3));
        Resume<DataScientist> dsResume = new Resume<>(new DataScientist("Bob", 2));
        Resume<ProductManager> pmResume = new Resume<>(new ProductManager("Charlie", 6));

        // Screen individually
        ResumeScreening.screenResume(seResume);
        ResumeScreening.screenResume(dsResume);
        ResumeScreening.screenResume(pmResume);

        // Add to batch list for wildcard method
        List<JobRole> resumeList = new ArrayList<>();
        resumeList.add(seResume.getJobRole());
        resumeList.add(dsResume.getJobRole());
        resumeList.add(pmResume.getJobRole());
        resumeList.add(new SoftwareEngineer("David", 1)); // Not eligible
        resumeList.add(new DataScientist("Eva", 4));       // Eligible

        // Batch screening using wildcard
        ResumeScreening.screenMultipleResumes(resumeList);
    }
}
