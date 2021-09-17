package Realisation;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FootballManager footballManager = new FootballManager();
        List<Match> matches;
        List<String> info;
        matches=footballManager.start("C:\\Users\\Пользователь\\JavaFiles\\untilted\\DoborExamInfo\\src\\Data\\Teams");
        System.out.println(matches);
        info=footballManager.tourChampionship(matches);
        footballManager.databaseInfo(info, matches);
        String path="C:\\Users\\Пользователь\\JavaFiles\\untilted\\DoborExamInfo\\MatchesInfo.txt";
        System.out.println(" ok ok");
        System.out.println(footballManager.findMatch(path, "Barcelona FC"));
    }
}
