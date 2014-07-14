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
 * Class for formatting data into a byte array (byte[]).
 */

/*
 *  -ByteData.getArray.length is a 'final' value/ Once assigned, 
 *  -this can't be changed/  Therefore it is suggested that the user
 *  -uses ByteData as a local variable or simply use the 'new' keyword
 *  -when creating objects/ This is why the class is composed primarily of 
 *  -constructors/
 * 
 *  -Data is formatted in the following way:
 *      0   1   2   3   4   5   6   7   8   |      9       |       10+      |
 *                  KEY NAME                 DataTypes.value    Input Data
 * 
 */
public class ByteData {
    
    private byte[] array;
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, boolean value)throws Error{
        try{
            array = new byte[10];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.booleanData;
            buffer = ByteWriter.writeBoolean(value);
            System.arraycopy(buffer, 0, array, 9, 1);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, short value)throws Error{
        try{
            array = new byte[11];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.shortData;
            buffer = ByteWriter.writeShort(value);
            System.arraycopy(buffer, 0, array, 9, 2);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, char value)throws Error{
        try{
            array = new byte[11];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.charData;
            buffer = ByteWriter.writeChar(value);
            System.arraycopy(buffer, 0, array, 9, 2);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, int value)throws Error{
        try{
            array = new byte[13];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.intData;
            buffer = ByteWriter.writeInt(value);
            System.arraycopy(buffer, 0, array, 9, 4);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, float value)throws Error{
        try{
            array = new byte[13];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.floatData;
            buffer = ByteWriter.writeFloat(value);
            System.arraycopy(buffer, 0, array, 9, 4);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, double value)throws Error{
        try{
            array = new byte[17];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.doubleData;
            buffer = ByteWriter.writeDouble(value);
            System.arraycopy(buffer, 0, array, 9, 8);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, long value)throws Error{
        try{
            array = new byte[17];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.longData;
            buffer = ByteWriter.writeLong(value);
            System.arraycopy(buffer, 0, array, 9, 8);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, String value)throws Error{
        try{
            array = new byte[9+value.length()];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.stringData;
            buffer = ByteWriter.writeString(value);
            System.arraycopy(buffer, 0, array, 9, buffer.length);
        }catch(Error e){
            throw e;
        }
    }
    
    /**
     * 
     * @param name - Key for accessing value from a DataHashtable
     * @param value - Value to be stored in byte[]
     * @throws Error - "Key : 'name' too long!!!"
     */
    public ByteData(String name, byte[] value)throws Error{
        try{
            array = new byte[value.length];
            writeName(name);
            byte[] buffer;
            array[8] = DataTypes.fileData;
            buffer = value;
            System.arraycopy(buffer, 0, array, 9, buffer.length);
        }catch(Error e){
            throw e;
        }
    }
    /**
     * 
     * @return byte[] with previous input data 
     */
    public byte[] getByteArray(){
        return array;
    }
    
    private void writeName(String name)throws Error{
        if(name.length() > 4){
            throw new Error("Key : 'name' too long!!!");
        }else if(name.length() < 4){
            while(name.length() != 4){
                name = '\u0000' + name;
            }
        }else{
            byte[] buffer;
            char[] charBuffer = name.toCharArray();
            for(int i = 0; i < 4; i++){
                buffer = ByteWriter.writeChar(charBuffer[i]);
                System.arraycopy(buffer, 0, array, i << 1, 2);
            }
        }
    }
    
}
