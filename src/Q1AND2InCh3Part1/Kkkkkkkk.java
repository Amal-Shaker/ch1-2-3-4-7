/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package Q1AND2InCh3Part1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author rant
 */
//question 1 + 2 in ch3 part 1
public class Kkkkkkkk {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws NoSuchElementException, FileNotFoundException {
        System.out.println("******The first question*******");
        Random r = new Random();
        Integer[] random = new Integer[30];
        for(int i=0; i<random.length; i++){
            random[i] = r.nextInt(100)+1;
        }
        System.out.print("the random number: ");
        for(int i=0; i<random.length; i++){
            System.out.print(random[i]+" ");
        }
        System.out.println("");
        List<Integer> list = Arrays.asList(random);
        LinkedList<Integer> li = new LinkedList<Integer>(list);
        Collections.sort(list);
        System.out.println("the number sort: "+list);
        double y = 0;
        for(int u=0; u<random.length; u++){
           y+=random[u]; 
        }
        System.out.println("the sum: "+y);
        System.out.println("the average: "+(y/random.length));   
        System.out.println("********The second question***********");
         Map<String,Integer> mapp = new HashMap<>();  
         Map<String,Integer> map = new HashMap<>(); 
        File file = new File("C:\\net\\map.txt.txt");
        Scanner read = new Scanner(new FileInputStream(file));
       String linee ="";
        while(read.hasNextLine()){           
                linee = read.nextLine();
             System.out.println("The line: "+linee);
             if(!linee.trim().equals("")){
                    String[] wordss = linee.split(" ");
                    for(String wordd:wordss){
                        if(wordd == null || wordd.trim().equals("")){
                            continue;
                    }
                        String processedd = wordd.toLowerCase();
                    if(mapp.containsKey(processedd)){
                        mapp.put(processedd, mapp.get(processedd)+1);
                    }else{
                        mapp.put(processedd, 1);
                    }    
             }                 
        }     
        }
        System.out.println("********Print the number of occurrences of each word in the string*******");
                 System.out.println(mapp);
       File filee = new File("C:\\net\\map.txt.txt");
        Scanner readd = new Scanner(new FileInputStream(filee));
       String line ="";
        while(readd.hasNextLine()){           
                line = readd.nextLine();
             if(!line.trim().equals("")){
                   String[] words = {} ;
                for(int i=0; i<line.length(); i++){
                     words = line.split("");
                    }
                    for(String word:words){
                        if(word == null || word.trim().equals("")){
                            continue;
                    }
                        String processed = word.toLowerCase();
                    if(map.containsKey(processed)){
                        map.put(processed, map.get(processed)+1);
                    }else{
                        map.put(processed, 1);
                    }    
             }                 
        }                   
        }
        System.out.println("********Print the number of occurrences of each letter in the string*******");
         System.out.println(map);
    
    
    
    
    }
    
}
