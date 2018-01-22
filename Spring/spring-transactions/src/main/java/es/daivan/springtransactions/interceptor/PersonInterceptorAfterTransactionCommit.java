package es.daivan.springtransactions.interceptor;

import es.daivan.springtransactions.domain.Person;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class PersonInterceptorAfterTransactionCommit {

    @AfterReturning(pointcut = "execution(* es.daivan.springtransactions.service.PersonService.createRandomPerson())",
            returning = "person")
    public Person afterReturningOnCreatePerson(Person person) {
        person.addClass(this.getClass());
        return person;
    }
}
