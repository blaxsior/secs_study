package secs.secs2.datatype.types;

import secs.secs2.datatype.types.core.ISECS2ItemType;
import secs.secs2.datatype.types.core.SECS2DataParserFunc;
import secs.secs2.datatype.enums.SECS2ItemEnum;
import secs.secs2.datatype.mapper.SECS2ItemTypeMapper;

import java.lang.reflect.Array;

/**
 * 값을 가지는 클래스를 표현
 */
public class SECS2ItemValue implements ISECS2ItemType {
    private final byte[] rawData;
    private final SECS2ItemEnum itemType;

    public SECS2ItemValue(byte[] rawData, SECS2ItemEnum itemType) {
        this.rawData = rawData;
        this.itemType = itemType;
    }

    /**
     * byte 배열을 그대로 반환한다.
     * @return byte 배열
     */
    public byte[] getRawValue() {
        return rawData;
    }

    /**
     * 현재 객제의 타입에 대응되는 값으로 파싱하여 반환한다.
     * @return 객체의 Enum 타입에 맞게 파싱된 데이터.
     * @param <T> 데이터의 타입
     */
    @Override
    public <T> T getValue() {
        var getValueFunc = SECS2ItemTypeMapper.getParserFunc(this.itemType);
        Object value = getValueFunc.parse(this.rawData);
        return (T) value;
    }

    /**
     * 명시적인 parser 함수를 이용하여 파싱한다.
     * @param parserFunc 데이터를 파싱하는데 사용하는 함수
     * @return 파서에 의해 처리된 데이터
     * @param <T> 파싱된 후의 데이터 타입
     */
    public <T> T getValue(SECS2DataParserFunc<T> parserFunc) {
        return parserFunc.parse(rawData);
    }

    @Override
    public int getLength() {
        return rawData.length;
    }

    @Override
    public int getItemFormatCode() {
        return itemType.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return itemType.getSML();
    }

    @Override
    public String toString() {
        StringBuilder rb = new StringBuilder();
        rb.append(itemType.getSML()).append(": ");

        Object value = getValue();

        if(getValue().getClass().isArray()) {
            for(int i = 0; i < Array.getLength(value); i++) {
//                if(i < Array.get)
            }
        } else {
            rb.append(value);
        }
        return rb.toString();
    }
}
