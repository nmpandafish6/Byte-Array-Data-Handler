/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datahandler;

/**
 *
 * @author mallory
 */

/**
 * 
 * Class for writing primitive data types and Strings to byte[].
 */
public class ByteWriter {
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) of length 1 with data from value.
     */
    public static byte[] writeBoolean(boolean value){
        byte[] array = new byte[1];
        int length = array.length;
        for(int i = 0; i < length; i++){
            array[i] = (byte) (value ? 1 : 0);
        }
        return array;
    }
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) of length 2 with data from value.
     */
    public static byte[] writeShort(short value){
        byte[] array = new byte[2];
        int length = array.length;
        for(int i = 0; i < length; i++){
            array[i] = (byte) ((value >> ((1-i) * 8)) & 0xff);
        }
        return array;
    }
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) of length 2 with data from value.
     */
    public static byte[] writeChar(char value){
        byte[] array = new byte[2];
        int length = array.length;
        for(int i = 0; i < length; i++){
            array[i] = (byte) ((value >> ((1-i) * 8)) & 0xff);
        }
        return array;
    }
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) of length 4 with data from value.
     */
    public static byte[] writeInt(int value){
        byte[] array = new byte[4];
        int length = array.length;
        for(int i = 0; i < length; i++){
            array[i] = (byte) ((value >> ((3-i) * 8)) & 0xff);
        }
        return array;
    }
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) of length 4 with data from value.
     */
    public static byte[] writeFloat(float value){
        byte[] array = new byte[4];
        int intValue = Float.floatToIntBits(value);
        int length = array.length;
        for(int i = 0; i < length; i++){
            array[i] = (byte) ((intValue >> ((3-i) * 8)) & 0xff);
        }
        return array;
    }
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) of length 8 with data from value.
     */
    public static byte[] writeDouble(double value){
        byte[] array = new byte[8];
        long longValue =  Double.doubleToLongBits(value);
        int length = array.length;
        for(int i = 0; i < length; i++){
            array[i] = (byte) ((longValue >> ((7-i) * 8)) & 0xff);
        }
        return array;
    }
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) of length 8 with data from value.
     */
    public static byte[] writeLong(long value){
        byte[] array = new byte[8];
        int length = array.length;
        for(int i = 0; i < length; i++){
            array[i] = (byte) ((value >> ((7-i) * 8)) & 0xff);
        }
        return array;
    }
    
    /**
     * 
     * @param value
     * @return byte array (byte[]) using the String method - "value.getBytes()"
     */
    public static byte[] writeString(String value){
        byte[] array = value.getBytes();
        return array;
    }
    
}
