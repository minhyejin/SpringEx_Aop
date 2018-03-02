package kr.co.mhj.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//aop클래스 생성시 //component-scan에 의한 
@Component   //bean생성을 위한 annotation
@Aspect 	 //exaop클래스에 advice가 들어있다는 것을 알려준다. 순서는 상관없지만 항상 두개가 같이 있어야함 
public class ExAOP {
	//advice : 관점 지향 프로그래밍에서 부가적인 작업들 (메소드)
	@Around("execution(* kr.co.mhj.service..test*(..))")//..은 service패키지 안쪽에있는 모든 하위패키지 모든 클래스를 이야기한다. 
													    //test*은 모든 test라 적혀있는 메소드를 의미
														//test로 시작하는 0개 이상의 메소드 (있든지 없든지)
														//around 사용할 때는 항상 매게변수에 ProceedingJoinPoint가 있어야 한다.
	Object testAOP1(ProceedingJoinPoint joinPoint)throws Throwable {
		System.out.println("testAOP1-advice 실행, joinPoint 실행 이전 ");
		Object obj = null;//proceed에 의한 리턴을 받아낼 용도
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("testAOP1-advice 실행,joinPoint 실행이후 ");
		}
		return obj;
	}
	Object testBOP1(ProceedingJoinPoint joinPoint)throws Throwable{
		System.out.println("testBOP1-advice 실행, joinPoint 실행 이전");
		Object obj = null;
		try {
			obj = joinPoint.proceed();
		}finally {
			System.out.println("testBOP1-advice 실행, joinPoint 실행 이후");
		}return obj;
	}
	@Around("within(kr.co.mhj.service2..*)")
	void withInAOP(ProceedingJoinPoint joinPoint) {
		
	}
}
