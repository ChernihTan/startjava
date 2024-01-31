public class Jaeger {

    private String modelName; //= "Bracer Phoenix";
    private String mark;    //= "Mark-5";
    private String origin;  // = "USA";
    private float height;   // = 70.7f;
    private float weight;   // = 2.1f;
    private int strength;   // = 8;   // сила
    private int armor;      // = 9;      // броня
    private String modelNameRus;
    static int count = 0;

    // конструкторы
    public Jaeger() {
        count++;
        modelName = "unknown" + count; 
    }

    // конструктор, где указана последовательность 2 параметров
    public Jaeger(String modelName, String mark) {
        this.modelName = modelName;
        this.mark = mark;
    }

    // конструктор, где указаны все параметры 
    public Jaeger(String modelName, String mark,
            String origin, float height,
            float weight, int strength, int armor) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.height = height;
        this.weight = weight;
        this.strength = strength;
        this.armor = armor;
    }

    //геттеры и сеттеры
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getModelNameRus() {
        return modelNameRus;
    }

    public void setModelNameRus(String modelNameRus) {
        this.modelNameRus = modelNameRus;
    }


    boolean drift() {
        return true;
    }

    void move() {
        System.out.println("moving");
    }

    String scanKaiju() {
        return "scanning";
    }

    void useVortexCannon() {
        System.out.println("activated");
    }
}
