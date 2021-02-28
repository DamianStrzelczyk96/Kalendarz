public class Time {
    String start;
    String end;

    public Time(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public Time() {
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Time{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
