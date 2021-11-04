import java.io.BufferedReader;
import java.io.InputStreamReader;

interface test {
    void set(String S);
}

public class App {
    void testdata(test fun, String S) {
        fun.set(S);
    }
    void mytest (String S) {
        System.out.println(S);
    }
    public static void main(String[] args) throws Exception {
        App L = new App();
        test func = L::mytest;
        L.testdata(func, "How are you");

        int dimension = 3;
        int coef = 1;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "python",
                System.getProperty("user.dir") + "\\lib\\python\\main.py", String.valueOf(dimension), String.valueOf(coef)
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
