package kr.study.springboot.hello;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class HelloApiTest {

    @Test
    void helloApi() {
        // http localhost:8080/hello?name=Spring
        // RestTemplate은 에러 발생시 예외를 발생시킴
        // TestRestTemplate은 순수 http 에러코드를 리턴
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> ret = restTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, "dukim");
        // status code 200
        assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.OK);
        // headers content-type text/plain
        assertThat(ret.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        // body Hello dukim
        assertThat(ret.getBody()).isEqualTo("*Hello dukim*");
    }

    @Test
    void failsNullHelloApi() {
        // http localhost:8080/hello?name=Spring
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> ret = restTemplate.getForEntity("http://localhost:8080/hello?name=", String.class);
        // status code 200
        assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void failsEmptyHelloApi() {
        // http localhost:8080/hello?name=Spring
        TestRestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> ret = restTemplate.getForEntity("http://localhost:8080/hello?name={name}", String.class, "");
        // status code 200
        assertThat(ret.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
