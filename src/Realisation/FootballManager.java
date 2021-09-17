package Realisation;

import java.io.*;
import java.util.*;


public class FootballManager {
    private List<String> teamParser(String path) {
        Random random = new Random();
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
        List<String> mixedTeams = new ArrayList<>();
        while (teams.size() > 0) {
            mixedTeams.add(teams.remove(random.nextInt(teams.size())));
        }
        return mixedTeams;
    }

    private List<Match> couples(List<String> teams) {
        Random random = new Random();
        Map<String, String> couples = new HashMap<>();
        System.out.println(teams.size());
        int t = teams.size() / 2;
        for (int i = 0; i < t; i++) {
            couples.put(teams.remove(0), teams.remove(0));
        }


        ArrayList<Match> matches = new ArrayList<>();
        for (String couple : couples.keySet()) {
            matches.add(new Match(couple, couples.get(couple), random.nextInt(7) + ":" + random.nextInt(7)));
        }
        return matches;
    }


    public List<Match> start(String path) {
        FootballManager footballManager = new FootballManager();
        List<String> teams = footballManager.teamParser(path);
        return footballManager.couples(teams);
    }

    public List<String> tourChampionship(List<Match> matches) {
        List<String> nextPlayers = new ArrayList<>();
        for (Match match : matches) {
            String[] total = match.getTotal().split(":");
            if (Integer.valueOf(total[0]) > Integer.valueOf(total[1])) {
                nextPlayers.add(match.getFirstTeam());
            } else {
                nextPlayers.add(match.getSecondTeam());
            }
        }
        System.out.println(nextPlayers);
        return nextPlayers;
    }

    public void databaseInfo(List<String> nextPlayers, List<Match> matchesPlayed) {

        File file = new File("MatchesInfo.txt");


        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getPath());
            fileWriter.write("tour played, total: \n" + matchesPlayed.toString() + "\n");
            fileWriter.write("plays next tour: " + nextPlayers.toString() + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Match> findMatch(String path, String team) {
        List<Match> matches=new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line.substring(4);
                String[] atributes = line.split("\\|");
                if (atributes.equals(team)) {
                    matches.add(new Match(atributes[0], atributes[2], atributes[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("lol");
        }

        return matches;
    }
}
