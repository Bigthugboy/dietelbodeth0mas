package semicolon.africa.testing.data.model;


public enum Subject {
    MATHEMATICS(100),
    ENGLISH(100),
    PHYSIC(100),
    CHEMISTRY(100),
    BIOLOGY(100),
    AGRICULTURE(100),
    CIVIC(100),
    FURTHER_MATHEMATICS(100),
    TECHNICAL_DRAWING(100),
    LITERATURE_IN_ENGLISH(100),
    ECONOMICS(100),
    GOVERNMENT(100),
    HISTORY(100),
    COMMERCE(100),
    CRK(100),
    YORUBA(100);
    private final int grade;

    Subject(int grade) {
        this.grade = grade;

    }

    public int getGrade() {
        return grade;
    }
}
