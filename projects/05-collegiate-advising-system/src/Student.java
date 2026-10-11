public class Student {
    private int id;
    private String name;
    private String major;
    private double gpa;
    private int creditsEarned;

    // Overloaded Constructor 1: Common default initialization
    public Student(String name, int id) {
        this(name, id, "Computer Science & AI", 0.0, 0);
    }

    // Overloaded Constructor 2: Full parameter initialization
    public Student(String name, int id, String major, double gpa, int creditsEarned) {
        this.name = (name != null && !name.trim().isEmpty()) ? name.trim() : "Unknown Student";
        this.id = id;
        this.major = (major != null && !major.trim().isEmpty()) ? major.trim() : "Undeclared";
        this.gpa = Math.max(0.0, Math.min(4.0, gpa)); // bounded between 0.0 and 4.0
        this.creditsEarned = Math.max(0, creditsEarned);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getGpa() {
        return gpa;
    }

    public int getCreditsEarned() {
        return creditsEarned;
    }

    public void updateGpa(double newGpa) {
        this.gpa = Math.max(0.0, Math.min(4.0, newGpa));
    }

    public void addCredits(int additionalCredits) {
        if (additionalCredits > 0) {
            this.creditsEarned += additionalCredits;
        }
    }

    // Evaluates academic standing based on collegiate GPA standards
    public String getAcademicStanding() {
        if (gpa >= 3.5) {
            return "Dean's List (Honors)";
        } else if (gpa >= 2.0) {
            return "Good Standing";
        } else {
            return "Academic Probation";
        }
    }

    public boolean isGraduationEligible() {
        return creditsEarned >= 120 && gpa >= 2.0;
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%d, Name='%-15s', Major='%-22s', GPA=%.2f, Credits=%3d, Standing='%s']",
                id, name, major, gpa, creditsEarned, getAcademicStanding());
    }
}
