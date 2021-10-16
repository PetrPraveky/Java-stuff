import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import funcs.Command;

public class App {
    public static void test1() {
        // setting up document template
        var docClass = new Command("documentclass", "article"); // --> \documentclass[]{article}
        docClass.addOption("10pt");
        System.out.println(docClass);
        // begin document
        var begindoc = new Command("begin", "document");
        System.out.println(begindoc);

        String text = """
                    Hello world! This is the java created document...
                    """;
        System.out.println(text);
        // end document
        var enddoc = new Command("end", "document");
        System.out.println(enddoc);
    }
    public static void main(String[] args) throws Exception {
        File newTex = new File("newTex.tex");
        if (!newTex.exists()) {
            newTex.createNewFile();
        } else {}
        PrintStream out = new PrintStream(new FileOutputStream(newTex), false);
        System.setOut(out);
        test1();
    }
}
