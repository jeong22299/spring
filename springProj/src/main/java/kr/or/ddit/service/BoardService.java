package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemberListVO;

// 서비스 interface : 비지니스 로직
public interface BoardService {

	// 게시판 목록보기
	public List<MemberListVO> list(Map<String, String> map);

	//  MEM 테이블의 전체 행의 수 구함 
	public int getTotal(Map<String, String> map);
	
	// 게시판 등록하기
	public int insert(MemberListVO memVO);

	// 아이디 중복체크
	public int chkDup(String memId);


}
