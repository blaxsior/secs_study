package secs.secs2.datatype.types;

import secs.secs2.datatype.IItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;

public class SECS2Binary extends IItemValueType<Byte> {
    public SECS2Binary(byte[] rawData) {
        super(rawData);
    }

    @Override
    public byte[] getRawValue() {
        return new byte[0];
    }

    @Override
    public Byte getValue() {
        return rawData[0];
    }

    @Override
    public int getLength() {
        return 1;
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
