package kr.study.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;

class HelloApiTest {

    @Test
    void helloApiTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> ret = restTemplate.getForEntity("http://localhost:8080/hello?name=dukim", String.class);

        // status code 200
        assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.OK);
        // headers content-type text/plain
        assertThat(ret.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello dukim
        assertThat(ret.getBody()).isEqualTo("*Hello dukim*");
    }

    @Test
    void helloApiNullTest() {
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> ret = restTemplate.getForEntity("http://localhost:8080/hello?name=", String.class);

        // status code 200
        assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
