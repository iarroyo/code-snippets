package es.daivan.springtransactions.interceptor;

import es.daivan.springtransactions.domain.Person;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonInterceptorBeforeTransactionCommit {

    @AfterReturning(pointcut = "execution(* es.daivan.springtransactions.service.PersonService.createRandomPerson())",
            returning = "person")
    public Person afterReturningOnCreatePerson(Person person) {
        person.addClass(this.getClass());
        return person;
    }
}
