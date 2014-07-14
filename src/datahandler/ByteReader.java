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
 * Class for reading byte[] to primitive data types and Strings.
 */
public class ByteReader {
    
    /**
     * 
     * @param array - A byte array of minimum length 1.
     * @return Returns a boolean from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static boolean getBoolean(byte[] array) throws Error{
        if(array.length < 1){
            throw new Error("Underflow Error");
        }else{
            boolean answer = array[0] != 0;
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 1 from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns a boolean from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static boolean getBoolean(byte[] array, int offset) throws Error{
        if(array.length - offset < 1){
            throw new Error("Underflow Error");
        }else{
            boolean answer = array[offset] != 0;
            return answer;
        }
    }

    /**
     * 
     * @param array - A byte array of minimum length 2.
     * @return Returns a short from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static short getShort(byte[] array) throws Error{
        if(array.length < 2){
            throw new Error("Underflow Error");
        }else{
            short answer = 0;
            int offset = 1;
            for(int i = 0; i < 2;i++){
                answer |= ((short)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 2 from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns a short from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static short getShort(byte[] array, int offset) throws Error{
        if(array.length - offset < 2){
            throw new Error("Underflow Error");
        }else{
            short answer = 0;
            offset = 1+offset;
            for(int i = 0; i < 2;i++){
                answer |= ((short)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 2.
     * @return Returns a char from binary data in the array. char values
     * are assumed to be of full size - 16 bits. char values therefore may 
     * be off if data is not written in this format.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static char getChar(byte[] array) throws Error{
        if(array.length < 2){
            throw new Error("Underflow Error");
        }else{
            char answer = '\u0000';
            int offset = 1;
            for(int i = 0; i < 2;i++){
                answer |= ((short)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 2 from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns a char from binary data in the array. char values
     * are assumed to be of full size - 16 bits. char values therefore may 
     * be off if data is not written in this format.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static char getChar(byte[] array, int offset) throws Error{
        if(array.length - offset < 2){
            throw new Error("Underflow Error");
        }else{
            char answer = '\u0000';
            offset = offset + 1;
            for(int i = 0; i < 2;i++){
                answer |= ((short)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 4.
     * @return Returns an int from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static int getInt(byte[] array) throws Error{
        if(array.length < 4){
            throw new Error("Underflow Error");
        }else{
            int answer = 0;
            int offset = 3;
            for(int i = 0; i < 4;i++){
                answer |= ((int)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 4 from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns an int from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static int getInt(byte[] array, int offset) throws Error{
        if(array.length - offset < 4){
            throw new Error("Underflow Error");
        }else{
            int answer = 0;
            offset = 3+offset;
            for(int i = 0; i < 4;i++){
                answer |= ((int)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 4.
     * @return Returns a float from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static float getFloat(byte[] array) throws Error{
        if(array.length < 4){
            throw new Error("Underflow Error");
        }else{
            int answer = 0;
            int offset = 3;
            for(int i = 0; i < 4;i++){
                answer |= ((int)array[offset-i] & 0xff) << (i << 3);
            }
            return Float.intBitsToFloat(answer);
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 4 from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns a float from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static float getFloat(byte[] array, int offset) throws Error{
        if(array.length - offset < 4){
            throw new Error("Underflow Error");
        }else{
            int answer = 0;
            offset = 3+offset;
            for(int i = 0; i < 4;i++){
                answer |= ((int)array[offset-i] & 0xff) << (i << 3);
            }
            return Float.intBitsToFloat(answer);
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 8.
     * @return Returns a double from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static double getDouble(byte[] array) throws Error{
        if(array.length < 8){
            throw new Error("Underflow Error");
        }else{
            long answer = 0;
            int offset = 7;
            for(int i = 0; i < 8;i++){
                answer |= ((long)array[offset-i] & 0xff) << (i << 3);
            }
            return Double.longBitsToDouble(answer);
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 8 from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns a double from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static double getDouble(byte[] array, int offset) throws Error{
        if(array.length - offset < 8){
            throw new Error("Underflow Error");
        }else{
            long answer = 0;
            offset = 7+offset;
            for(int i = 0; i < 8;i++){
                answer |= ((long)array[offset-i] & 0xff) << (i << 3);
            }
            return Double.longBitsToDouble(answer);
        }
    } 
    
    /**
     * 
     * @param array - A byte array of minimum length 8.
     * @return Returns a long from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static long getLong(byte[] array) throws Error{
        if(array.length < 8){
            throw new Error("Underflow Error");
        }else{
            long answer = 0;
            int offset = 7;
            for(int i = 0; i < 8;i++){
                answer |= ((long)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }
    
    /**
     * 
     * @param array - A byte array of minimum length 8 from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns a long from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static long getLong(byte[] array, int offset) throws Error{
        if(array.length - offset < 8){
            throw new Error("Underflow Error");
        }else{
            long answer = 0;
            offset = 7+offset;
            for(int i = 0; i < 8;i++){
                answer |= ((long)array[offset-i] & 0xff) << (i << 3);
            }
            return answer;
        }
    }  
    
    /**
     * 
     * @param array - A byte array of no minimum length.
     * @return Returns a string from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static String getString(byte[] array) throws Error{
        String answer = new String(array);
        return answer;
    }
    
    /**
     * 
     * @param array - A byte array of no minimum length from starting point offset.
     * @param offset - Starting point for array.
     * @return Returns a string from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static String getString(byte[] array, int offset) throws Error{
        String answer = new String(array);
        return answer.substring(offset);
    } 
    
    /**
     * 
     * @param array - A byte array from starting point offset to end offset+length.
     * @param offset - Starting point for array.
     * @param length - Length of data to be read from byte array.
     * @return Returns a string from binary data in the array.
     * @throws Error - UnderflowError. Array Length may have been too short.
     */
    public static String getString(byte[] array, int offset, int length) throws Error{
        String answer = new String(array);
        return answer.substring(offset, Math.min(offset+length, answer.length()));
    }  
    
}
