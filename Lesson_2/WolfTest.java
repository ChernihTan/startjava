public class WolfTest {
    public static void main(String[] args) {
        Wolf akela = new Wolf();
        akela.sex = 'К';
        akela.nickName = "Акела";
        akela.weight = 49.5f;
        akela.age = 15;
        akela.colour = "серый";
        System.out.println("Мы создали волка по кличке " + akela.nickName + ", возраст - " +
                 akela.age + (akela.age >= 5 ? " лет" : (akela.age == 1 ? " год" : " года")) +
                 "\nЭто " + (akela.sex == 'К' ? "волк" : "волчица") + " весом " +
                 akela.weight + " кг. Окрас - " + akela.colour + ".");
        System.out.println(akela.nickName + " сейчас:");
        akela.hunt();
        akela.run();
        System.out.println("Вечером " + akela.nickName + ":");
        akela.sit();
        akela.howl();

        Wolf raksha = new Wolf();
        raksha.sex = 'С';
        raksha.nickName = "Ракша";
        raksha.weight = 42.5f;
        raksha.age = 3;
        raksha.colour = "серый";
        System.out.println("\nМы создали волка по кличке " + raksha.nickName + ", возраст - " +
                 raksha.age + (raksha.age >= 5 ? " лет" : (raksha.age == 1 ? " год" : " года")) +
                 "\nЭто " + (raksha.sex == 'К' ? "волк" : "волчица") + " весом " +
                 raksha.weight + " кг. Окрас - " + raksha.colour + ".");
        System.out.println(raksha.nickName + " сейчас:");
        raksha.go();
        raksha.hunt();
        System.out.println("Вечером " + raksha.nickName + ":");
        raksha.sit();
        raksha.howl();
    }
}

public class Wolf {
    // Поля (атрибуты), описывающие характеристики волка
    //пол, кличка, вес, возраст, окрас
    char sex;
    String nickName;
    // вес в кг
    float weight;
    int age;
    String colour;

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
/*Создайте класс Wolf
объявите в нем поля: пол, кличка, вес, возраст, окрас (не присваивайте им значения по умолчанию)
реализуйте методы: идти, сидеть, бежать, выть, охотиться
в каждом методе выводите сообщение вида: "Воет", "Сидит" и т. д.
Создайте класс WolfTest с методом main
в нем создайте объект типа Wolf
в этом же классе присвойте полям Wolf какие-то значения
получите эти значения из полей и отобразите в консоли
вызовите методы объекта
*/


