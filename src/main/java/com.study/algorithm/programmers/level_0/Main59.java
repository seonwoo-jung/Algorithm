package programmers.level_0;

public class Main59 {

    public static void main(String[] args) {
        System.out.println(combination(5, 3));
    }

    static int combination(int balls, int share) {
        if (balls == share || share == 0) {
            return 1;
        }

        return combination((balls - 1), (share - 1)) + combination(balls - 1, share);
    }
}