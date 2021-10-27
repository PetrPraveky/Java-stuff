import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        int dimension = 3;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python",
                System.getProperty("user.dir") + "\\lib\\python\\main.py", String.valueOf(dimension)
            );
            System.out.println(System.getProperty("user.dir") + "\\lib\\python\\main.py");
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            // String lines=null;
            System.out.println(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
