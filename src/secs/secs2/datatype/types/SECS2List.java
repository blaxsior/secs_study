package secs.secs2.datatype.types;

import secs.secs2.datatype.types.core.ISECS2ItemType;
import secs.secs2.datatype.enums.SECS2ItemEnum;

import java.util.ArrayList;
import java.util.List;

public class SECS2List implements ISECS2ItemType {
    private final List<ISECS2ItemType> items;

    public void addItem(ISECS2ItemType item) {
        items.add(item);
    }

    public void removeItem(ISECS2ItemType item) {
        items.remove(item);
    }

    public SECS2List() {
        items = new ArrayList<>();
    }

    @Override
    public List<ISECS2ItemType> getValue() {
        return items;
    }

    @Override
    public int getLength() {
        return items.size();
    }

    @Override
    public int getItemFormatCode() {
        return SECS2ItemEnum.List.getItemFormatCode();
    }

    @Override
    public String getSML() {
        return SECS2ItemEnum.List.getSML();
    }
}
