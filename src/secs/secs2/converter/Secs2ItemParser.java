package secs.secs2.converter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * byte 배열을 받아서 대응되는 타입을 체크
 */
public class Secs2ItemParser {

    public void parse(InputStream is) throws IOException {
        int buffer;

        while((buffer = is.read()) != -1) {
            // format code 획득
            int formatCode = getItemFormatCode(buffer);
            // byte 크기 획득
            int byteSize = getByteSize(buffer);

            byte[] lengthBytes = new byte[byteSize];
            if(is.read(lengthBytes) != byteSize) break;

            // 아이템의 실제 길이 획득
            int itemLength = getItemLength(lengthBytes);

            // 실제 아이템 파싱. item format code + 실제 길이 기반으로 파싱 수행.
        }
    }

    /**
     * ItemFormatCode 부분을 파싱하는 메서드
     * @param data
     * @return
     */
    public int getItemFormatCode(int data) {
        final int itemFormatCodeMask = 0b11111100;
        return (data & itemFormatCodeMask) >> 2;
    }

    public int getByteSize(int data) {
        return data & 0b00000011;
    }

    public int getItemLength(byte[] lengthBytes) {
        return ByteBuffer.wrap(lengthBytes).getInt();
    }


    public String getType(int data) {
        return switch (data) {
            case 000 -> "L"; // list
            case 010 -> "B"; // binary
            case 011 -> "BOOLEAN"; // boolean
            case 020 -> "A"; // ascii
            case 021 -> "J"; // JIS-8
            case 012 -> "CHAR"; // 2byte char
            case 030 -> "I8"; // 8byte integer
            case 031 -> "I1"; // 1byte integer
            case 032 -> "I2"; // 2byte integer
            case 034 -> "I4"; // 4byte integer
            case 040 -> "F8"; // 8byte float
            case 044 -> "F4"; // 4byte float
            case 050 -> "U8"; // 8byte uint
            case 051 -> "I1"; // 1byte uint
            case 052 -> "I2"; // 2byte uint
            case 054 -> "I4"; // 4byte uint
            default -> throw new RuntimeException("not supported");
        };
    }
}
