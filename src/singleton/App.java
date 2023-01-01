package singleton;

public class App {
    public static void main(String[] args) {
        King king = King.getInstance();
        king.say();

        King king2 = King.getInstance();
        System.out.printf("king and king2 is %s\n", king == king2 ? "equals" : "not equals");
    }
}
