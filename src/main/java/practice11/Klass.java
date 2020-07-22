package practice11;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Integer> studentIdList;
    private List<JoinListener> joinListenerList;
    private List<AssignedListener> assignedListenerList;

    public Klass(int number) {
        this.number = number;
        studentIdList = new ArrayList<>();
        this.leader = null;
        joinListenerList = new ArrayList<>();
        assignedListenerList = new ArrayList<>();
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
            assignedListenerList.forEach(assignedListener -> {
                assignedListener.assignedUpdate(leader);
            });
        } else {
            System.out.print("It is not one of us.\n");
        }
    }

    public void appendMember(Student student) {
        studentIdList.add(student.getId());
        student.getKlass().setNumber(this.getNumber());
        joinListenerList.forEach(joinListener -> {
            joinListener.joinUpdate(student);
        });
    }

    public void joinListenerRegister(JoinListener joinListener) {
        joinListenerList.add(joinListener);
    }

    public void assignedListenerRegister(AssignedListener assignedListener) {
        assignedListenerList.add(assignedListener);
    }
}
