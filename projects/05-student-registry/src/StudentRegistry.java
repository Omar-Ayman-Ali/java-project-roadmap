public class StudentRegistry {
    private Student[] students;
    private int count;

    public StudentRegistry(int capacity) {
        this.students = new Student[capacity];
        this.count = 0;
    }

    public boolean addStudent(Student student) {
        if (student == null) {
            System.out.println("Error: Cannot add null student reference.");
            return false;
        }
        if (count >= students.length) {
            System.out.println("Error: Registry is at maximum capacity (" + students.length + ").");
            return false;
        }
        if (findById(student.getId()) != null) {
            System.out.println("Error: Student with ID " + student.getId() + " already exists.");
            return false;
        }
        students[count] = student;
        count++;
        return true;
    }

    public Student findById(int id) {
        // Safe iteration: check count or verify element != null
        for (int i = 0; i < count; i++) {
            if (students[i] != null && students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
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

    public Student getTopStudent() {
        if (count == 0) {
            return null;
        }
        Student top = students[0];
        for (int i = 1; i < count; i++) {
            if (students[i] != null && students[i].getMarks() > top.getMarks()) {
                top = students[i];
            }
        }
        return top;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("       Student Registry System (L02)     ");
        System.out.println("=========================================");

        StudentRegistry registry = new StudentRegistry(5);

        // Constructor overloading demonstration
        Student s1 = new Student("Alice Walker", 101); // 2-arg constructor
        Student s2 = new Student("Bob Stone", 102, 78.5f); // 3-arg constructor
        Student s3 = new Student("Charlie Brown", 103, 44.0f);
        Student s4 = new Student("Diana Prince", 104, 91.5f);

        System.out.println("\n--- Adding Students to Registry ---");
        registry.addStudent(s1);
        registry.addStudent(s2);
        registry.addStudent(s3);
        registry.addStudent(s4);

        // Manipulating student marks via dot operator
        System.out.println("\n--- Updating Student Marks ---");
        System.out.println("Initial Alice status: " + s1);
        s1.addMarks(62.0f);
        System.out.println("Updated Alice status: " + s1);

        // Listing all students
        registry.listAll();

        // Finding student by ID
        System.out.println("\n--- Finding Student by ID ---");
        Student found = registry.findById(102);
        System.out.println("Lookup ID 102: " + (found != null ? found : "Not found"));

        Student missing = registry.findById(999);
        System.out.println("Lookup ID 999: " + (missing != null ? missing : "Not found"));

        // Top performing student
        System.out.println("\n--- Top Performing Student ---");
        Student top = registry.getTopStudent();
        System.out.println("Top student: " + top);

        // Demonstrating safe handling of uninitialized array slots (null safety)
        System.out.println("\n--- Object Array Null-Safety Demonstration ---");
        System.out.println("Array length: " + registry.students.length);
        System.out.println("Active count: " + registry.getCount());
        System.out.println("Slot [4] holds: " + registry.students[4]); // Unallocated slot is null

        try {
            // Unsafe direct dereference on null slot throws NullPointerException
            if (registry.students[4] == null) {
                System.out.println("Safe check: Slot [4] is null, skipping method call to prevent NullPointerException.");
            }
        } catch (NullPointerException e) {
            System.out.println("Caught unexpected NullPointerException.");
        }
    }
}
