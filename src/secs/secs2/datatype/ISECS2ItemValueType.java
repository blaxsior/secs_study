package secs.secs2.datatype;

/**
 * 값을 가지는 클래스를 표현
 */
public abstract class ISECS2ItemValueType<T> implements ISECS2ItemType<T> {
    protected byte[] rawData;

    public ISECS2ItemValueType(byte[] rawData) {
        this.rawData = rawData;
    }

    /**
     * byte 배열을 그대로 반환한다.
     * @return byte 배열
     */
    public byte[] getRawValue() {
        return rawData;
    }

    @Override
    public int getLength() {
        return rawData.length;
    }
}
