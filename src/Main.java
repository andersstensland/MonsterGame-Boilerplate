import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {


        ArrayList<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster(20, 2, 5));
        monsters.add(new Monster(35, 4, 9));
        monsters.add(new Boss(64, 7, 15));


        Player player = new Player(100, 8, 16);
    }
}