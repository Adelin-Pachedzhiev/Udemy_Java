import java.util.ArrayList;
import java.util.Collections;

public class LeagueTable<T extends Team >{
    private ArrayList<T> teams;

    public LeagueTable() {
        this.teams = new ArrayList<>();
    }

    public boolean addTeam(T team){
        if(teams.contains(team)){
            return false;
        }
        teams.add(team);
        return true;
    }

    public boolean removeTeam(T team){
        if(teams.contains(team)){
            teams.remove(team);
            return true;
        }
        return false;
    }

    public void printLeague(){
        Collections.sort(teams);
        for(T team: teams){
            System.out.println(team.getName());
        }
    }


}
