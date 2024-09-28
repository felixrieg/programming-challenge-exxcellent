package de.exxcellent.challenge.models;

/**
 * The {@code FootballModel} class represents a model for a football team with
 * its associated data.
 * It includes the team's name, the number of goals scored, and the number of
 * goals allowed.
 * 
 * <p>
 * This class provides methods to get and set the values of these fields, as
 * well as
 * methods to compare instances of {@code FootballModel} and to generate a
 * string representation
 * of the object.
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * FootballModel team = new FootballModel("Team A", 10, 5);
 * System.out.println(team.getTeam()); // Output: Team A
 * </pre>
 */
public class FootballModel {
    String team;
    int goals;
    int goalsAllowed;

    public FootballModel() {
    }

    public FootballModel(String team, int goals, int goals_allowed) {
        this.team = team;
        this.goals = goals;
        this.goalsAllowed = goals_allowed;
    }

    @Override
    public String toString() {
        return "FootballModel [goals=" + goals + ", goals_allowed=" + goalsAllowed + ", team=" + team + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FootballModel other = (FootballModel) obj;
        if (goals != other.goals)
            return false;
        if (goalsAllowed != other.goalsAllowed)
            return false;
        if (team == null) {
            if (other.team != null)
                return false;
        } else if (!team.equals(other.team))
            return false;
        return true;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getGoalsAllowed() {
        return goalsAllowed;
    }

    public void setGoalsAllowed(int goals_allowed) {
        this.goalsAllowed = goals_allowed;
    }

}
