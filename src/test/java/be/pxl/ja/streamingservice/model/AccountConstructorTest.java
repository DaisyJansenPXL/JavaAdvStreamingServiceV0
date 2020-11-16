package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountConstructorTest {

    @Test
    public void returnsProfileWithNameProfile1WhenMakingAnAccount() {
        Account account = new Account("email@email.com", "password");

        assertNotNull(account.getFirstProfile());
        assertEquals("profile1", account.getFirstProfile().getName());
    }
}
