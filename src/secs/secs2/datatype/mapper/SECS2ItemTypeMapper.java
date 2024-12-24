package secs.secs2.datatype.mapper;

import secs.secs2.datatype.enums.SECS2ItemEnum;
import secs.secs2.datatype.types.core.SECS2DataParserFunc;
import util.ByteArrayUtil;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SECS2ItemTypeMapper {
    private static Map<SECS2ItemEnum, SECS2DataParserFunc<?>> getValueFuncMap;

    static {
        getValueFuncMap = initGetValueMap();
    }

    /**
     * getValue Map을 초기화
     * @return
     */
    public static Map<SECS2ItemEnum, SECS2DataParserFunc<?>> initGetValueMap() {
        Map<SECS2ItemEnum, SECS2DataParserFunc<?>> map = new HashMap<>();
        for (var e : SECS2ItemEnum.values()) {
            SECS2DataParserFunc<?> targetParser = switch (e) {
                case Int1, UInt1, Binary -> ByteArrayUtil::getByteArr;
                case Int2, UInt2 -> ByteArrayUtil::getShortArr;
                case Int4, UInt4 -> ByteArrayUtil::getIntArr;
                case Int8, UInt8 -> ByteArrayUtil::getLongArr;
                case Float4 -> ByteArrayUtil::getFloatArr;
                case Float8 -> ByteArrayUtil::getDoubleArr;
                case Boolean -> ByteArrayUtil::getBooleanArr;
                // 필요시 분리
                case ASCII -> (byte[] arr) -> new String(arr, StandardCharsets.US_ASCII);
                default -> null;
            };

            map.put(e, targetParser);
        }
        return map;
    }
    public static SECS2DataParserFunc<?> getParserFunc(SECS2ItemEnum e) {
        return getValueFuncMap.get(e);
    }
}
