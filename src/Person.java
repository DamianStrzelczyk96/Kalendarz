import java.util.ArrayList;
import java.util.List;

public class Person {

    WorkingHours workingHours;
    List<Time>plannedMeetings = new ArrayList<>();

    public Person(WorkingHours workingHours, List<Time> plannedMeetings) {
        this.workingHours = workingHours;
        this.plannedMeetings = plannedMeetings;
    }

    public Person() {
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public List<Time> getPlannedMeetings() {
        return plannedMeetings;
    }

    public void setPlannedMeetings(List<Time> plannedMeetings) {
        this.plannedMeetings = plannedMeetings;
    }
    public void addPlannedMeeting(Time time){
        plannedMeetings.add(time);
    }



    @Override
    public String toString() {
        return "Person{" +
                "workingHours=" + workingHours +
                ", plannedMeetings=" + plannedMeetings +
                '}';
    }
}
