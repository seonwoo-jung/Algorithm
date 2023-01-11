import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {

        // 주어진 단어들
        String[] parameter = {"worldhello", "helloworld"};
        // 아기가 할 수 있는 말
        String[] speakWord = {"hello", "world"};

        int answer = 0;

        System.out.println(parameter[0].indexOf(speakWord[0]));
    }
}
