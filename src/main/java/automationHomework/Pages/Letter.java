package automationHomework.Pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Letter {
    private String to, subject, body, date;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
       date = format.format(new Date());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter = (Letter) o;
        return Objects.equals(subject, letter.subject) &&
                Objects.equals(date, letter.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subject, date);
    }

    public Letter(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
