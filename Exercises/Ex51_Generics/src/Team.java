public abstract class Team implements Comparable<Team>{
    private String name;
    private int wins = 0;
    private int losses = 0;
    private int draw = 0;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getResult(){
        return wins;
    }
    public void setResults(Team secondTeam, int firstResult, int secondResult){
        if(firstResult > secondResult){
            this.wins ++;
        } else if(firstResult < secondResult){
            this.losses++;
        }else{
            this.draw++;
        }
        if (secondTeam != null){
            setResults(null, secondResult, firstResult);
        }
    }


    @Override
    public int compareTo(Team team) {
        return Integer.compare(this.getResult(), team.getResult());
    }
}
