package practice06;

public class Teacher extends Person {
    private Integer klass;

    public Teacher(String name, int age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
        klass = null;
    }

    public Integer getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        StringBuilder introResult = new StringBuilder();
        introResult.append(super.introduce());
        introResult.append(
                (klass != null) ? " I am a Teacher. I teach Class " + klass + "." : " I am a Teacher. I teach No Class.");
        return introResult.toString();
    }
}
