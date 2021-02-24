package ses;

public class EmailRequest {
    public String to;
    public String from;
    public String subject;
    public String textBody;
    public String htmlBody;

    public EmailRequest(String to, String from, String subject, String textBody, String htmlBody) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.textBody = textBody;
        this.htmlBody = htmlBody;
    }

    public EmailRequest() {
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }
}
