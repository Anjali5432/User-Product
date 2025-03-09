package com.user.uapp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    void testDefaultConstructor() {
        User user = new User();
        assertNotNull(user);
        assertEquals(0, user.getId());
        assertNull(user.getFirstName());
        assertNull(user.getLastName());
        assertNull(user.getEmail());
        assertEquals(0, user.getAge());
        assertEquals(0, user.getPid());
    }

    @Test
    void testParameterizedConstructor() {
        User user = new User(1L, "Aarav", "Sharma", "aarav.sharma@example.com", 30, 1);
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("Aarav", user.getFirstName());
        assertEquals("Sharma", user.getLastName());
        assertEquals("aarav.sharma@example.com", user.getEmail());
        assertEquals(30, user.getAge());
        assertEquals(1, user.getPid());
    }

    @Test
    void testSettersAndGetters() {
        User user = new User();
        user.setId(1L);
        user.setFirstName("Aarav");
        user.setLastName("Sharma");
        user.setEmail("aarav.sharma@example.com");
        user.setAge(30);
        user.setPid(1);

        assertEquals(1L, user.getId());
        assertEquals("Aarav", user.getFirstName());
        assertEquals("Sharma", user.getLastName());
        assertEquals("aarav.sharma@example.com", user.getEmail());
        assertEquals(30, user.getAge());
        assertEquals(1, user.getPid());
    }

    @Test
    void testToString() {
        User user = new User(1L, "John", "Doe", "john.doe@example.com", 30, 1);
        String expectedString = "User  [id=1, firstName=John, lastName=Doe, email=john.doe@example.com, age=30, pid=1]";
        assertEquals(expectedString, user.toString());
    }
}