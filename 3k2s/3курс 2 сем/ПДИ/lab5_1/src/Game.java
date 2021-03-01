import java.util.*;

/**
 * Created by Nikich on 21.04.2016.
 */
public class Game {
    private static ArrayList<Integer> PlayerMoves = new ArrayList<>();
    private static ArrayList<Integer> CompMoves = new ArrayList<>();

    public static void gamerMove(int number) {
        PlayerMoves.add(number);
    }

    public static void compMove() {
        Random random = new Random();

        while (true) {
            int field = random.nextInt(9);
            if (PlayerMoves.contains(field) || CompMoves.contains(field)) {
                continue;
            } else {
                CompMoves.add(field);
                break;
            }
        }
    }

    public static int checkField(int number) {
        if (PlayerMoves.contains(number)) return 1;
        if (CompMoves.contains(number)) return 2;
        return 3;
    }

    public static int checkEndGame() {
        if(PlayerMoves.contains(0) && PlayerMoves.contains(1) && PlayerMoves.contains(2)) return 1;
        if(PlayerMoves.contains(1) && PlayerMoves.contains(4) && PlayerMoves.contains(7)) return 1;
        if(PlayerMoves.contains(3) && PlayerMoves.contains(4) && PlayerMoves.contains(5)) return 1;
        if(PlayerMoves.contains(0) && PlayerMoves.contains(3) && PlayerMoves.contains(6)) return 1;
        if(PlayerMoves.contains(0) && PlayerMoves.contains(4) && PlayerMoves.contains(8)) return 1;
        if(PlayerMoves.contains(2) && PlayerMoves.contains(5) && PlayerMoves.contains(8)) return 1;
        if(PlayerMoves.contains(2) && PlayerMoves.contains(4) && PlayerMoves.contains(6)) return 1;
        if(PlayerMoves.contains(6) && PlayerMoves.contains(7) && PlayerMoves.contains(8)) return 1;

        if(CompMoves.contains(0) && CompMoves.contains(1) && CompMoves.contains(2)) return 2;
        if(CompMoves.contains(1) && CompMoves.contains(4) && CompMoves.contains(7)) return 2;
        if(CompMoves.contains(3) && CompMoves.contains(4) && CompMoves.contains(5)) return 2;
        if(CompMoves.contains(0) && CompMoves.contains(3) && CompMoves.contains(6)) return 2;
        if(CompMoves.contains(0) && CompMoves.contains(4) && CompMoves.contains(8)) return 2;
        if(CompMoves.contains(2) && CompMoves.contains(5) && CompMoves.contains(8)) return 2;
        if(CompMoves.contains(2) && CompMoves.contains(4) && CompMoves.contains(6)) return 2;
        if(CompMoves.contains(6) && CompMoves.contains(7) && CompMoves.contains(8)) return 2;

        if((PlayerMoves.contains(0) || CompMoves.contains(0)) &&
                        (PlayerMoves.contains(1) || CompMoves.contains(1)) &&
                        (PlayerMoves.contains(2) || CompMoves.contains(2)) &&
                        (PlayerMoves.contains(3) || CompMoves.contains(3)) &&
                        (PlayerMoves.contains(4) || CompMoves.contains(4)) &&
                        (PlayerMoves.contains(5) || CompMoves.contains(5)) &&
                        (PlayerMoves.contains(6) || CompMoves.contains(6)) &&
                        (PlayerMoves.contains(7) || CompMoves.contains(7)) &&
                        (PlayerMoves.contains(8) || CompMoves.contains(8))
                ) {
            return 3;
        }
        return 0;
    }

    public static void restart(){
        PlayerMoves.clear();
        CompMoves.clear();
    }
}
