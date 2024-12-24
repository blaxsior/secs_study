import secs.secs2.converter.Secs2ItemParser;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        var parser = new Secs2ItemParser();
        byte[] data = {-111, 1, 64, 73, 31, -73};


        ByteArrayInputStream bis = new ByteArrayInputStream(data);

        var item = parser.parse(bis);
        System.out.println(item);
    }
}