package practice08;

public class Student extends Person{
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        StringBuilder introResult = new StringBuilder();
        introResult.append(super.introduce());
        if (klass.getLeader() == this) {
            introResult.append(" I am a Student. I am Leader of Class " + klass.getNumber() + ".");
        } else {
            introResult.append(" I am a Student. I am at Class " + klass.getNumber() + ".");
        }
        return introResult.toString();
    }
}
