public class WorkingHours {
    String start;
    String end;


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
        return "WorkingHours{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
