package com.user.uapp.controller;

import com.user.uapp.model.APIResponse;
import com.user.uapp.model.User;
import com.user.uapp.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class UserControllerTest {

    @InjectMocks
    private UserController userController; // Injecting the UserController with mocked UserService

    @Mock
    private UserService userService; // Mocking the UserService

    private User user; // Sample User object for testing

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        user = new User(); // Create a new User object
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setAge(30);
        user.setPid(1);
    }

    @Test
    void testSaveUser () {
        // Mock the saveUser  method to return the sample user
        when(userService.saveUser (any(User.class))).thenReturn(user);

        // Call the saveUser  method in the controller
        ResponseEntity<User> response = userController.saveUser (user);

        // Assertions to verify the response
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("John", response.getBody().getFirstName());
        verify(userService, times(1)).saveUser (user); // Verify that saveUser  was called once
    }

    @Test
    void testGetAllUsers() {
        // Mock the getAllUsers method to return a list containing the sample user
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user));

        // Call the getAllUsers method in the controller
        List<User> users = userController.getAllusers();

        // Assertions to verify the response
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals("John", users.get(0).getFirstName());
        verify(userService, times(1)).getAllUsers(); // Verify that getAllUsers was called once
    }

    @Test
    void testGetUserById() {
        // Create an APIResponse containing the sample user
        APIResponse apiResponse = new APIResponse(user, null);
        // Mock the getUser ById method to return the APIResponse
        when(userService.getUserById(anyLong())).thenReturn(apiResponse);

        // Call the getUser ById method in the controller
        ResponseEntity<APIResponse> response = userController.getuserById(1L);

        // Assertions to verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("John", response.getBody().getUser ().getFirstName());
        verify(userService, times(1)).getUserById(1L); // Verify that getUser ById was called once
    }

    @Test
    void testUpdateUser () {
        // Mock the updateUser  method to return the sample user
        when(userService.updateUser (any(User.class), anyLong())).thenReturn(user);

        // Call the updateUser  method in the controller
        ResponseEntity<User> response = userController.updateuser(1L, user);

        // Assertions to verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("John", response.getBody().getFirstName());
        verify(userService, times(1)).updateUser (user, 1L); // Verify that updateUser  was called once
    }

    @Test
    void testDeleteUser () {
        // Mock the deleteUser  method to do nothing
        doNothing().when(userService).deleteUser (anyLong());

        // Call the deleteUser  method in the controller
        ResponseEntity<String> response = userController.deleteuser (1L);

        // Assertions to verify the response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("user deleted successfully!.", response.getBody()); // Ensure the message matches exactly
        verify(userService, times(1)).deleteUser (1L); // Verify that deleteUser  was called once
    }
}