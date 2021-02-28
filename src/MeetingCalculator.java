import java.util.ArrayList;
import java.util.List;

public class MeetingCalculator {

    public static String convertMinutesToString(int minutes){
        int hours = 0;
        int minut = 0;
        for (int i = 0; i <minutes ; i++){
            minut++;
            if(minut==60){
                hours++;
                minut=0;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        String hoursStr = String.valueOf(hours);
        String minutesStr = String.valueOf(minut);
        if(hours<10){
            stringBuffer.append("0");
        }
        stringBuffer.append(hoursStr);
        stringBuffer.append(":");
        if(minut<10){
            stringBuffer.append("0");
        }
        stringBuffer.append(minutesStr);

        String display = stringBuffer.toString();

        return display;
    }


    public static String convertionToDisplay(List<Integer>minutes , int timeDuration){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        int multiplicator = 1;
        List<Integer> used = new ArrayList<>();

        for (int minut:minutes
             ) {
            if(minutes.contains(minut+timeDuration)){
                multiplicator++;
                used.add(minut);
            }if(!used.contains(minut)) {
                stringBuffer.append("[");
                stringBuffer.append(convertMinutesToString(minut - timeDuration * multiplicator));
                stringBuffer.append(",");
                stringBuffer.append(convertMinutesToString(minut));
                stringBuffer.append("], ");
                multiplicator = 1;
            }
        }

        if(stringBuffer.length()>2){
            stringBuffer.delete(stringBuffer.length()-2,stringBuffer.length());

        }
        stringBuffer.append("]");

        return stringBuffer.toString();
    }



    public static int getMinutes(String time){
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int minutes = Integer.parseInt(split[1]);

        for (int i =0; i < hours; i++){
            minutes = minutes + 60;
        }
        return minutes;
    }

    public static String timeCalculator(Person person1 , Person person2 , String timeDuration){

        List<Integer>totalMinutesInDay = new ArrayList<>();
        List<Integer>totalMinutesOfWorkingPerson1 = new ArrayList<>();
        List<Integer>totalMinutesOfWorkingPerson2 = new ArrayList<>();
        List<Integer>workingTime1 = new ArrayList<>();
        List<Integer>workingTime2 = new ArrayList<>();
        List<Integer>freeMinutes = new ArrayList<>();
        List<Integer>possibleTimeMeeting = new ArrayList<>();

        for (int i = 1; i<=1440 ; i++){
            totalMinutesInDay.add(i);
        }
        for (int i = getMinutes(person1.workingHours.start) ; i<= getMinutes(person1.workingHours.end) ; i++){
            totalMinutesOfWorkingPerson1.add(i);
        }
        for (int i = getMinutes(person2.workingHours.start) ; i<= getMinutes(person2.workingHours.end) ; i++){
            totalMinutesOfWorkingPerson2.add(i);
        }



        for (Time time:person1.getPlannedMeetings()
             ) {for (int i = getMinutes(time.start)+1 ; i< getMinutes(time.end) ; i++){
                 workingTime1.add(i);
        }
        }

        for (Time time:person2.getPlannedMeetings()
        ) {for (int i = getMinutes(time.start)+1 ; i< getMinutes(time.end) ; i++){
            workingTime2.add(i);
        }
        }


        for(int i = 1; i<=1440 ; i++){
            if(totalMinutesOfWorkingPerson1.contains(i) && totalMinutesOfWorkingPerson2.contains(i)
            && (!workingTime1.contains(i)) && (!workingTime2.contains(i))){
                freeMinutes.add(i);
            }
        }

        int timeMeeting = getMinutes(timeDuration);
        int timeToAdd = 0;

        int i = 0;

        for (int minutes:freeMinutes
             ) {if(i == minutes-1){
                 timeToAdd++;
                 if(timeToAdd==timeMeeting){
                     possibleTimeMeeting.add(minutes);
                     timeToAdd=0;
                 }
        }else {timeToAdd=0;}

            i = minutes;

        }

        return convertionToDisplay(possibleTimeMeeting,timeMeeting);
    }


}
