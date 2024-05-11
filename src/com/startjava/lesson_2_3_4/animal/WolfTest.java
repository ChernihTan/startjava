package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf akela = new Wolf();
        akela.setSex('К');
        akela.setNickName("Акела");
        akela.setWeight(49.5f);
        akela.setAge(15);
        akela.setColour("серый");
        System.out.println("Мы создали волка по кличке " + akela.getNickName() + ", возраст - " +
                 akela.getAge() + (akela.getAge() >= 5 ? " лет" : (akela.getAge() == 1 ? " год" : " года")) +
                 "\nЭто " + (akela.getSex() == 'К' ? "волк" : "волчица") + " весом " +
                 akela.getWeight() + " кг. Окрас - " + akela.getColour() + ".");
        System.out.println(akela.getNickName() + " сейчас:");
        akela.hunt();
        akela.run();
        System.out.println("Вечером " + akela.getNickName() + ":");
        akela.sit();
        akela.howl();

        Wolf raksha = new Wolf();
        raksha.setSex('С');
        raksha.setNickName("Ракша");
        raksha.setWeight(42.5f);
        raksha.setAge(3);
        raksha.setColour("серый");
        System.out.println("\nМы создали волка по кличке " + raksha.getNickName() + ", возраст - " +
                 raksha.getAge() + (raksha.getAge() >= 5 ? " лет" : (raksha.getAge() == 1 ? " год" : " года")) +
                 "\nЭто " + (raksha.getSex() == 'К' ? "волк" : "волчица") + " весом " +
                 raksha.getWeight() + " кг. Окрас - " + raksha.getColour() + ".");
        System.out.println(raksha.getNickName() + " сейчас:");
        raksha.go();
        raksha.hunt();
        System.out.println("Вечером " + raksha.getNickName() + ":");
        raksha.sit();
        raksha.howl();
    }
}
