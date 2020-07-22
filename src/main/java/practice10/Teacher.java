package practice10;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Teacher extends Person {
    private List<Klass> classes;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        classes = new LinkedList<>();
    }

    public Teacher(int id, String name, int age, List<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
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
}
