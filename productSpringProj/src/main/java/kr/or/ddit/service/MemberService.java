package kr.or.ddit.service;

import kr.or.ddit.vo.MemberVO;

public interface MemberService {

	//메서드 시그니처
	// 회원 로그인 확인
	public MemberVO read(String memId);

}
