package Realisation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        FootballManager footballManager = new FootballManager();
        System.out.println(footballManager.start("C:\\Users\\Пользователь\\JavaFiles\\untilted\\DoborExamInfo\\src\\Data\\Teams"));
        ArrayList<String> p = new ArrayList<>();
        p.add("k");
        p.remove(0);
        System.out.println(p);
    }
}
