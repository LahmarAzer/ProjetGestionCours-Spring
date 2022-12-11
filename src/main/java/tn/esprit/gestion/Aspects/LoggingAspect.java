package tn.esprit.gestion.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

        @Before("execution( * tn.esprit.gestion.Service.*.ajouter*(..))")
        public void logMethodEntry(JoinPoint joinPoint) {
            log.info("in method "+joinPoint.getSignature().getName());
        }

        @After("execution( * tn.esprit.gestion.Service.*.ajouter*(..))")
        public void logMethodOutPut(JoinPoint joinPoint) {
        log.info("Out method "+joinPoint.getSignature().getName());
    }

    //Arround class
    /*
    @Component
@Slf4j
@Aspect
public class ArroundAspect {
    @Around("execution( * tn.esprit.aziz.Services.IEquipeServiceImp.getAllEquipe(..))")
    public List<Object> executionTime(ProceedingJoinPoint pjp) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
	    List<Object> obj = new ArrayList<Object>(); // si le type de retour est une liste
		obj = (List<Object>) pjp.proceed();
       // Object obj = pjp.proceed();

        stopWatch.stop();

        String methodName = pjp.getSignature().getName();

        log.info("The runtime of the method ( "+ methodName + " ) = " + stopWatch.getTotalTimeMillis() + " milliseconds.");

        return obj;
    }
}
    * */
}
