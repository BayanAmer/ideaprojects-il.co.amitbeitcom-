import groovy.util.logging.Log;

import java.lang.*;

public class Tennis {

    private Participant participant1;
    private Participant participant2;
    private String stateArr[]={"Love","Fifteen","Thirty","Forty","Advantage","Deuce"};

    Tennis(Participant p1, Participant p2){
        participant1=p1;
        participant2=p2;
    }

    public void addPoint(Participant par){
            par.addOnePoint();

    }

    public String updateParticipantPoints(int p1, int p2){
        String res="";
        participant1.setPoint(p1);
        participant2.setPoint(p2);

        if (participant1.getPoint()<= 3 && participant2.getPoint() <= 3){
            participant1.setState(stateArr[p1]);
            participant2.setState(stateArr[p2]);
            res = participant1.getState() + "-" + participant2.getState();
            if ((participant2.getPoint()==participant1.getPoint())&&(participant1.getPoint()==3))
                res = stateArr[5];
        }else {
            if (participant1.getPoint()-participant2.getPoint()>=2) {
                res = "Win for player1";
          //      participant1.addOneScore();
            //    participant1.setPoint(0);
              //  participant1.setState("Love");
            }
            else if(participant2.getPoint()-participant1.getPoint()>=2) {
                res = "Win for player2";
                //participant2.addOneScore();
               // participant2.setPoint(0);
               // participant2.setState("Love");
            }
            if (participant1.getPoint()-participant2.getPoint()==1)
                res = stateArr[4] + " player1";
            else if(participant2.getPoint()-participant1.getPoint()==1)
                res = stateArr[4] + " player2";

            if (participant1.getPoint()==participant2.getPoint())
                res=stateArr[5];
        }{
            if (participant1.getPoint()-participant2.getPoint()>=2) {
                res = "Win for player1";
          //      participant1.addOneScore();
            //    participant1.setPoint(0);
              //  participant1.setState("Love");
            }
            else if(participant2.getPoint()-participant1.getPoint()>=2) {
                res = "Win for player2";
                //participant2.addOneScore();
               // participant2.setPoint(0);
               // participant2.setState("Love");
            }
            if (participant1.getPoint()-participant2.getPoint()==1)
                res = stateArr[4] + " player1";
            else if(participant2.getPoint()-participant1.getPoint()==1)
                res = stateArr[4] + " player2";

            if (participant1.getPoint()==participant2.getPoint())
                res=stateArr[5];
        }
        return res;
    }


    public Participant getParticipant1() {
        return participant1;
    }

    public Participant getParticipant2() {
        return participant2;
    }
}
