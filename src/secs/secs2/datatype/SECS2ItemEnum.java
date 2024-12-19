package secs.secs2.datatype;

public enum SECS2ItemEnum {
    List(0b000000, "L"),
    Binary(0b001000, "B"),
    Boolean(0b001001, "BOOLEAN"),
    ASCII(0b010000, "A"),
    JIS_8(0b010001, "J"),
    Char(0b010010, "CHAR"),
    Int8(0b011000, "I8"),
    Int1(0b011001, "I1"),
    Int2(0b011010, "I2"),
    Int4(0b011100, "I2"),
    Float8(0b100000, "F8"),
    Float4(0b100100, "F4"),
    UInt8(0b101000, "U8"),
    UInt1(0b101001, "U1"),
    UInt2(0b101010, "U2"),
    UInt4(0b101100, "U4");

    private final int itemFormatCode;
    private final String SML;


    SECS2ItemEnum(int itemFormatCode, String SML) {
        this.itemFormatCode = itemFormatCode;
        this.SML = SML;
    }

    /**
     * 아이템에 대응되는 Format Code를 반환
     * @return 포맷 코드
     */
    public int getItemFormatCode(){
        return this.itemFormatCode;
    }

    /**
     * 아이템에 대응되는 SML 코드를 반환
     * @return SML
     */
    public String getSML() {
        return this.SML;
    }
}
