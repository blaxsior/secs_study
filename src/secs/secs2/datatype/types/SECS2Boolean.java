package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;

public class SECS2Boolean extends ISECS2ItemValueType<boolean[]> {
    public SECS2Boolean(byte[] rawData) {
        super(rawData);
    }

    @Override
    public boolean[] getValue() {
        boolean[] value = new boolean[rawData.length];
        for(int i = 0; i < value.length; i++) {
            value[i] = rawData[i] == 0x01; // true 값으로 치환
        }

        return value;
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
