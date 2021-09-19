package Realisation;

public class Match {
    String firstTeam;
    String secondTeam;
    String total;

    public Match(String firstTeam, String secondTeam, String total) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.total = total;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public String getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return firstTeam + "|" + total + "|" + secondTeam + "\n";
    }
}
