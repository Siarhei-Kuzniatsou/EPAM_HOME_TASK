package TestAutomation.emailSending;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEmailSend {

    @BeforeAll
    void setup(){

    }

    @Test
    @DisplayName("Login to the mail box")
    @Order(1)
    @Disabled
    void login(){

    }


2) Assert, that the login is successful.
3) Create a new mail (fill addressee, subject and body fields).
            4) Save the mail as a draft.
            5) Verify, that the mail presents in Drafts.
            6) Verify the draft content (addressee, subject and body – should be the same as in 3).
            7) Send the mail.
8) Verify, that the mail disappeared from Drafts.
            9) Verify, that the mail is in Sent.
            10) Log off.

}
