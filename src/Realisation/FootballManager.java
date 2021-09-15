package Realisation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FootballManager {
public List<String> teamParser(String path){
    ArrayList<String> teams = new ArrayList<>();
    try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line;
        while ((line= bufferedReader.readLine())!=null){
            String[] atributes=line.split(",");
            teams.addAll(Arrays.asList(atributes));
        }
    }  catch (IOException e) {
        e.printStackTrace();
    }
    return teams;
}
}
