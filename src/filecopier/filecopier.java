/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filecopier;

import datahandler.ByteData;
import datahandler.ByteWriter;
import datahandler.DataHashtable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mallory
 */
public class filecopier {
    
    public static void main(String[] args){
        
        try {
            File file = new File("image.jpg");
            file.createNewFile();
            FileOutputStream fw = new FileOutputStream(file);
            
            int input = 1340;
            int input2 = 204;
            ByteData data = new ByteData("New2", input2);
            ByteData data2 = new ByteData("Key1", input2);
            byte[] byteData = data.getByteArray();
            byte[] byteData2 = data2.getByteArray();
            fw.write(byteData);
            fw.write(byteData2);
            
            InputStream fr = new FileInputStream(file);
            DataHashtable table = new DataHashtable(fr);
            //table.run();
            table.run();
            
            int Key2;
            
                Key2 = (int)(table.get("New2", true));
            
            //System.out.println(Key1);
            System.out.println(Key2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(filecopier.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(filecopier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
