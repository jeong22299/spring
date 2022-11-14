package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

// 자바빈 클래스
public class MemberListVO {

	private String memId;  		// 회원아이디
	private String memName;	// 회원명
	private String memJob;		// 직업
	private String memLike;	// 취미
	private String memHp;		//	전화번호
	
	// mem테이블에 없어도 사용 가능
	private String userId;
	private String password;
	// 자기소개
	private String introduction;
	private List<AttachVO> attachVOList;	
	private MultipartFile picture;
	private MultipartFile picture2;
	// ...name="pictureList"
	private List<MultipartFile> pictureList;
	// ...name="pictureArray" multiple
	private MultipartFile[] pictureArray;
	
	
	private int coin = 100;							// 보유 코인
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") // 기본:2022/11/01 => 20221101
	private Date birth;									// 생일 
	
	private String gender; 						 	// 성별
	private String nationality;					// 국적
	
	// 보유 자동차들
	private String[] cars;							
	private String car;
	
	// 취미
	private String[] hobbyList;					
	private String hobby;
	
	private boolean marriaged;					// 결혼 유무
	
	private AddressVO addressVO;				// 중첩된 자바빈(1:1)
	
	private List<CardVO> cardVOList;		
	private String developer;							// 개발자여부(Y, null)
	private boolean foreigner; 						// 외국인 여부(boolean 형이 더 좋음)


	// 기본생성자
	public MemberListVO() {}

	// getter/setter 메소드
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemJob() {
		return memJob;
	}

	public void setMemJob(String memJob) {
		this.memJob = memJob;
	}

	public String getMemLike() {
		return memLike;
	}

	public void setMemLike(String memLike) {
		this.memLike = memLike;
	}

	public String getMemHp() {
		return memHp;
	}

	public void setMemHp(String memHp) {
		this.memHp = memHp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public MultipartFile getPicture2() {
		return picture2;
	}

	public void setPicture2(MultipartFile picture2) {
		this.picture2 = picture2;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public List<MultipartFile> getPictureList() {
		return pictureList;
	}

	public void setPictureList(List<MultipartFile> pictureList) {
		this.pictureList = pictureList;
	}

	public MultipartFile[] getPictureArray() {
		return pictureArray;
	}

	public void setPictureArray(MultipartFile[] pictureArray) {
		this.pictureArray = pictureArray;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String[] getCars() {
		return cars;
	}

	public void setCars(String[] cars) {
		this.cars = cars;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String[] getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(String[] hobbyList) {
		this.hobbyList = hobbyList;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public boolean isMarriaged() {
		return marriaged;
	}

	public void setMarriaged(boolean marriaged) {
		this.marriaged = marriaged;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public List<CardVO> getCardVOList() {
		return cardVOList;
	}

	public void setCardVOList(List<CardVO> cardVOList) {
		this.cardVOList = cardVOList;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public boolean isForeigner() {
		return foreigner;
	}

	public void setForeigner(boolean foreigner) {
		this.foreigner = foreigner;
	}

	public List<AttachVO> getAttachVOList() {
		return attachVOList;
	}

	public void setAttachVOList(List<AttachVO> attachVOList) {
		this.attachVOList = attachVOList;
	}

	@Override
	public String toString() {
		return "MemberListVO [memId=" + memId + ", memName=" + memName + ", memJob=" + memJob + ", memLike=" + memLike
				+ ", memHp=" + memHp + ", userId=" + userId + ", password=" + password + ", introduction="
				+ introduction + ", attachVOList=" + attachVOList + ", picture=" + picture + ", picture2=" + picture2
				+ ", pictureList=" + pictureList + ", pictureArray=" + Arrays.toString(pictureArray) + ", coin=" + coin
				+ ", birth=" + birth + ", gender=" + gender + ", nationality=" + nationality + ", cars="
				+ Arrays.toString(cars) + ", car=" + car + ", hobbyList=" + Arrays.toString(hobbyList) + ", hobby="
				+ hobby + ", marriaged=" + marriaged + ", addressVO=" + addressVO + ", cardVOList=" + cardVOList
				+ ", developer=" + developer + ", foreigner=" + foreigner + "]";
	}



}
