package util;

import java.nio.ByteBuffer;

public class ByteArrayUtil {
    public static long[] getLongArr(byte[] bytes) {
        final int typeSize = 8;

        long[] value = new long[bytes.length / typeSize];

        var buffer =  ByteBuffer.wrap(bytes);
        for(int i = 0; i < value.length; i++) {
            value[i] = buffer.getLong(i);
        }

        return value;
    }

    public static int[] getIntArr(byte[] bytes) {
        final int typeSize = 4;

        var buffer =  ByteBuffer.wrap(bytes);
        int[] value = new int[bytes.length / typeSize];
        for(int i = 0; i < value.length; i++) {
            value[i] = buffer.getInt(i);
        }

        return value;
    }

    public static short[] getShortArr(byte[] bytes) {
        final int typeSize = 2;

        var buffer =  ByteBuffer.wrap(bytes);
        short[] value = new short[bytes.length / typeSize];
        for(int i = 0; i < value.length; i++) {
            value[i] = buffer.getShort(i);
        }

        return value;
    }

    public static double[] getDoubleArr(byte[] bytes) {
        final int typeSize = 8;

        var buffer =  ByteBuffer.wrap(bytes);
        double[] value = new double[bytes.length / typeSize];
        for(int i = 0; i < value.length; i++) {
            value[i] = buffer.getDouble(i);
        }

        return value;
    }

    public static float[] getFloatArr(byte[] bytes) {
        final int typeSize = 4;

        var buffer =  ByteBuffer.wrap(bytes);
        float[] value = new float[bytes.length / typeSize];
        for(int i = 0; i < value.length; i++) {
            value[i] = buffer.getShort(i);
        }

        return value;
    }
}
