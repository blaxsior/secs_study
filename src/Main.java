import secs.secs2.converter.Secs2ItemParser;

public class Main {
    public static void main(String[] args) {
        var parser = new Secs2ItemParser();
        byte data = 0b01000010;

        int result = parser.getItemFormatCode(data);

        System.out.println(result);
        System.out.println(parser.getType(result));
        System.out.println(Integer.toBinaryString(result));
        System.out.println(Integer.toOctalString(result));
    }
}