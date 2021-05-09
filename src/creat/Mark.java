package creat;

public class Mark {
    private float math;
    private float physics;
    private float chemistry;
    private float biology;
    private float english;
    private float computer;
    private float average;

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public Mark() {
    }

    public Mark(float math, float physics, float chemistry, float biology, float english, float computer, float average) {
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.biology = biology;
        this.english = english;
        this.computer = computer;
        this.average = average;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getPhysics() {
        return physics;
    }

    public void setPhysics(float physics) {
        this.physics = physics;
    }

    public float getChemistry() {
        return chemistry;
    }

    public void setChemistry(float chemistry) {
        this.chemistry = chemistry;
    }

    public float getBiology() {
        return biology;
    }

    public void setBiology(float biology) {
        this.biology = biology;
    }

    public float getEnglish() {
        return english;
    }

    public void setEnglish(float english) {
        this.english = english;
    }

    public float getComputer() {
        return computer;
    }

    public void setComputer(float computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "math=" + math +
                ", physics=" + physics +
                ", chemistry=" + chemistry +
                ", biology=" + biology +
                ", english=" + english +
                ", computer=" + computer +
                '}';
    }
}
