import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.IOException;

import static java.util.stream.Collectors.counting;


public class Main {

    public static void main(String[] args) {
        String fileName = "punit.txt";
        //List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {


            List<String> list = stream.map(w -> w.split("\\s+")).flatMap(Arrays::stream).collect(Collectors.toList());

            Map<String,Integer> wordcounter=list.stream().collect(Collectors.toMap(w -> w.toLowerCase(),w-> 1 ,Integer::sum ));
            System.out.println(wordcounter);


        } catch (IOException e) {
            e.printStackTrace();
        }

        //list.forEach(System.out::println);



    }
        //System.out.println("Hello World!");
}




