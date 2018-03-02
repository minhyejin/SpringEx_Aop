package kr.co.mhj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.mhj.dao.TestDao;

@Service
public class TestService {
	@Autowired
	TestDao testDao;
	//실제 사용자가 호출하려 했었던 joinpoint가 된다.
	//aop를 사용함을 떠나서 프록시에 의해 대신 호출된다. (proceed()호출 시 자동으로 호출됨 )
	public String testService1() {
		System.out.println("Service 실행 - joinpoint");
		return "Hello";
	}
	
}
