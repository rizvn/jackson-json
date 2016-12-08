package model.elec;

import model.base.Group;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class D0062 extends Group {
    private String J0003;
    private String J0010;
    private String J0012;
    private LocalDate theDate;
    private LocalTime theTime;
    private LocalDateTime theDateTime;

    public String getJ0003() {
        return J0003;
    }

    public void setJ0003(String j0003) {
        J0003 = j0003;
    }

    public String getJ0010() {
        return J0010;
    }

    public void setJ0010(String j0010) {
        J0010 = j0010;
    }

    public String getJ0012() {
        return J0012;
    }

    public void setJ0012(String j0012) {
        J0012 = j0012;
    }

    public LocalDate getTheDate() {
        return theDate;
    }

    public void setTheDate(LocalDate theDate) {
        this.theDate = theDate;
    }

    public LocalTime getTheTime() {
        return theTime;
    }

    public void setTheTime(LocalTime theTime) {
        this.theTime = theTime;
    }

    public LocalDateTime getTheDateTime() {
        return theDateTime;
    }

    public void setTheDateTime(LocalDateTime theDateTime) {
        this.theDateTime = theDateTime;
    }
}