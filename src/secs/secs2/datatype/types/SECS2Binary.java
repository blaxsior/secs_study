package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;

public class SECS2Binary extends ISECS2ItemValueType<byte[]> {
    public SECS2Binary(byte[] rawData) {
        super(rawData);
    }

    @Override
    public byte[] getValue() {
        return rawData.clone();
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.Binary.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.Binary.getSML();
    }
}
