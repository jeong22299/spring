package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.ddit.dao.BoardDao;
import kr.or.ddit.service.BoardService;
import kr.or.ddit.service.BookService;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.MemberListVO;

// "프링아 이 클래스는 서비스 클래스야"라고 스프링에게 알려줌.
// 프링이가 자바빈으로 등록해줌
@Service
public class BoardServiceImpl implements BoardService {
	// DI : 의존성주입
	// 데이터베이스 접근을 위해 BookDao 인스턴스를 주입받자
	@Autowired
	BoardDao boardDao;
	
	@Inject
	FileUploadUtil fileUploadUtil;
	
	// 게시판 목록보기
	@Override
	public List<MemberListVO> list(Map<String, String> map){
		return this.boardDao.list(map);
	}
	
	//  MEM 테이블의 전체 행의 수 구함 
	@Override
	public int getTotal(Map<String, String> map) {
		return this.boardDao.getTotal(map);
	}
	
	// 게시판 등록
	@Transactional    // 프링아 트랜잭션 처리를 해주렴
	@Override
	public int insert(MemberListVO memVO) {
		// MEM 테이블에 insert
		this.boardDao.insert(memVO);
		// FileUploadUtil 활용 => 업로드, ATTACH 테이블에 INSERT
		return this.fileUploadUtil.fileUploadAction(memVO.getPictureArray(), memVO.getMemId());
		
	}
	
	// 아이디 중복 체크
	@Override
		public int chkDup(String memId) {
			return this.boardDao.chkDup(memId);
		}
}
