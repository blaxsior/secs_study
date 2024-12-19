package secs.secs2.datatype.types;

import secs.secs2.datatype.IItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;

public class SECS2Boolean extends IItemValueType<Boolean> {
    public SECS2Boolean(byte[] rawData) {
        super(rawData);
    }

    @Override
    public Boolean getValue() {
        return rawData[0] == 1;
    }

    @Override
    public int getLength() {
        return 1;
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.Boolean.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.Boolean.getSML();
    }
}
