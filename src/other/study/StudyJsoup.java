package other.study;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

import java.io.IOException;

public class StudyJsoup {
    public static void main(String[] args) throws IOException {
        Response execute = Jsoup.connect("https://www.naver.com").execute();
    }
}
