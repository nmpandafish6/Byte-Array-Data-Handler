/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datahandler;

import java.util.Hashtable;

/**
 *
 * @author mallory
 */

/**
 * 
 * Class for interpreting byte[] to readable data.
 */
public class DataHashtable extends Hashtable{
    
    
    /**
     * 
     * @param byteData - Adds byteData of format ByteData to the hashtable.
     * @return KeyValue interpreted from byte data
     * @throws Error
     */
    public String put(byte[] byteData)throws Error{
        String key = null;
        if(byteData.length < 10){
            throw new Error("Insufficient Data Error");
        }else try{
            key = (ByteReader.getString(byteData, 0, 8));            
            byte dataType = byteData[8];
            Object value = (int)0;
            if(dataType == DataTypes.booleanData){
                value = (boolean)ByteReader.getBoolean(byteData, 9);
            }else if(dataType == DataTypes.charData){
                value = (char)ByteReader.getChar(byteData, 9);
            }else if(dataType == DataTypes.doubleData){
                value = (double)ByteReader.getDouble(byteData, 9);
            }else if(dataType == DataTypes.fileData){
                value = new byte[byteData.length-9];
                System.arraycopy(byteData, 9, value, byteData.length-9, byteData.length-9);
            }else if(dataType == DataTypes.floatData){
                value = (float)ByteReader.getFloat(byteData, 9);
            }else if(dataType == DataTypes.intData){
                value = (int)ByteReader.getInt(byteData, 9);
            }else if(dataType == DataTypes.longData){
                value = (long)ByteReader.getLong(byteData, 9);
            }else if(dataType == DataTypes.shortData){
                value = (short)ByteReader.getShort(byteData, 9);
            }else if(dataType == DataTypes.stringData){
                value = (String)ByteReader.getString(byteData, 9);
            }
            put(key, value);
        }catch(Error e){
            throw e;
        }
        return key;
    }
    
    /**
     * 
     * @param key Key for desired data.
     * @param format A value of 'true' represents that the data is formatted
     * into the 8 byte key-String format. It is recommended that this is used.
     * A value of false represents that that data is not formatted and therefore
     * works the same as Hashtable.get(Object key);
     * @return Object at key String.
     */
    public Object get(String key, boolean format){
        Object object;
        if(format == true){
            while(key.length() < 4){
                key = '\u0000' + key;
            }
            byte[] buffer;
            byte[] array = new byte[8];
            char[] charBuffer = key.toCharArray();
            for(int i = 0; i < 4; i++){
                buffer = ByteWriter.writeChar(charBuffer[i]);
                System.arraycopy(buffer, 0, array, i << 1, 2);
            }
            key = ByteReader.getString(array, 0, 8);
        }else{
        }
        object = get(key);
        return object;
    }
    
}
