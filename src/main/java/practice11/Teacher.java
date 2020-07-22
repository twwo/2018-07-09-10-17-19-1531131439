package practice11;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person implements JoinListener, AssignedListener {
    private List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new LinkedList<>();
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        this.classes.forEach(klass -> {
            klass.joinListenerRegister(this);
            klass.assignedListenerRegister(this);
        });
    }

    public List<Klass> getClasses() {
        return classes;
    }

    public void setClasses(List<Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        StringBuilder introResult = new StringBuilder();
        introResult.append(super.introduce());
        if (!classes.isEmpty()) {
            introResult.append(" I am a Teacher. I teach Class ");
            List<Integer> classesNumberList = new ArrayList<>();
            classes.forEach(klass -> {
                classesNumberList.add(klass.getNumber());
            });
            introResult.append(Joiner.on(", ").join(classesNumberList));
            introResult.append(".");

        } else {
            introResult.append(" I am a Teacher. I teach No Class.");
        }
        return introResult.toString();
    }

    public boolean isTeaching(Student student) {
        for (Klass klass : classes) {
            if (klass.getStudentIdList().contains(student.getId())) {
                return true;
            }
        }
        return false;
    }

    public String introduceWith(Student student) {
        StringBuilder introResult = new StringBuilder();
        introResult.append(super.introduce());
        introResult.append(" I am a Teacher. I ");
        introResult.append(
                (isTeaching(student)) ? "" : "don't ");
        introResult.append("teach " + student.getName() + ".");
        return introResult.toString();
    }

    @Override
    public void joinUpdate(Student student) {
        System.out.print("I am "
                + this.getName() +
                ". I know " + student.getName() +
                " has joined Class " +
                student.getKlass().getNumber() +
                ".\n");
    }

    @Override
    public void assignedUpdate(Student student) {
        System.out.print("I am " +
                this.getName() +
                ". I know " +
                student.getName() +
                " become Leader of Class " +
                student.getKlass().getNumber() +
                ".\n");
    }

    public static void main(String[] args) {
        LinkedList<Klass> linkedList = new LinkedList<Klass>();
        Klass klass2 = new Klass(2);
        linkedList.add(klass2);
        Teacher tom = new Teacher(1, "Tom", 21, linkedList);
        Student jerry = new Student(1, "Jerry", 8, new Klass(3));
        klass2.appendMember(jerry);
        klass2.assignLeader(jerry);
    }
}
