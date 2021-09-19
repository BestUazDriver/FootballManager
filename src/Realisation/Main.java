package Realisation;

public class Main {
    public static void main(String[] args) {
        FootballManager footballManager = new FootballManager();
        footballManager.tournament("C:\\Users\\Пользователь\\JavaFiles\\untilted\\DoborExamInfo\\src\\Data\\Teams");
        String path = "C:\\Users\\Пользователь\\JavaFiles\\untilted\\DoborExamInfo\\MatchesInfo.txt";
        System.out.println(footballManager.findMatch(path, "Barcelona FC"));
    }
}
