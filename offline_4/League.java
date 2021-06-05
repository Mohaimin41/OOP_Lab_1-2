public class League {
    private Match[] matches;
    private int matchCount;
    private int clubCount;
    // add your variables here, if required
    private String name;
    private Club [] clubs;
    private int [] points;
    public League() {
        // assume a league can have at most 5 clubs, add code for initialization accordingly
        clubCount = 0;
        matchCount = 0;
        clubs = new Club[5];
        points = new int[5];
    }

    public void printLeagueInfo(){
        System.out.println("League : " + name);
        printClubs();
    }

    public void printClubs(){
        System.out.println("Clubs:");
        // print the name of the clubs of this league, each one on a line
        for ( int i = 0; i < clubCount; i++ ) {
            System.out.println(clubs[i].getName());
        }
    }

    public void scheduleMatches(){
        matchCount = (clubCount*(clubCount-1));
        matches = new Match[matchCount];

        int matchNo = 0;
        for (int i=0; i<clubCount; i++){
            for (int j=0; j<clubCount; j++){
                // check the constructor of the Match class and add your code here
                // note that there will be two matches between club A and club B
                // in the first match, club A will play as the home team and in the second match, as the away team
                if ( i != j ) {
                    matches[matchNo++] = new Match( matchNo, clubs[i], clubs[j] );
                }
            }
        }
    }

    public void simulateMatches(){
        for (int i=0; i<matchCount; i++){
            matches[i].play();
        }
    }

    public void showStandings(){
        // sort the clubs in descending order of points
        // note that, the sequence in which clubs were added to the league, should be unchanged
        // check the given sample output for clarification
        // (carefully observe the output of showStandings() followed by printLeagueInfo() method calls
        // you can use additional arrays if needed

        //add all points
        //set points array values to 0
        setPoints();

        for( int i = 0; i < matchCount; i++ ) {
            if ( matches[i].getWinningTeam() == 1 ) {
                points[findClubIndex(matches[i].getHomeTeam().getId())] += 2;
            } else if ( matches[i].getWinningTeam() == 2 ) {
                points[findClubIndex(matches[i].getAwayTeam().getId())] += 2;
            } else {
                points[findClubIndex(matches[i].getHomeTeam().getId())] += 1;
                points[findClubIndex(matches[i].getAwayTeam().getId())] += 1;
            }
        }

        int [] sortIndex = new int[clubCount];
        for ( int i = 0; i < clubCount; i++ )
            sortIndex[i] = i;

        //selection sort over points array

        for ( int i = 0; i < clubCount - 1; i++ ) {
            int idx = i, tmp, max = points[sortIndex[i]];
            for ( int j = i + 1; j < clubCount; j++ ) {
                if ( points[sortIndex[j]] > max ) {
                    idx = j;
                    max = points[sortIndex[j]];
                }
            }
            tmp = sortIndex[i];
            sortIndex[i] = sortIndex[idx];
            sortIndex[idx] = tmp;
        }

        System.out.println("Sl. - Club - Points");
        // print the clubs in descending order of points
        for ( int i = 0; i < clubCount; i++ ) {
            System.out.println(i+1 + ". " + clubs[sortIndex[i]].getName() + " " + points[sortIndex[i]]);
        }
    }

    // add your methods here, if required
    public void setName(String name) {
        this.name = name;
    }

    public void addClub( Club club ) {
        clubs[clubCount++] = club;
    }

    public void removeClub(Club club ) {
        int rmvdIdx = findClubIndex(club.getId());

        for ( int i = 0, j = 0; i < clubCount - 1; i++ ) {
            if ( i == rmvdIdx ) {
                j++;
            }
            clubs[i] = clubs[j++];

        }

        clubCount--;
        scheduleMatches();
    }

    public void printMatches() {
        for ( int i = 0; i < matchCount; i++ )
            matches[i].showResult();
    }

    public int findClubIndex( int id ) {
        for ( int i = 0; i < clubCount; i++ ) {
            if( id == clubs[i].getId() ) {
                return i;
            }
        }
        return -1;
    }

    public void setPoints() {
        //first set all point array element 0
        for( int i = 0; i < clubCount; i++ ) {
            points[i] = 0;
        }
    }
}