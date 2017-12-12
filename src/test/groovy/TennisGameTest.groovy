import spock.lang.Specification

class TennisGameTest extends Specification {
////////////////////////////////point activities//////////////////////////////////////////
    /*
    we define the points values :
    'love'=0, 'fifteen'=1, 'thirty'=2, 'fourty'=3, 'advantage'=4, 'deuce'=5
    */
    /* def "check if the two participants start the game with point 0 'love'"(){

        given: "participant1 and participant2"
        Participant participant1
        Participant participant2

        when: "creating the participants"
        participant1=new Participant(1)
        participant2=new Participant(2)

        then: "the value of Participant1 and Participant2 point is 0"
        participant1.getPoint()==0
        and:
        participant2.getPoint()==0
    }


    def "#addOnePoint adds one point to a participant "(){

        given: "participant with 0 points"
        Participant participant=new Participant(1)

        when: "#addOnePoint"
        participant.addOnePoint()

        then: "participant point is 1"

        participant.getPoint() == 1
    }


    def "#addPoint adds one point to participant"(){

        given: "Tennis tennisGame"
        Tennis tennisGame = new Tennis()//we should build the tennis constructor with dependency injection

        when: "adding a one point to the participant points"
        tennisGame.addPoint(tennisGame.getParticipant1())

        then: "the value of Participant point after addPoint() is 1 'fifteen'"
        tennisGame.getParticipant1().getPoint() == 1
    }


    def "#addPoint correctly adds point to tennis game participant with 'fifteen' point"(){

        given: "create Tennis tennisGame"
        Tennis tennisGame = new Tennis();

        when: "set particpant point 1 and add one point"
        tennisGame.getParticipant1().setPoint(1)
        tennisGame.addPoint(tennisGame.getParticipant1())

        then: "the value of Participant point after addPoint() is 2"

        tennisGame.participant1.getPoint() == 2
    }


    def "#addPoint correctly adds point to tennis game participant with 'thirty' point"(){

        given: "Tennis tennisGame"
        Tennis tennisGame = new Tennis();

        when: "adding one a point to the participant with point equal 2 "
        tennisGame.getParticipant1().setPoint(2)
        tennisGame.addPoint(tennisGame.getParticipant1())

        then: "the value of Participant point after addPoint() is 3"

        tennisGame.participant1.getPoint() == 3
    }


    def "#addPoint adds point to particpant with at least 3 points and at least 2 points difference between the both participant"(){

        given: "create Tennis tennisGame"
        Tennis tennisGame = new Tennis();

        when: "participant1 point is 2 and participant2 point is 3"
        tennisGame.getParticipant1().setPoint(3)
        tennisGame.getParticipant2().setPoint(2)
        tennisGame.addPoint(tennisGame.getParticipant1())

        then: "the value of participants point after addPoint() is 0 and participant1 score is 1"

        tennisGame.participant1.getPoint() == 0 && tennisGame.participant2.getPoint() == 0 && tennisGame.participant2.getScore() == 1
    }


    def "#addPoint with two participants point 'forty'"(){

        given: "create Tennis tennisGame"
        Tennis tennisGame = new Tennis();

        when: "paticipants point 3 'forty'"
        tennisGame.getParticipant1().setPoint(3)
        tennisGame.getParticipant2().setPoint(3)
        tennisGame.addPoint(tennisGame.getParticipant1())

        then: "the participant1 point after addPoint() is 4 'advantage' "

        tennisGame.participant1.getPoint() == 4 && tennisGame.participant2.getPoint() == 3

    }


    def "#addPoint adds to the participant2 with point is 'fourty' and participant1 is 'advantage'"(){

        given: "create Tennis tennisGame"
        Tennis tennisGame = new Tennis();

        when: "paticipants point 3 'forty'"
        tennisGame.getParticipant1().setPoint(4)
        tennisGame.getParticipant2().setPoint(3)
        tennisGame.addPoint(tennisGame.getParticipant2())

        then: "the participants point is 5 'deuce'"

        tennisGame.participant1.getPoint() == 5 && tennisGame.participant2.getPoint() == 5
    }


////////////////////////////////score activities//////////////////////////////////////////
    def "two participants start the game with score 0"(){

        given: "two Participant participant1 and participant2"
        Participant participant1
        Participant participant2

        when: "create the participants"
        participant1=new Participant(1)
        participant2=new Participant(2)

        then: "the value of Participant1 and Participant2 is 0"
        participant1.getScore()==0 && participant2.getScore()==0
    }


    def "#addOneScore adds 1 score to the correct participant score"(){

        given: "participant "
        Participant participant=new Participant(1)

        when: "participant wins score addOnePoint adds one score to the participant"
        participant.addOneScore()

        then: "the value of participant score after addScore() is 1"

        participant.getScore() == 1
    }
*/

    def "Check all scores"() {
        given:
        Participant participant1 = Mock()
        Participant participant2 = Mock()
        def result = ""

        when:
        Tennis tennis = new Tennis(participant1,participant2)
        result = tennis.updateParticipantPoints(p1,p2)

        then:
        1 * participant1.setPoint(p1)
        1 * participant1.getState() >> p1Text // Stubbing
        1 * participant2.getState() >> p2Text
        result.equals(state)

        where:
        p1 | p2 | p1Text | p2Text | state
        0  | 0  | "Love" | "Love" | "Love-Love"
        1  | 1  | "Fifteen" | "Fifteen" | "Fifteen-Fifteen"
        2  | 2  | "Thirty" | "Thirty" | "Thirty-Thirty"
//        3  | 3  | "Deuce"
//        4  | 4  | "Deuce"
//        1  | 0  | "Fifteen-Love"
//        0  | 1  | "Love-Fifteen"
//        2  | 0  | "Thirty-Love"
//        0  | 2  | "Love-Thirty"
//        3  | 0  | "Forty-Love"
//        0  | 3  | "Love-Forty"
//        4  | 0  | "Win for player1"
//        0  | 4  | "Win for player2"
//
//        2  | 1  | "Thirty-Fifteen"
//        1  | 2  | "Fifteen-Thirty"
//        3  | 1  | "Forty-Fifteen"
//        1  | 3  | "Fifteen-Forty"
//        4  | 1  | "Win for player1"
//        1  | 4  | "Win for player2"
//
//        3  | 2  | "Forty-Thirty"
//        2  | 3  | "Thirty-Forty"
//        4  | 2  | "Win for player1"
//        2  | 4  | "Win for player2"
//
//        4  | 3  | "Advantage player1"
//        3  | 4  | "Advantage player2"
//        5  | 4  | "Advantage player1"
//        4  | 5  | "Advantage player2"
//        15 | 14 | "Advantage player1"
//        14 | 15 | "Advantage player2"
//
//        6  | 4  | "Win for player1"
//        4  | 6  | "Win for player2"
//        16 | 14 | "Win for player1"
//        14 | 16 | "Win for player2"

    }

}