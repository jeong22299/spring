package kr.or.ddit.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.service.BoardService;
import kr.or.ddit.util.ArticlePage;
import kr.or.ddit.util.FileUploadUtil;
import kr.or.ddit.vo.BookVO;
import kr.or.ddit.vo.MemberListVO;
import lombok.extern.slf4j.Slf4j;

// 프링아 이거 자바빈 객체로 관리해줘
@RequestMapping("/board")
@Slf4j
@Controller
public class BoardController {
	/* RequestMapping의 value속성에 요청 경로를 설정
	 	- 요청 경로는 반드시 설정해야 하는 필수 정보
	 	- 속성이 하나일 때는 속성명을 생략할 수 있음(@RequestMapping("/board/register")
	 	- 컨트롤러의 클레스 레벨과 메서드 레벨로 지정할 수 있음
	 	- 클래스 레벨로 요청 경로를 지정하면 메서드 레벨에서 지정한 경로의 기본 경로로 취급됨
	 	- 클래스 레벨의 요청 경로에 메서드 레벨의 요청 경로를 덧붙인 형태가 최종 경로가 됨
	 */
	
	@Inject
	FileUploadUtil fileUploadUtil;
	
	// value 속성에 요청 경로 값을 입력
	@RequestMapping(value="/register")
	public  void registerForm() {
		log.info("registerForm");
	}
	
	// 속성이 하나일 때는 속성명을 생략할 수 있다.
	@RequestMapping("/modify")
	private void modifyForm() {
		log.info("modifyForm");
	}
	
	/** 2. 경로(Path) 패턴(Variable) 매핑
	 	요청 경로를 동적으로 표현이 가능한 경로 패턴을 지정할 수 있음
	 		- URL 경로 상의 변하는 값을 경로 변수로 취급
	 		- 경로 변수에 해당하는 값을 파라미터 변수에 설정할 수 있음
	 */
	// 요청 URI : http://localhost/board/read/100 => 100번글
	// 요청 URI : http://localhost/board/read/101 => 101번글
	// 요청 URI : http://localhost/board/read/102 => 102번글
	// ...
	// 요청 URI : http://localhost/board/read?boardId=102 => 102번글
	@RequestMapping("/read/{boardNo}")
	private String read(@PathVariable("boardNo") int boardNo) {
		log.info("boardNo : " + boardNo);
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("board/read");
//		return mav;  ==> ModelAndView 사용하지 않고 바로 지정 가능
		
		// 뷰이름 지정. forwarding
		return "board/read";
	}
	@RequestMapping("/formHome")
	public String formHome() {
		// forwarding
		return "board/formHome";
	}

	/** 3. Http 메서드 매핑
	 method 속성을 사용하여 HTTP메서드를 매핑 조건으로 지정 가능
	 화면으로 응답하는 경우 HTTP 메서드로 GET방식과 POST방식 두 가지를 사용함
	 */
	
//	골뱅이GetMapping("/register2")
	@RequestMapping(value="/register2", method=RequestMethod.GET)
	public String register2(Model model) {
		// Model 인터페이스 => 데이터 담당
		model.addAttribute("name", "개똥이");
		// forwarding
		return "board/formHome";
	}
	
//	골뱅이PostMapping("/register2")
	@RequestMapping(value="/register2", method=RequestMethod.POST)
	public String register2Post(Model model) {
		// Model 인터페이스 => 데이터 담당
		model.addAttribute("name", "민정이");
		// forwarding
		return "board/formHome";
	}
	
	/**	4. Params 매핑
	 - 요청 파라미터를 매핑 조건으로 지정하는 경우 params 속성을 사용함
	 - 버튼이나 링크에 따라 호출할 매서드를 바꿔야 할 때 사용
	 */
	// <p><a href="/board/get?register">Register</a></p>
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "register")
	private String getRegister() {
		log.info("getRegister 왔다");
		return "board/formHome";
	}
	// <p><a href="/board/get?modify">Modify</a></p>
	@RequestMapping(value = "/get", method = RequestMethod.GET, params = "modify")
	private String getModify() {
		log.info("getModify 왔다");
		return "board/formHome";
	}
	
	/*
	 <form action="/board/post" method="post">
			<button type="submit" name="register">Register</button>
		</form>
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "register")
	private String postRegister() {
		log.info("postRegister 왔다");
		return "board/formHome";
	}
	
	/*
	 <form action="/board/post" method="post">
			<button type="submit" name="modify">Modify</button>
		</form>
	 */
	@RequestMapping(value = "/post", method = RequestMethod.POST, params = "modify")
	private String postModify() {
		log.info("postModify 왔다");
		return "board/formHome";
	}
	
	/** 5. Header 매핑
	 	요청 헤더를 매핑 조건으로 지정하는 경우에는 headers 속성을 사용함
	 */
	// 요청URI : http://localhost/board/ajaxHome
	@RequestMapping("/ajaxHome")
	public String ajaxHome() {
		log.info("ajaxHome에 왔다.");
		// forwarding
		return "board/ajaxHome";
	}
	//success:function(result){
	// 요청URI : http://localhost/board/7
	// /7 => 경로 변수(동적)
	// 골뱅이@ResponseBody를 통해서 JSON데이터로 리턴
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT, headers="X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> ajaxModify(@PathVariable("boardNo") int boardNo){
		log.info("ajaxModify에 왔다.");
		log.info("boardNo : " + boardNo);
		
		// success:function(result){
		// 헤더에 String데이터를 넣음
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		return entity;
	}
	
	// 요청 => 달러.get("/board/" + boardNo, function(data){
	// 요청URI : http://localhost/board/7
	@RequestMapping(value = "/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<BookVO> getRead(@PathVariable("boardNo") int boardNo){
		//boardNo = 7
		log.info("boardNo : " + boardNo);
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		// vo를 응답데이터에 포함해보자
		// HttpStatus.OK : 통신상태 200
		ResponseEntity<BookVO> entity = new ResponseEntity<BookVO>(bookVO, HttpStatus.OK);
		return entity;
	}
	
	// 요청URI : /board/getBook
	// data : {"boardId":7}
	// contentType : application/json;charset:urf-8
	// dataType : json
	@ResponseBody
	@RequestMapping(value = "/getBook", method = RequestMethod.POST)
	public List<BookVO> getBook(@RequestBody String boardNo) {
		log.info("boardNo : " + boardNo);
		
		List<BookVO> bookVOList = new ArrayList<BookVO>();
		
		BookVO bookVO = new BookVO();
		bookVO.setBookId(7);
		bookVO.setTitle("천원짜리 변호사");
		bookVO.setCategory("드라마");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		bookVOList.add(bookVO);
		
		bookVO = new BookVO();
		bookVO.setBookId(8);
		bookVO.setTitle("모놀로그");
		bookVO.setCategory("음악");
		bookVO.setPrice(10000);
		bookVO.setInsertDate(new Date());
		
		bookVOList.add(bookVO);
		
		return bookVOList;
	}
	
	@Autowired
	BoardService bs;
	
	// 요청 URI : http://localhost/board/boardlist?currentPage=5
	// 요청파라미터 : currentPage=5
	@GetMapping("/boardlist")
	public String boardList(Model model,
			@RequestParam(defaultValue = "1", required = false) int currentPage, 
			@RequestParam Map<String, String> map) {
		log.info("currentPage : " + currentPage);
		
		// 	/board/boardlist 이렇게 요청 되었을 경우 처리
		String cPage = map.get("currentPage");
		String show = map.get("show");
		String keyword = map.get("keyword");
		
		if(cPage==null) {
			map.put("currentPage", "1");
		}
		if(show==null) {
			map.put("show","10");
		}
		if(keyword==null) {
			map.put("keyword", "");
		}
		
		
		log.info("map : " + map);
		
		List<MemberListVO> list = bs.list(map);
		
		// 한 화면에 보여질 행의 수
		int size = Integer.parseInt(map.get("show"));
		
		//  MEM 테이블의 전체 행의 수 구함 
		int total = this.bs.getTotal(map);
		
		// (전체 글 수, 현재페이지, 한 화면에 보여질 행 수 , select 결과 list)
		model.addAttribute("data", new ArticlePage<MemberListVO>(total, currentPage, size, list));
		return "board/boardlist";
	}
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "board/addBoard";
	}
	
	@RequestMapping(value="/addBoard", method=RequestMethod.POST)
	public ModelAndView create2Post(ModelAndView mav, @ModelAttribute MemberListVO memVO) {
		int result = this.bs.insert(memVO);
		
		if(result < 1) {
			mav.setViewName("redirect:/addBoard");
		} else {
			mav.setViewName("redirect:/board/boardlist");
		}
		return mav;
	}
	
	// 요청URI : /board/chkDup
	// 요청파라미터 : {"memId" : "abc001"}
	// 방식 : post
	// JSON데이터로 리턴, 중복이 있으면{"result" : "1"}, 중복이 없으면 {"result":"0"}
	// 골뱅이RequestParam Map<String, String> map => 문제발생
	// String memId => 문제발생
	// 결론 : ajax로 요청된 JSON 데이터는 무조건 RequestBody로 받자
	@ResponseBody
	@PostMapping("/chkDup")
	public Map<String, String> chkDup(
			@RequestBody Map<String, String> json) {
		
		log.info("json" + json);
		
		Map<String, String> rsltMap = new HashMap<String, String>();
		
		int result = this.bs.chkDup(json.get("memId"));
		
		rsltMap.put("result", result+"");
		
		return rsltMap;
	}
	
	/*  8. 파일업로드 폼 방식 요청 처리
		 	파일 업로드 폼 파일<input type="file"...> 요소(=태그) 값을
		 	스프링 MVC가 지원하는 MultipartFile 매개변수로 처리함 
	 */
	@GetMapping("/register06")
	public String register06() {
		log.info("register06에 왔다");
		
		return "/board/register06";
	}
	
	@PostMapping("/registerFile01")
	public String registerFile01Post(MultipartFile picture) {
		log.info("registerFile01");
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("Size : " + picture.getSize());
		log.info("" + picture.getContentType());
		
		return "/board/success";
	}
	
	@PostMapping("/registerFile02")
	public String registerFile02Post(String userId, String password,
			MultipartFile picture) {
		log.info("registerFile02");
		log.info("userId : "+ userId);
		log.info("password : " + password);
		
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("Size : " + picture.getSize());
		log.info("" + picture.getContentType());
		
		return "/board/success";
	}
	
	
	@PostMapping("/registerFile03")
	public String registerFile03Post(MemberListVO memVO,
			MultipartFile picture) {
		log.info("registerFile03");
		log.info("memVO : " + memVO.toString());
		
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("Size : " + picture.getSize());
		log.info("" + picture.getContentType());
		
		return "/board/success";
	}
	
	@PostMapping("/registerFile05")
	public String registerFile05Post(MemberListVO memVO,
			MultipartFile picture, MultipartFile picture2) {
		log.info("registerFile05");
		log.info("memVO : " + memVO.toString());
		
		log.info("originalName : " + picture.getOriginalFilename());
		log.info("Size : " + picture.getSize());
		log.info("" + picture.getContentType());
		
		log.info("originalName : " + picture2.getOriginalFilename());
		log.info("Size : " + picture2.getSize());
		log.info("" + picture2.getContentType());
		
		return "/board/success";
	}
	
	
	@PostMapping("/registerFile06")
	public String registerFile06Post(MemberListVO memVO,
			List<MultipartFile> pictureList) {
		log.info("registerFile06");
		log.info("memVO : " + memVO.toString());
		
		for(MultipartFile picture : pictureList) {
			log.info("originalName : " + picture.getOriginalFilename());
			log.info("Size : " + picture.getSize());
			log.info("" + picture.getContentType());
		}
		return "/board/success";
	}
	
	
	@PostMapping("/registerFile07")
	public String registerFile07Post(MemberListVO memVO,
			MultipartFile pictures) {
		log.info("registerFile06");
		log.info("memVO : " + memVO.toString());
		
		MultipartFile[] pictureArray = memVO.getPictureArray();
		
		for(MultipartFile picture : pictureArray) {
			log.info("originalName : " + picture.getOriginalFilename());
			log.info("Size : " + picture.getSize());
			log.info("" + picture.getContentType());
		}
		return "/board/success";
	}
	
	@GetMapping("/register07")
	public String register07Get() {
		
		return "board/register07";
	}
	
	// 요청 URI : /board/uploadAjax
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST
			, produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile[] file){
		String originalFileName = file[0].getOriginalFilename();
		log.info("originalName : " + originalFileName);
		ResponseEntity<String> entity = 
				new ResponseEntity<String>("SUCCESS" + originalFileName, HttpStatus.OK);
		
		UUID uid = UUID.randomUUID();
		
		this.fileUploadUtil.fileUploadAction(file, uid.toString());
		return entity;
	}
}














