package funcs.filesys.tex;

import java.util.ArrayList;
import java.util.List;

// Function for LaTeX implementation
public class TexFile {
    String name;
    List<String> options;
    List<String> args;
    StringBuilder command;
    public TexFile(String name, String... args) {
        this.name = name;
        this.options = new ArrayList<>();
        this.args = new ArrayList<>();
        for (String arg : args) {
            this.args.add(arg);
        }
    }
    public TexFile addOption(String option) {
        options.add(option);
        return this;
    }
    public void options(String... options) {
        for (String option : options) {
        this.options.add(option);
        }
    }
    @Override
    public String toString() {
        if(command==null) {
            command = new StringBuilder();
            command.append("\\"+name);
            if(name.equals("begin") || name.equals("end")) {
                command.append("");
            }
            else if(options.isEmpty()) {
                command.append("[]");
            } else {
                command.append("["+String.join(", ", options)+"]");
            }
            for(String arg : args) {
                command.append("{"+arg+"}");
            }
            command.append("\n");
        } 
        return command.toString();
    }
}
