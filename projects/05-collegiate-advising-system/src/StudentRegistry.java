public class StudentRegistry {
    private Student[] students;
    private int count;

    public StudentRegistry(int capacity) {
        this.students = new Student[capacity];
        this.count = 0;
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            System.out.println("Registration Error: Cannot add null student reference.");
            return false;
        }
        if (count >= students.length) {
            System.out.println("Registration Error: Registry reached capacity limit (" + students.length + ").");
            return false;
        }
        if (findById(student.getId()) != null) {
            System.out.println("Registration Error: Student ID " + student.getId() + " is already enrolled.");
            return false;
        }
        students[count] = student;
        count++;
        return true;
    }

    public Student findById(int id) {
        // Safe linear search: scan strictly up to active count
        for (int i = 0; i < count; i++) {
            if (students[i] != null && students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    public void filterByMajor(String majorQuery) {
        System.out.println("\n--- Students Filtered by Major: '" + majorQuery + "' ---");
        int found = 0;
        for (int i = 0; i < count; i++) {
            if (students[i] != null && students[i].getMajor().equalsIgnoreCase(majorQuery.trim())) {
                System.out.println(students[i]);
                found++;
            }
        }
        if (found == 0) {
            System.out.println("No registered students found for major: " + majorQuery);
        }
    }

    public Student getTopStudent() {
        if (count == 0) {
            return null;
        }
        Student top = students[0];
        for (int i = 1; i < count; i++) {
            if (students[i] != null && students[i].getGpa() > top.getGpa()) {
                top = students[i];
            }
        }
        return top;
    }

    public void listAll() {
        if (count == 0) {
            System.out.println("The student registry is currently empty.");
            return;
        }
        System.out.println("\n--- Registered Students (" + count + "/" + students.length + ") ---");
        for (int i = 0; i < count; i++) {
            if (students[i] != null) {
                System.out.println((i + 1) + ". " + students[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     Campus Student Academic Registry System     ");
        System.out.println("=================================================");

        StudentRegistry registry = new StudentRegistry(6);

        // Constructor overloading demonstration
        Student s1 = new Student("Alice Walker", 101); // 2-arg constructor (defaults major & GPA)
        Student s2 = new Student("Bob Stone", 102, "Computer Science & AI", 3.85, 90);
        Student s3 = new Student("Charlie Brown", 103, "Information Systems", 1.85, 45);
        Student s4 = new Student("Diana Prince", 104, "Data Science", 3.95, 125);

        System.out.println("\n--- Enrolling Students into Registry ---");
        registry.addStudent(s1);
        registry.addStudent(s2);
        registry.addStudent(s3);
        registry.addStudent(s4);

        // Mutating student records via public instance methods
        System.out.println("\n--- Updating Student Alice Academic Record ---");
        System.out.println("Initial  : " + s1);
        s1.updateGpa(3.60);
        s1.addCredits(30);
        System.out.println("Updated  : " + s1);

        // Listing all registered students
        registry.listAll();

        // Querying student records
        System.out.println("\n--- Querying by ID ---");
        Student query1 = registry.findById(102);
        System.out.println("Lookup ID 102: " + (query1 != null ? query1 : "Not Found"));

        Student queryMissing = registry.findById(999);
        System.out.println("Lookup ID 999: " + (queryMissing != null ? queryMissing : "Not Found"));

        // Filtering by Major
        registry.filterByMajor("Computer Science & AI");

        // Top GPA Student
        System.out.println("\n--- Valedictorian / Highest GPA Honor ---");
        Student valedictorian = registry.getTopStudent();
        System.out.println("Top Performing Student: " + valedictorian);

        // Null Safety Demonstration on Object Arrays
        System.out.println("\n--- Object Array Null-Safety Demonstration ---");
        System.out.println("Array Capacity : " + registry.students.length);
        System.out.println("Enrolled Count : " + registry.count);
        System.out.println("Slot [5] value : " + registry.students[5] + " (unassigned slot)");

        // Safe defensive check against NullPointerException
        if (registry.students[5] == null) {
            System.out.println("Verified: Slot [5] is null. Skipping method calls prevents NullPointerException.");
        }

        // ==============================================================
        // TODO: Practice Challenge For You
        // 1. Add a removeStudent(int id) method that deletes a student and shifts remaining array elements leftward.
        // 2. Add a countStanding(String standingType) method to count how many students are on Dean's List.
        // ==============================================================
    }
}
