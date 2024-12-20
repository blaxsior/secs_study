package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;
import util.ByteArrayUtil;

public class SECS2UInt4 extends ISECS2ItemValueType<int[]> {

    public SECS2UInt4(byte[] rawData) {
        super(rawData);
    }

    @Override
    public int[] getValue() {
        return ByteArrayUtil.getIntArr(rawData);
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.UInt4.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.UInt4.getSML();
    }
}
