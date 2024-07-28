import java.util.*;
public class CodeAlpha_Student_grade_tracker {
    static class Student{
        HashMap<String, ArrayList<Double>> stud;
        public Student(){
            stud = new HashMap<>();
        }
        
        //add new student
        public void addStudent(String name){
            if (!stud.containsKey(name)){
                stud.put(name, new ArrayList<>());
                System.out.println("Student added");
            }
            else{
                System.out.println(name + "already exists");
            }
        }

        //add grades
        public void addGrades(String name, double grade){
            if (!stud.containsKey(name)){
                System.out.println(name + "not found");
            }
            else{
                stud.get(name).add(grade);
                System.out.println("Grades added");
            }
        }

        //get average
        public double average(String name){
            double sum = 0;
            if (!stud.containsKey(name)){
                System.out.println(name + " not found");
                return 0.0;
            }
            else{
                for (int i=0; i < stud.get(name).size(); i++){
                    sum += stud.get(name).get(i);
                }
            }
            return sum/(stud.get(name).size());
        }

        //get lowest mark
        public double lowestMarks(String name){
            PriorityQueue<Double> pq = new PriorityQueue<>();
            if (!stud.containsKey(name)){
                System.out.println(name + " not found");
                return 0.0;
            }
            else{
                for (int i=0; i < stud.get(name).size(); i++){
                    pq.add(stud.get(name).get(i));
                } 
            }
            return pq.peek();
        }

        //get highest marks
        public double highestMarks(String name){
            PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
            if (!stud.containsKey(name)){
                System.out.println(name + " not found");
                return 0.0;
            }
            else{
                for (int i=0; i < stud.get(name).size(); i++){
                    pq.add(stud.get(name).get(i));
                } 
            }
            return pq.peek();
        }

        //display all grades of a student
        public void display(String name){
            if (!stud.containsKey(name)){
                System.out.println(name + " not found");
            }
            else{
                System.out.print(name + " : ");
                for (int i=0; i < stud.get(name).size(); i++){
                    System.out.print(stud.get(name).get(i) + "  ");
                }
            }
            System.out.println();
        }

        //display all grades of all student
        public void displayAll(){
            System.out.println("******All Student Details******");
            Set<String> keySet = stud.keySet();
            for (String key : keySet){
                System.out.print(key + " : ");
                for (int i=0; i < stud.get(key).size(); i++){
                    System.out.print(stud.get(key).get(i) + "  ");
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        //Implementation 
        Student students = new Student();
        students.addStudent("xyz");
        students.addGrades("xyz", 100);
        students.addGrades("xyz", 90);
        students.addGrades("xyz", 99);
        students.addStudent("Abc");
        students.addGrades("Abc", 70);
        students.addGrades("Abc", 0);
        students.addGrades("Abc", 10);
        students.addGrades("Abc", 60);
        System.out.println("Average of marks = " + students.average("xyz"));
        System.out.println("Average of marks = " + students.average("Abc"));
        System.out.println("Average of marks = " + students.average("As"));
        System.out.println("Highest marks= " + students.highestMarks("xyz"));
        System.out.println("Lowest marks= " + students.lowestMarks("xyz"));
        students.display("xyz");
        students.displayAll();
    }
}
