package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;
import util.ByteArrayUtil;

public class SECS2Float8 extends ISECS2ItemValueType<double[]> {
    public SECS2Float8(byte[] rawData) {
        super(rawData);
    }

    @Override
    public double[] getValue() {
        return ByteArrayUtil.getDoubleArr(rawData);
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.Float8.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.Float8.getSML();
    }
}
