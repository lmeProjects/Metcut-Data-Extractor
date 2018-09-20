/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datatableconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Logan
 */
public class DataTableConverter {
    
    public int lineCount = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String Collector = "";
        String Collector2 = "";
        String[] lineCapArr;
        
        Path file = Paths.get("C:\\Users\\Logan\\Documents\\New folder\\tabula-20180821094825-3.txt");
        
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                lineCapArr = line.split("\"",0);
                
                Collector += "|";
                for (String c : lineCapArr){
                    Collector += c;
                }
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
        String noWhiteSpace = Collector.replaceAll("\\s","|");
        
        System.out.println(noWhiteSpace);
        
        char[] readyForDataSplice = noWhiteSpace.toCharArray();
        
        boolean eol = false;
        int[] spliceLocations = new int[readyForDataSplice.length];
        int x = 0;
        
        System.out.println(readyForDataSplice.length);
        
        for (int i = 0; i < readyForDataSplice.length; i++){
            if (readyForDataSplice[i] == '|'){
                spliceLocations[x] = i;
                x += 1;
            }
        }
        
        //for (int i = 0; i < readyForDataSplice.length; i++){
        //    System.out.println(spliceLocations[i]);
        //}
        
        System.out.println("Number of splice Locations: " + x); 
        for (int i = 0; i < spliceLocations.length; i++){
            System.out.print(spliceLocations[i] + "|");
        }
        
        
    }
    
}
