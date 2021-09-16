package Realisation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class FootballManager {
    private List<String> teamParser(String path) {
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
        System.out.println(teams);
        return teams;
    }

    private Map<String, String> couples(List<String> teams) {
        Random random = new Random();
        Map<String, String> couples = new HashMap<>();
        System.out.println(teams.size());
        for (int i = 0; i < teams.size(); i++) {
            couples.put(String.valueOf(teams.remove(random.nextInt(teams.size()))), String.valueOf(teams.remove(random.nextInt(teams.size()))));
        }
        return couples;
    }

    private Map<String, String> goals(Map<String, String> couples) {
        Random random = new Random();
        System.out.println(couples);
        HashMap<String, String> totalGoals = new HashMap<>();
        for (String couple : couples.keySet()) {
            totalGoals.put(couple + " - " + couples.get(couple), random.nextInt(7) + ":" + random.nextInt(7));
        }
        return totalGoals;
    }

    public Map<String, String> start(String path) {
        FootballManager footballManager = new FootballManager();
        List<String> teams = footballManager.teamParser(path);
        Map<String, String> totalGoals = footballManager.couples(teams);
        return footballManager.goals(totalGoals);
    }
}
