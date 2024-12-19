package secs.secs2.datatype.types;

import secs.secs2.datatype.IItemType;
import secs.secs2.datatype.SECS2ItemEnum;

import java.util.ArrayList;
import java.util.List;

public class SECS2List implements IItemType<List<IItemType<?>>> {
    private final List<IItemType<?>> items;

    public void addItem(IItemType<?> item) {
        items.add(item);
    }

    public void removeItem(IItemType<?> item) {
        items.remove(item);
    }

    public SECS2List() {
        items = new ArrayList<>();
    }

    @Override
    public List<IItemType<?>> getValue() {
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
