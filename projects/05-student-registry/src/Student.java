public class Student {
    private String name;
    private int id;
    private float marks;

    // Overloaded Constructor 1: initializes name and id, default marks to 0.0f
    public Student(String name, int id) {
        this(name, id, 0.0f);
    }

    // Overloaded Constructor 2: full parameter initialization
    public Student(String name, int id, float marks) {
        this.name = name;
        this.id = id;
        this.marks = Math.max(0.0f, marks);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public float getMarks() {
        return marks;
    }

    public float addMarks(float additionalMarks) {
        if (additionalMarks > 0.0f) {
            this.marks += additionalMarks;
        }
        return this.marks;
    }

    public boolean isPassing() {
        return this.marks >= 50.0f;
    }

    @Override
    public String toString() {
        return String.format("Student[ID=%d, Name='%s', Marks=%.2f, Status=%s]",
                id, name, marks, isPassing() ? "PASS" : "FAIL");
    }
}
