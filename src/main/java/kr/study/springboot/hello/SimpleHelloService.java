package kr.study.springboot.hello;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SimpleHelloService implements HelloService {
    final HelloRepository helloRepository;

    public SimpleHelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }


    @Override
    @Transactional
    public String sayHello(String name) {
        helloRepository.increaseCount(name);
        return "Hello " + name;
    }

    @Override
    public Integer countOf(String name) {
        return helloRepository.countOf(name);
    }
}
