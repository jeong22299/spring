package kr.or.ddit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.BookService;
import kr.or.ddit.vo.BookVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BookController {
	@Autowired
	BookService bookservice;
	
	// 상품 등록
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public ModelAndView addBook() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/addBook");
		return mav;
	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public ModelAndView addBookPost(ModelAndView mav, @ModelAttribute BookVO bookVO) { // @ModelAttribute=>생략가능
		log.info("productVO : " + bookVO.toString());
		
		int result = this.bookservice.insert(bookVO);
		
		log.info("result : " + result);
		if(result < 1) { // 등록 실패
			mav.setViewName("redirect:/addBook");
		}else {   // 등록 성공
			mav.setViewName("redirect:/bookDetail?bookId="+ bookVO.getBookId());
		}
		return mav;
	}
	
	// 상품목록
	@RequestMapping(value="/book", method=RequestMethod.GET)
	public ModelAndView book(ModelAndView mav, @RequestParam(value="keyword", required=false) String keyword) {
		// Model
		List<BookVO> data = this.bookservice.list(keyword);
		mav.addObject("data", data);
		//View
		mav.setViewName("book/book");
		return mav;
	}
	
	// 상품 상세
	@RequestMapping(value="/bookDetail", method=RequestMethod.GET)
	public ModelAndView bookDetail(ModelAndView mav, @ModelAttribute BookVO bookVO) {
		
		// select 결과 1행을 bookVO에 담을 것임
		BookVO data = this.bookservice.selectDetail(bookVO);
		log.info("BookVO : " + data.toString());
		
		mav.setViewName("book/bookDetail");
		mav.addObject("data", data);
		mav.addObject("bookId", data.getBookId());
		
		return mav;
	}
	

}














