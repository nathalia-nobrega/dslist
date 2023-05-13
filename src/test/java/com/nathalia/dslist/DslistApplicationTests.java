package com.nathalia.dslist;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DslistApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    @Test
    void shouldReturnAGame() {
        ResponseEntity<String> res = restTemplate.getForEntity("/games/1", String.class);
        Assertions.assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldReturnTitleOfAGame() {
        String res = restTemplate.getForEntity("/games/5", String.class).getBody();
        DocumentContext documentContext = JsonPath.parse(res);
        String title = documentContext.read("$.title");
        Assertions.assertThat(title).isNotNull();
    }


}
