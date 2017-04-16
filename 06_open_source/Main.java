import java.io.*;
import java.util.*;

class Project implements Comparable<Project>{
    private String name;
    private int counter;

    public Project(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public int compareTo(Project o) {
        if(this.counter>o.getCounter()){
            return 1;
        }
        if(this.counter<o.getCounter()){
            return -1;
        }else{
            if(this.name.compareTo(o.getName())>-1){
                return -1;
            }else{
                return 1;
            }
        }
    }
}

public class Main {

  public static void main(String[] args) throws IOException {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    boolean end = false;
    String line = "a";
    while (true) {
      String currentProject = "";
      String currentStudent = "";
      String last = "";
      HashMap<String, Integer> projects = new HashMap<String, Integer>();
      HashMap<String, String> students = new HashMap<String, String>();
      LinkedList<String> projectList = new LinkedList<String>();
      

      while (true) {
        line = br.readLine();
        if (line.equals("1")) break;

        if (line.equals("0")) {
          end = true;
          break;
        }
        
        // if it is a student
        else if (Character.isLowerCase(line.charAt(0))) {
          currentStudent = line;
          if (!students.containsKey(currentStudent)) {
            students.put(currentStudent, last);
            int temp = projects.get(last) + 1;
            projects.put(last, temp);
          }
          else {
            String temp = students.get(currentStudent);
            if (temp.equals(last) || temp.equals("ban")) {
              continue;
            }
            int proj_new = projects.get(temp) - 1;
            projects.put(temp, proj_new);
            students.put(currentStudent, "ban");
          }
        }

        // if it is a project
        if (Character.isUpperCase(line.charAt(0))) {
          currentProject = line;
          if (!projects.containsKey(currentProject)) {
            projects.put(currentProject, 0);
            projectList.add(currentProject);
          }
          last = currentProject;
        } 
      }

      if (end) {
        break;
      }

      LinkedList<Project> output = new LinkedList<Project>();
      while(!projectList.isEmpty()){
          String name = projectList.remove();
          int counter = projects.get(name);
          output.add(new Project(name, counter));
      }
      Collections.sort(output);
      while(!output.isEmpty()){
          Project p = output.removeLast();
          System.out.printf("%s %d\n", p.getName(), p.getCounter());
      }
    }
  }
}