package com.example;

import com.example.controller.UserControllerPreethika;
import com.example.dao.UserDAOPreethika;
import com.example.entity.UserEntityPreethika;
import com.example.service.UserServicePreethika;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
class UserServiceTestApplicationTests {

	@Autowired
	UserServicePreethika userServicePreethika;
	@Autowired
	UserDAOPreethika userDAOPreethika;

	@Autowired
	UserControllerPreethika userControllerPreethika;

	@Test
	void testAddUser() {
		userDAOPreethika.deleteAll();
		UserEntityPreethika user = new UserEntityPreethika(1, "Preethika");
		UserEntityPreethika savedUser = userServicePreethika.addUserPreethika(user);

		assertNotNull(savedUser);
		assertEquals(1, savedUser.getId());
		assertEquals("Preethika", savedUser.getUsername());
	}
	@Test
	void testGetUserById() {
		UserEntityPreethika user = new UserEntityPreethika(2, "Priya");
		userServicePreethika.addUserPreethika(user);

		UserEntityPreethika fetchedUser = userServicePreethika.getUserByIdPreethika(2);
		assertNotNull(fetchedUser);
		assertEquals("Priya", fetchedUser.getUsername());
	}

	// Test for GET /users/{id} when user exists
	@Test
	void testGetUserByIdPreethika() {
		// Arrange: add user first
		UserEntityPreethika user = new UserEntityPreethika(2, "Priya");
		userControllerPreethika.addUserPreethika(user);

		// Act
		ResponseEntity<UserEntityPreethika> response = userControllerPreethika.getUserByIdPreethika(2);

		// Assert
		assertEquals(200, response.getStatusCodeValue());
		assertNotNull(response.getBody());
		assertEquals(2, response.getBody().getId());
		assertEquals("Priya", response.getBody().getUsername());
	}

	@Test
	void testGetUserByIdPreethika_NotFound() {
		ResponseEntity<UserEntityPreethika> response = userControllerPreethika.getUserByIdPreethika(99);

		// Assert that the status code is 404 NOT FOUND
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode()); // because service uses .get()
	}

}

