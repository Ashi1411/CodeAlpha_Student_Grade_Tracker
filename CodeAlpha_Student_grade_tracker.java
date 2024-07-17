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

        //display all grades of a all student
        public void displayAll(){
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
        Student students = new Student();
        students.addStudent("Ashi");
        students.addGrades("Ashi", 100);
        students.addGrades("Ashi", 90);
        students.addGrades("Ashi", 99);
        students.addStudent("Abc");
        students.addGrades("Abc", 70);
        students.addGrades("Abc", 0);
        students.addGrades("Abc", 10);
        students.addGrades("Abc", 60);
        System.out.println(students.average("Ashi"));
        System.out.println(students.average("Abc"));
        System.out.println(students.average("As"));
        System.out.println(students.highestMarks("Ashi"));
        System.out.println(students.lowestMarks("Ashi"));
        students.display("Ashi");
        students.displayAll();
    }
}
