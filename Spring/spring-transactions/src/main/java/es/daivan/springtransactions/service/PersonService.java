package es.daivan.springtransactions.service;

import es.daivan.springtransactions.domain.Person;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Random;

@Service
public class PersonService {

    private final ApplicationEventPublisher applicationEventPublisher;

    public PersonService(@Autowired ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public Person createRandomPerson() {
        Person p = new Person(RandomStringUtils.randomAlphabetic(10), new Random(100).nextInt());
        this.applicationEventPublisher.publishEvent(p);
        return p;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onCreatePerson(Person person) {
        person.addClass(this.getClass());
    }


}
