public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("  Welcome to Java 21 - Developer Environment     ");
        System.out.println("=================================================");
        
        // Friendly diagnostic of the running Java Virtual Machine (JVM)
        String javaVersion = System.getProperty("java.version");
        String osName = System.getProperty("os.name");
        long maxMemoryMb = Runtime.getRuntime().maxMemory() / (1024 * 1024);

        System.out.println("Java Runtime Version : " + javaVersion);
        System.out.println("Operating System     : " + osName);
        System.out.println("Allocated JVM Memory : " + maxMemoryMb + " MB");
        System.out.println("Toolchain Status     : Bytecode successfully verified and running!");
        System.out.println("=================================================");
        System.out.println("Hello, future software engineer! Your setup is ready.");
    }
}
