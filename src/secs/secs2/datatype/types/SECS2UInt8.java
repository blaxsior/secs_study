package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;
import util.ByteArrayUtil;

public class SECS2UInt8 extends ISECS2ItemValueType<long[]> {
    // long의 byte 크기
    static final int typeSize = 8;

    public SECS2UInt8(byte[] rawData) {
        super(rawData);
    }

    @Override
    public long[] getValue() {
        return ByteArrayUtil.getLongArr(rawData);
    }

    @Override
    public int getLength() {
        return rawData.length / typeSize;
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.UInt8.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.UInt8.getSML();
    }
}
