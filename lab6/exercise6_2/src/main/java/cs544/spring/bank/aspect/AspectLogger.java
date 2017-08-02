package cs544.spring.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

import cs544.spring.bank.jms.IJMSSender;
import cs544.spring.bank.logging.ILogger;

@Aspect
public class AspectLogger {

	//private static Logger logger = Logger.getLogger(AspectLogger.class);
	@Autowired
	ILogger logger;
	@Autowired
	IJMSSender jmssender;
	
	
	@Before("loggerPoint() || jmsMessage()")
	public void logger(JoinPoint joinpoint){
		//logger.info("Running bank dao methods: "+joinpoint.getSignature().getName());
		logger.log("Running bank "+ joinpoint.getSignature().getName() +"methods: "+joinpoint.getSignature().getName());
	}
	
	@Pointcut("execution(* cs544.spring.bank.dao.AccountDAO.*(*))")
	public void loggerPoint(){}
	
	@Pointcut("execution(* cs544.spring.bank.jms.JMSSender.*(*))")
	public void jmsMessage(){}
}
