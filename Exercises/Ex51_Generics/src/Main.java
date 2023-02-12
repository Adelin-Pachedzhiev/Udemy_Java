public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FootballTeam team1 = new FootballTeam("team1");
        FootballTeam team2 = new FootballTeam("team2");
        FootballTeam team3 = new FootballTeam("team3");
        FootballTeam team4 = new FootballTeam("team4");
        team1.setResults(team2, 1 ,0);
        team2.setResults(team3, 0, 1);
        team3.setResults(team1, 3 ,0);
        team3.setResults(team1, 3 ,0);
        team3.setResults(team1, 3 ,0);
        team3.setResults(team1, 3 ,0);

        Team bsteam1 = new BaseballTeam("baseball 1");

        LeagueTable<FootballTeam> table = new LeagueTable<>();
        table.addTeam(team1);
        table.addTeam(team2);
        table.addTeam(team3);
        table.addTeam(team4);
//        table.addTeam(bsteam1);
        table.printLeague();
    }
}