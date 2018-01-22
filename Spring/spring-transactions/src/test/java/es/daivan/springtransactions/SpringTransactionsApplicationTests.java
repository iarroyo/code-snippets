package es.daivan.springtransactions;

import es.daivan.springtransactions.domain.Person;
import es.daivan.springtransactions.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTransactionsApplicationTests {

    @Autowired
    private PersonService personService;

    @Test
    public void contextLoads() {

        Assert.assertNotNull(personService);
        Person p = personService.createRandomPerson();
        Assert.assertNotNull(p);
    }

}
