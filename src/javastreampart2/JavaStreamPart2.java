/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreampart2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author rant
 */
//question 1+2+3 in ch3 part2
public class JavaStreamPart2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //1....a
        Consumer<Integer> value = b -> System.out.printf("%d",b);
        value.accept(10);
        System.out.println();
        //1....b
        System.out.println(string("hello"));
        //1....c
       Supplier<String> nn = ()->{
           System.out.println("Welcome to lamdas!");
            return null;};
       nn.get();
       //1....d
       UnaryOperator<Integer> gg = n -> {
           System.out.println(n*n*n);
            return null;
        };
       gg.apply(2);
       ///2
       Map<String, Long> map= new TreeMap<>();
try {
	map = Files.lines(Paths.get("C:\\net\\map.txt.txt")).parallel()
	.flatMap(line -> Arrays.stream(line.trim().split(""))).collect(Collectors
                 .groupingBy(String::toUpperCase,                             
                             Collectors.counting()
                             ) );	
} catch (IOException e) {
	e.printStackTrace();
}
        System.out.println(map);
//2...another soluation
try {
	Files.lines(Paths.get("C:\\net\\map.txt.txt"))
	.flatMap(line ->Arrays.stream(line.trim().split("")))
                .collect(Collectors
                 .groupingBy(String::toUpperCase,                             
                             Collectors.counting()
                             )
                )
	.forEach((charr,count) -> 
                 System.out.println(charr+" : " + count));
} catch (IOException e) {
	e.printStackTrace();
}
//3
       
    }
     public static String string(String s){
            return s.toUpperCase();
        }
        
}
