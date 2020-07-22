package practice10;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Integer> studentIdList;

    public Klass(int number) {
        this.number = number;
        studentIdList = new ArrayList<>();
        this.leader = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Integer> getStudentIdList() {
        return studentIdList;
    }

    public void setStudentIdList(List<Integer> studentIdList) {
        this.studentIdList = studentIdList;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public String getDisplayName() {
        return "Class " + number;
    }

    public void assignLeader(Student leader) {
        if (studentIdList.contains(leader.getId())) {
            this.leader = leader;
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student) {
        studentIdList.add(student.getId());
    }
}
