package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;
import util.ByteArrayUtil;

public class SECS2Int2 extends ISECS2ItemValueType<short[]> {
    public SECS2Int2(byte[] rawData) {
        super(rawData);
    }

    @Override
    public short[] getValue() {
        return ByteArrayUtil.getShortArr(rawData);
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.Int2.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.Int2.getSML();
    }
}
