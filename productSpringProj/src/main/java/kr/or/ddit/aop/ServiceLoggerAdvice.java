package kr.or.ddit.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/*		Aspect(애스팩트) : AOP의 단위가 되는 횡단 관심사
 	- 횡단 관심사(Cross_cutting Concern) :  핵심(core) 비지니스 로직(삼겹살 구어먹기)과
 			다소 거리가 있으나, 여러 모듈에서 공동적이고 반복적인 처리를 요구하는 내용(불판닦이, 불판교체)
 	- 횡단 관심사 분리(Seperation Cross_cutting Concern) 
 			: 횡단 관심사에 해당하는 부분(불판닦이, 불판교체, 빵또아의 빵)을 분리해서 한 곳으로 모으는 것을 의미
 	- Component : 골뱅이Aspect와 짝궁. component-scan 시 "여기 봐주세요"라는 의미
 	- JoinPoint(메소드) : 어드바이스가 적용될 수 있는 위치
 	- Advice : 어떤 부가기능(불판닦기)을 언제(삼겹살을 굽기 전(Before)에) 사용할지 정의
 				* 언제?
 					- Before : 조인포인트(메소드) 전에 실행
 					- After :  조인포인트(메소드) 처리 완료 후
 					- Around :  조인포인트 전후에 실행
 					- After Returning : 조인포인트가 정상적으로 종료 후 실행
 					- After Throwing : 조인포인트에서 예외 발생 시 실행. 예외가 발생안되면 실행 안함
 */

@Slf4j
@Component
@Aspect
public class ServiceLoggerAdvice {
	// execution : 포인트컷(대상(메소드)를 선별하는 것) 지정자
	// * : 임의의 1개
	// .. : 임의의 0개 이상
	//  kr.or.ddit.*..*(..) : 패키지 밑에 각각의 패키지( kr.or.ddit.*)가 있고 그 하위에 모든 파일/패키지(..)
	// 각각의 메소드가 있고(*), 모든 파라미터((..))  => kr.or.ddit안에 있는 모든 것 
	@Before("execution(* kr.or.ddit.*..*(..))")
	public void startLog(JoinPoint jp) {
		log.info("startLog : ");

		// .getSignature() : 어떤 클래스의 어떤 메서드가 실행되었는지 보여줌. 파라미터 타입은?
		// public MemberVO read(String memId)
		log.info("startLog : " + jp.getSignature());
		
		// .getArgs() : 전달 된 파라미터 정보를 보여줌
		// {"memId" : "a001"}
		log.info("startLog : " +  Arrays.toString(jp.getArgs()));
	}
	
	// 조인 포인트(메소드)가 정상적으로 종료된 후에 실행 됨. 예외 발생 시 실행 안 됨
	@AfterReturning("execution(* kr.or.ddit.*..*(..))")
	public void logReturning(JoinPoint jp) {
		log.info("logReturning");
		
		// .getSignature() : 어떤 클래스의 어떤 메서드가 실행되었는지 보여줌. 파라미터 타입은?
		// public MemberVO read(String memId)
		log.info("logReturning : " + jp.getSignature());
		
		// .getArgs() : 전달 된 파라미터 정보를 보여줌
		// {"memId" : "a001"}
		log.info("logReturning : " +  Arrays.toString(jp.getArgs()));
	}
	
	// 어드바이스 
	// 조인 포인트(메소드)에서 예외 발생 시 실행. 예외가 발생 안되면 실행 안 됨
	@AfterThrowing(pointcut="execution(* kr.or.ddit.*..*(..))", throwing="e")
	public void logException(JoinPoint jp, Exception e) {
		log.info("logException");
		
		// .getSignature() : 어떤 클래스의 어떤 메서드가 실행되었는지 보여줌. 파라미터 타입은?
		// public MemberVO read(String memId)
		log.info("logException : " + jp.getSignature());
		
		// .getArgs() : 전달 된 파라미터 정보를 보여줌
		// {"memId" : "a001"}
		log.info("logException : " +  e);
	
	}
	
	// 어드바이스
	// 조인 포인트 완료 후 실행. 예외 발생이 되더라도 항상 실행됨
	@After("execution(* kr.or.ddit.*..*(..))")
	public void endLog(JoinPoint  jp) {
		log.info("endLog");
		
		// .getSignature() : 어떤 클래스의 어떤 메서드가 실행되었는지 보여줌. 파라미터 타입은?
		// public MemberVO read(String memId)
		log.info("endLog : " + jp.getSignature());
		
		// .getArgs() : 전달 된 파라미터 정보를 보여줌
		// {"memId" : "a001"}
		log.info("endLog : " +  Arrays.toString(jp.getArgs()));
		
	}
	// 어드바이스
	// 조인포인트(메소드) 실행 전/후에 실행 됨
	@Around("execution(* kr.or.ddit.*..*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable {
		// 1) 메소드가 실행하기 직전 시간 체킹
		long startTime = System.currentTimeMillis();
		log.info("pjpStart : " + Arrays.toString(pjp.getArgs()));
		
		// 2)  메소드 실행
		Object result = pjp.proceed();
		
		// 3) 메소드가 실행된 직후 시간 체킹
		long endTime = System.currentTimeMillis();
		log.info("pjpEnd : " + Arrays.toString(pjp.getArgs()));
		
		// 4) 메소드가 실행 시간(pjp.getSignature().getName() : 메소드 명)
		log.info(pjp.getSignature().getName() + " : " + (endTime -startTime));
		
		return result;
	}
}





















