package secs.secs2.datatype;

/**
 * 값을 가지는 클래스를 표현
 */
public abstract class IItemValueType<T> implements IItemType<T> {
    protected byte[] rawData;

    public IItemValueType(byte[] rawData) {
        this.rawData = rawData;
    }

    /**
     * byte 배열을 그대로 반환한다.
     * @return byte 배열
     */
    public byte[] getRawValue() {
        return rawData;
    }
}
