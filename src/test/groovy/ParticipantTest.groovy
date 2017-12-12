

class ParticipantTest extends Specification{

    def "#addOnePoint adds one point to a participant "(){

        given: "participant with 0 points"
        Participant participant=new Participant(1)

        when: "#addOnePoint"
        participant.addOnePoint()

        then: "participant point is 1"

        participant.getPoint() == 1
    }



}
