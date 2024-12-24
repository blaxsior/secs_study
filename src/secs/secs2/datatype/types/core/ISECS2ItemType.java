package secs.secs2.datatype.types.core;

/**
 * DataType의 기본 구조를 제시하는 인터페이스
 */
public interface ISECS2ItemType {

    /**
     * value를 데이터 타입에 맞게 받는다.
     * @return java 타입에 맞는 값. 표현 불가능한 경우 byte 반환
     */
    <T> T getValue();

    /**
     * 이이템의 길이를 표한다.
     * @return 아이템의 길이
     */
    int getLength();

    /**
     * 아이템에 부여된 포맷 코드를 반환한다.
     */
    int getItemFormatCode();

    /**
     * 아이템에 부여된 SML을 반환한다.
     */
    String getSML();
}
