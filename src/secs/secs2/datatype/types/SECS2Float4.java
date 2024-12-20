package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;
import util.ByteArrayUtil;

public class SECS2Float4 extends ISECS2ItemValueType<float[]> {
    public SECS2Float4(byte[] rawData) {
        super(rawData);
    }

    @Override
    public float[] getValue() {
        return ByteArrayUtil.getFloatArr(rawData);
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.Float4.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.Float4.getSML();
    }
}
