public class Participant {

      /*
    we define the points values :
    'love'=0, 'fifteen'=1, 'thirty'=2, 'fourty'=3, 'advantage'=4, 'deuce'=5
    */

   private int point;
   private int score;
   private int ID;
   private String state;

    Participant(int id){
        point = 0;
        score = 0;
        state="Love";
        ID=id;

    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void addOnePoint(){
        point++;
    }

    public void addOneScore(){
        score++;
    }

    public String getState(){return state;}

    public void setState(String sta){state=sta;}

}
