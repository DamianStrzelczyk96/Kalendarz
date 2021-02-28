import java.time.LocalTime;

public class Main {

    public static int getMinutes(String time){
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);

        for (int i =0; i < hours; i++){
            minutes = minutes + 60;
        }
        return minutes;
    }

    public static void main(String[] args) {

        Person person1 = new Person();
        Person person2 = new Person();

        WorkingHours WHperson1 = new WorkingHours();
        WHperson1.start = "09:00";
        WHperson1.end = "19:55";

        WorkingHours WHperson2 = new WorkingHours();
        WHperson2.start = "10:00";
        WHperson2.end = "18:30";

        person1.setWorkingHours(WHperson1);
        person2.setWorkingHours(WHperson2);

        Time time1 = new Time("09:00","10:00");
        Time time2 = new Time("12:00","13:00");
        Time time3 = new Time("16:00","18:00");


        Time xtime1 = new Time("10:00","11:30");
        Time xtime2 = new Time("12:30","14:30");
        Time xtime3 = new Time("14:30","15:00");
        Time xtime4 = new Time("16:00","17:00");


        person1.addPlannedMeeting(time1);
        person1.addPlannedMeeting(time2);
        person1.addPlannedMeeting(time3);


        person2.addPlannedMeeting(xtime1);
        person2.addPlannedMeeting(xtime2);
        person2.addPlannedMeeting(xtime3);
        person2.addPlannedMeeting(xtime4);

        System.out.println(MeetingCalculator.timeCalculator(person1,person2,"00:30"));




    }




}
