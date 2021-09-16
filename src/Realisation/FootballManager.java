package Realisation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class FootballManager {
    public List<String> teamParser(String path) {
        List<String> teams = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] atributes = line.split(",");
                teams.addAll(Arrays.asList(atributes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }

    private Map<String, String> couples(Set<String> teams) {
        Random random = new Random();
        Map<String, String> couples = null;
        for (int i = 0; i < teams.size() / 2; i++) {
            couples.put(String.valueOf(teams.remove(random.nextInt(teams.size()))),String.valueOf(teams.remove(random.nextInt(teams.size()))));
        }
        return null;
    }
}
