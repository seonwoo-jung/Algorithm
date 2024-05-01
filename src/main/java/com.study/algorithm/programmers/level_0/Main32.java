package programmers.level_0;

public class Main32 {
    public static void main(String[] args) {
        String[][] db = {
                            {"rardss", "123"},
                            {"yyoom", "1234"},
                            {"meosseugi", "1234"},
                            {"meosseugi", "1234"},
                            {"meosseugi", "1234"},
                            {"meosseugi", "1234"},
                            {"meosseugi", "1234"},
                            {"meosseugi", "1234"},
                            {"meosseugi", "1234"},
                            {"meosseugi", "1234"}
                        };
        String[] id_pw = {"meosseugii", "12345"};
        System.out.println(solution(id_pw, db));
    }

    static String solution(String[] id_pw, String[][] db) {

        String answer = "";

        for (int k = 0; k < db.length; k++) {
            if (id_pw[0].equals(db[k][0]) && id_pw[1].equals(db[k][1])) {
                return answer = "login";
            } else if (id_pw[0].equals(db[k][0]) && !id_pw[1].equals(db[k][1])) {
                return answer = "wrong pw";
            }
        }
        return "fail";
    }
}
