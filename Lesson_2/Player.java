public class Player {

    private String name;
    private int winsPoints = 0;

    // конструктор
    public Player(String name) {
        this.name = name;
        winsPoints = 0;
    }    

    // геттеры и сетторы
    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getWinsPoints() {
        return winsPoints;
    }

//    public void setWinsPoints(int winsPoints) {
//        this.winsPoints = winsPoints;
//    }

    public void addPoint() {
        winsPoints++;
    }

}