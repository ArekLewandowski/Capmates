package com.capgemini.alewandowskiMock;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.capgemini.alewandowski.*;
import com.capgemini.alewandowski.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
CapmatesApplication.class} , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CupmatesMockTest {
	
	@Test
    public void showUserTest() {
        // given
        TestRestTemplate restTemplate = new TestRestTemplate();
        String fooResourceUrl = "http://localhost:8080/users";

        // when
        ResponseEntity<User> response = restTemplate.getForEntity(fooResourceUrl + "/2", User.class);

        // then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals("John", response.getBody().getFirstName());
    }

	@Test
    public void showUserDeleteTest() {
        // given
        TestRestTemplate restTemplate = new TestRestTemplate();
        String fooResourceUrl = "http://localhost:8080/users";

        // when
        restTemplate.delete(fooResourceUrl + "/2", User.class);

        // then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals("John", response.getBody().getFirstName());
    }

	@Test
    public void showUsers() {
        // given
        TestRestTemplate restTemplate = new TestRestTemplate();
        String fooResourceUrl = "http://localhost:8080/users";

        // when
        ResponseEntity<List<User>> response = restTemplate.getForEntity(fooResourceUrl, List<User.class>);

        // then
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals("John", response.getBody().);
    }


}