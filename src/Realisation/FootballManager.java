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
        System.out.println("teams: " + teams);
        List<String> mixedTeams = new ArrayList<>();
        while (teams.size() > 0) {
            mixedTeams.add(teams.remove(random.nextInt(teams.size())));
        }
        return mixedTeams;
    }

    private List<Match> couples(List<String> teams) {
        Random random = new Random();
        Map<String, String> couples = new HashMap<>();
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

    private List<String> tourChampionship(List<Match> matches) {
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

    private void databaseInfo(List<String> nextPlayers, List<Match> matchesPlayed, FileWriter fileWriter) {


        try {
            fileWriter.write("\n tour played, total:\n");
            for (Match match : matchesPlayed) {
                fileWriter.write(match.toString());
            }
            fileWriter.write("\n plays next tour: " + nextPlayers.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<Match> findMatch(String path, String team) {
        List<Match> matches = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] atributes = line.split("\\|");
                for (int i = 0; i < atributes.length; i++) {
                    if (atributes[i].equals(team)) {
                        matches.add(new Match(atributes[0], atributes[2], atributes[1]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return matches;
    }

    public void tournament(String path) {
        File file = new File("MatchesInfo.txt");
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file.getPath());
            fileWriter.write("Tournament started! \n");
            System.out.println("Tournament started!!!");
            int tour = 1;
            FootballManager footballManager = new FootballManager();
            List<String> teams;
            List<Match> matches;
            teams = footballManager.teamParser(path);
            fileWriter.write("\n Teams: \n" + teams + "\n");
            while (teams.size() > 1) {
                System.out.println("tour " + tour);
                matches = footballManager.couples(teams);
                teams = footballManager.tourChampionship(matches);
                footballManager.databaseInfo(teams, matches, fileWriter);
                tour++;

            }
            System.out.println("\n Winner: " + teams.get(0) + "\n");
            fileWriter.write("\n Winner: " + teams.get(0));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
