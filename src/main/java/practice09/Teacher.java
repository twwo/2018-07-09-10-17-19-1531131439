package practice09;

public class Teacher extends Person {
    private Klass klass;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        klass = null;
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
        introResult.append(
                (klass != null) ?
                        " I am a Teacher. I teach Class " + klass.getNumber() + "." :
                        " I am a Teacher. I teach No Class.");
        return introResult.toString();
    }


    public String introduceWith(Student student) {
        StringBuilder introResult = new StringBuilder();
        introResult.append(super.introduce());
        introResult.append(" I am a Teacher. I ");
        introResult.append(
                (student.getKlass().getNumber() == klass.getNumber()) ? "" : "don't ");
        introResult.append("teach " + student.getName() + ".");
        return introResult.toString();
    }
}
