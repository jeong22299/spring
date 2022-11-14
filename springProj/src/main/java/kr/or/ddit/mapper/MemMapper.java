package kr.or.ddit.mapper;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberListVO;

public interface MemMapper {
	// 글 목록 
	public  List<MemberListVO> memList(Map<String, String> map);

	//  MEM 테이블의 전체 행의 수 구함 
	public int getTotal(Map<String, String> map);
	
	// 게시판 등록
	public int memInsert(MemberListVO memVO);

	// 아이디 중복 체크
	public int chkDup(String memId);
	
	// 상세보기
	public MemberListVO detail(String memId);
}
