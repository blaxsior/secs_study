package secs.secs2.datatype.types.core;

@FunctionalInterface
public interface SECS2DataParserFunc<T> {
    T parse(byte[] rawData);
}
