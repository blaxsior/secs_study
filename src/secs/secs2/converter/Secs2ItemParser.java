package secs.secs2.converter;

import secs.secs2.datatype.enums.SECS2ItemEnum;
import secs.secs2.datatype.types.SECS2ItemValue;
import secs.secs2.datatype.types.SECS2List;
import secs.secs2.datatype.types.core.ISECS2ItemType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * byte 배열을 받아서 대응되는 타입을 체크
 */
public class Secs2ItemParser {

    public ISECS2ItemType parse(InputStream is) throws IOException {
        int buffer;

        //헤더 처리
        if ((buffer = is.read()) ==-1)
            throw new RuntimeException("SECS Item을 위한 헤더에 문제가 있습니다.");

        // format code 획득
        int formatCode = getItemFormatCode(buffer);
        SECS2ItemEnum type = SECS2ItemEnum.getByItemFormatCode(formatCode);

        // byte 크기 획득
        int byteSize = getByteSize(buffer);

        // 실제 아이템 크기 획득
        byte[] lengthBytes = new byte[byteSize];
        if (is.read(lengthBytes) != byteSize)
            throw new RuntimeException("length Bytes의 길이가 충분하지 않습니다.");

        // 아이템의 크기 획득
        int itemSize = getItemSize(lengthBytes);

        // 아이템의 실제 데이터 처리 영역.
        ISECS2ItemType item;

        // list 아이템인 경우 => 재귀로 데이터 처리
        if (type == SECS2ItemEnum.List) {
            SECS2List listItem = new SECS2List();
            //itemSize는 아이템 개수
            for(int itemCount = 0; itemCount < itemSize; itemCount++) {
                listItem.addItem(parse(is));
            }

            item = listItem;
        } else {
            // itemsize는 byte 개수
            byte[] data = new byte[itemSize];
            if (is.read(data) != itemSize)
                throw new RuntimeException("아이템의 크기가 충분하지 않습니다.");
            item = new SECS2ItemValue(data, type);
        }

        return item;
    }

    /**
     * ItemFormatCode 부분을 파싱하는 메서드
     *
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

    public int getItemSize(byte[] lengthBytes) {
        int itemSize = 0;
        for (int i = 0 ; i < lengthBytes.length; i++) {
            if(i > 0) itemSize <<= 8;

            itemSize |= (lengthBytes[i] & 0xff);
        }

        return itemSize;
    }
}
