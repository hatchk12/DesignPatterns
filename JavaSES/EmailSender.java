package ses;

// these are the imports for SDK v1
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.simpleemail.*;
import com.amazonaws.services.simpleemail.model.*;
import com.amazonaws.regions.Regions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmailSender {
    public EmailResult handleRequest(EmailRequest request, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log("Entering send_email");
        SendEmailResult response;
        try {
            AmazonSimpleEmailService client =
                    AmazonSimpleEmailServiceClientBuilder.standard()

                            .withRegion(Regions.US_EAST_2).build();


            // Use the AmazonSimpleEmailService object to send an email message
            // using the values in the EmailRequest parameter object
            Message message = new Message(new Content(request.subject),new Body(new Content(request.textBody + request.htmlBody)));
            List<String> to = new ArrayList<>();
            to.add(request.to);
            SendEmailRequest email = new SendEmailRequest(request.from, new Destination(to),message);
            response = client.sendEmail(email);
            logger.log("Email sent!");
        } catch (Exception ex) {
            logger.log("The email was not sent. Error message: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
        finally {
            logger.log("Leaving send_email");
        }
        LocalDateTime date = LocalDateTime.now();
        String timeStamp = date.toString();
        EmailResult result = new EmailResult(response.getMessageId(),timeStamp);
        return result;
    }

}
