public class JaegerTest {
        public static void main(String[] args) {
        //для инициализации полей объектов используйте
        // для первого робота сеттеры

        // Страйкер Эврика   
        Jaeger jaegerOne = new Jaeger();
        jaegerOne.setModelName("Striker Eureka");  // Страйкер Эврика
        jaegerOne.setMark("Mark-5");
        jaegerOne.setOrigin("Australia");
        jaegerOne.setHeight(76.2f);
        jaegerOne.setWeight(2087f);
        jaegerOne.setStrength(10);
        jaegerOne.setArmor(9);
        jaegerOne.setModelNameRus("Страйкер Эврика");

        System.out.println("Создан егерь " + jaegerOne.getModelNameRus() + " или " +
                jaegerOne.getModelName() + " поколение - " + jaegerOne.getMark() +
                ".\nСтрана производитель - " +  jaegerOne.getOrigin() +
                ",\nвысота робота - " + jaegerOne.getHeight() +
                " метров, вес робота - " + jaegerOne.getWeight() + " тонн.\n" + 
                "Технические характеристики: сила - " + jaegerOne.getStrength() +
                ", броня - " + jaegerOne.getArmor() + ".");

        // "Бродяга или Цыганская опасность"
        Jaeger jaegerSecond = new Jaeger("Gipsy Danger", "Mark-3",
                "United States of America", 79.25f, 1980f, 8, 6);
        jaegerSecond.setModelNameRus("Бродяга(Цыганская опасность)");
        System.out.println("\nСоздан егерь " + jaegerSecond.getModelNameRus() +
                " или " + jaegerSecond.getModelName() +
                " поколение - " + jaegerSecond.getMark() + ".\nСтрана производитель - " + 
                jaegerSecond.getOrigin() + ",\nвысота робота - " + jaegerSecond.getHeight() +
                " метров, вес робота - " + jaegerSecond.getWeight() + " тонн.\n" + 
                "Технические характеристики: сила - " + jaegerSecond.getStrength() +
                ", броня - " + jaegerSecond.getArmor() + ".\n");        

        if(jaegerOne.getHeight() > jaegerSecond.getHeight()) {
            System.out.print(jaegerOne.getModelName());
        } else {
            System.out.print(jaegerSecond.getModelName());
        }
        System.out.println(" более высокий.");

        if(jaegerOne.getStrength() > jaegerSecond.getStrength()) {
            System.out.print(jaegerOne.getModelName());
        } else {
            System.out.print(jaegerSecond.getModelName());
        }
        System.out.println(" сильнее.");
    }
}