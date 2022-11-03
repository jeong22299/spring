package kr.or.ddit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import kr.or.ddit.dao.ProductDao;
import kr.or.ddit.service.ProductService;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.AttachVO;
import kr.or.ddit.vo.CartVO;
import kr.or.ddit.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;

// "프링아 이 클래스는 서비스 클래스야"라고 스프링에게 알려줌.
// 프링이가 자바빈으로 등록해줌
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
	// DI : 의존성주입
	// 데이터베이스 접근을 위해 BookDao 인스턴스를 주입받자
	@Autowired
	ProductDao productDao;
	
	@Autowired
	FileUploadUtil fileUploadUtil;
	
	@Override
	public int insert(ProductVO productVO) {
		// PRODUCT 테이블에 INSERT
		int result = this.productDao.insert(productVO);
		// ATTACH 테이블에 다중 INSERT
		if(result > 0) { // INSERT 성공 시
			// 파일업로드 및 INSERT수행 => 안됨
//			FileUploadUtil.fileUploadAction(productVO.getProductImage(), productVO.getProductId());
			// 파일업로드 및 INSERT수행
			fileUploadUtil.fileUploadAction(productVO.getProductImage(), productVO.getProductId());
		}
		return result;
	}
	
	// 상품 목록
	@Override
	public List<ProductVO> list(String keyword){
		return this.productDao.list(keyword);
	}
	
	// 상품 상세보기
	public ProductVO selectDetail(ProductVO productVO) {
		return this.productDao.selectDetail(productVO);
	}

	// 상품 수정
	@Override
	public int update(ProductVO productVO) {
		return this.productDao.update(productVO);
	}
	// 상품 삭제
	@Override
	public int delete(String productId) {
		return this.productDao.delete(productId);
	}

	// CART 및 CART_DET 테이블에 INSERT	
	@Override
	public int thankCustomer(CartVO cartVO) {
		// 1. CART 테이블에 INSERT
		int cartInCnt = this.productDao.insertCart(cartVO);
		log.info("cartInCnt : " + cartInCnt);
		// 2. CART_DET 테이블에 INSERT
		
		return 0;
	}
	
	// ATTACH 테이블에 다중 INSERT
	@Override
	public int insertAttach(List<AttachVO> attachVOList) {
		return this.productDao.insertAttach(attachVOList);
	}
	
	// PRODUCT 테이블의 기본키 자동생성 
	@Override
	public String getProductId() {
		return this.productDao.getProductId();
	}
}
