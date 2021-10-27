import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python",
                System.getProperty("user.dir") + "\\lib\\python\\main.py"
            );
            System.out.println(System.getProperty("user.dir") + "\\lib\\python\\main.py");
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String lines=null;
            System.out.println(reader.readLine());
            while ((lines=reader.readLine())!=null) {
                System.out.println("lines"+lines);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
