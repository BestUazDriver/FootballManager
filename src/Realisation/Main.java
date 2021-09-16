package Realisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FootballManager footballManager = new FootballManager();
        System.out.println(footballManager.teamParser("C:\\Users\\Пользователь\\JavaFiles\\untilted\\DoborExamInfo\\src\\Data\\Teams"));
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("lol");
        hashSet.add("kek");
        hashSet.add("ch");
        ArrayList<String> k = new ArrayList<>();
        k.add("k");
        System.out.println(String.valueOf(k.remove(0)));
    }
}
