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

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return firstTeam + " |" + total + "| " + secondTeam + "\n";
    }
}
