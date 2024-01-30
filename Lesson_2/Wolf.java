public class Wolf {
    private char sex;
    private String nickName;
    // в кг
    private float weight;
    private int age;
    private String colour;

    // Методы геттеры и сеттеры
    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        //возраст волка не может быть > 8 лет
        if(age > 8) {
            System.out.println("Возраст волка не может быть больше 8 лет!");
        } else {
            this.age = age;
        }
    }

    // Методы, описывающие поведение (что он может делать) волка:
    // идти, сидеть, бежать, выть, охотиться
    public void go() {
        System.out.println("Идет!");
    }

    public void sit() {
        System.out.println("Сидит!");
    }

    public void run() {
        System.out.println("Бежит!");
    }

    public void howl() {
        System.out.println("Воет!");
    }

    public void hunt() {
        System.out.println("Охотится!");
    }
}
