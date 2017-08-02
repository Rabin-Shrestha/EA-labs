package cs544.exercise6_1.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

import cs544.exercise6_1.EmailSender;

@Aspect
public class TraceAdvice {

	private static Logger logger = Logger.getLogger(TraceAdvice.class);

	// @After("execution(public void sendEmail(*,*))")
	@After("execution(public void sendEmail(String, String)) && args(email, message)") 
	public void traceAfterMethod(JoinPoint joinpoint, String email, String message){
		logger.info("method= "+joinpoint.getSignature().getName()+" address = "+ email+" message = "+ message);
		EmailSender emailSender = (EmailSender) joinpoint.getTarget();
		logger.info("outgoing mail server = "+emailSender.getOutgoingMailServer());
    }
	
	@Around("execution(public void save(*))")
	public Object invoke(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		
		long totaltime = sw.getLastTaskTimeMillis();
		System.out.println("Time to execute save = "+totaltime+" ms");
		return retVal;
	}
}
