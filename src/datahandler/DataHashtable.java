/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datahandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

/**
 *
 * @author mallory
 */

/**
 * 
 * Class for interpreting byte[] to readable data.
 */
public class DataHashtable {
    
    private Hashtable hashtable = new Hashtable();
    private InputStream inputStream;
    
    public DataHashtable(InputStream stream){
        inputStream = stream;
    }
    
    /**
     * 
     * @param byteData - Adds byteData of format ByteData to the hashtable.
     * @return KeyValue interpreted from byte data
     * @throws Error, IOException
     */
    public String run()throws Error, IOException{
        String key = null;
        byte[] length = new byte[4];
        inputStream.read(length, 0, 4);
        int arrayLength = ByteReader.getInt(length);
        if(arrayLength < 10){
            throw new Error("Insufficient Data Error");
        }else try{
            byte[] byteData = new byte[arrayLength];
            inputStream.read(byteData, 0, arrayLength);
            key = (ByteReader.getString(byteData, 0, 8));            
            byte dataType = byteData[8];
            if(dataType == DataTypes.booleanData){
                boolean value = false;
                value = (boolean)ByteReader.getBoolean(byteData, 9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.charData){
                char value = '\u0000';
                value = (char)ByteReader.getChar(byteData, 9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.doubleData){
                double value = 0.0;
                value = (double)ByteReader.getDouble(byteData, 9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.fileData){
                byte[] value = new byte[byteData.length-9];
                System.arraycopy(byteData, 9, value, 0, byteData.length-9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.floatData){
                float value = 0.0f;
                value = (float)ByteReader.getFloat(byteData, 9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.intData){
                int value = 0;
                value = (int)ByteReader.getInt(byteData, 9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.longData){
                long value = 0;
                value = (long)ByteReader.getLong(byteData, 9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.shortData){
                short value = 0;
                value = (short)ByteReader.getShort(byteData, 9);
                hashtable.put(key, value);
            }else if(dataType == DataTypes.stringData){
                String value = null;
                value = (String)ByteReader.getString(byteData, 9);
                hashtable.put(key, value);
            }
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
        object = hashtable.get(key);
        return object;
    }
    
}
