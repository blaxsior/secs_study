package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;
import util.ByteArrayUtil;

public class SECS2UInt2 extends ISECS2ItemValueType<short[]> {

    public SECS2UInt2(byte[] rawData) {
        super(rawData);
    }

    @Override
    public short[] getValue() {
        return ByteArrayUtil.getShortArr(rawData);
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.UInt2.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.UInt2.getSML();
    }
}
