package secs.secs2.datatype.types;

import secs.secs2.datatype.ISECS2ItemValueType;
import secs.secs2.datatype.SECS2ItemEnum;

import java.nio.charset.StandardCharsets;

public class SECS2ASCII extends ISECS2ItemValueType<String> {
    public SECS2ASCII(byte[] rawData) {
        super(rawData);
    }

    @Override
    public String getValue() {
        return new String(rawData, StandardCharsets.US_ASCII);
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.ASCII.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.ASCII.getSML();
    }
}
