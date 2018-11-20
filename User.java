package com.project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;





public class User  {
	Scanner sc = new Scanner(System.in);
	ArrayList<UserVO> lists = new ArrayList<UserVO>();
	private String path = System.getProperty("user.dir");
	//System.getProperty() 저장되는 폴더 주소 설정
	private File f = new File(path, "\\data\\library6.txt");//파일생성


	@SuppressWarnings("unchecked")
	public User(){

		try {
			if(!f.getParentFile().exists()){//파일이없으면
				f.getParentFile().mkdirs();
			}

			if(f.exists()){//파일이있으면
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				lists = (ArrayList<UserVO>)ois.readObject();
				fis.close();
				ois.close();

			}
		} catch (Exception e) {
		}
	}


	/*public void rentalBook(UserVO user, Book book, int bookId){
		BookVO rentBook = searchById(bookId);
		if(rentBook != null){
			// rentBook의 rental(t/f) 수정
			user.getRentalBook().add(rentBook.getId());
		}else{
			System.out.println("대여하고자 하는 책이 없습니다.");
		}
	}



	public BookVO searchById(int bookId) {
				boolean flag = false;
		System.out.println("검색할 아이디?");
		String searchid = sc.next();

		Iterator<BookVO> it =blists.iterator();

		while(it.hasNext()){
			BookVO vo = it.next();
			if(searchid.equals(vo.getId())){
				bookId=blists.indexOf(vo);
			}	
		}
		if(!flag){
			System.out.println("찾는대상이 없습니다.");
		}

		return  blists.get(bookId);

	}
	 */

	public void userWriteFile(){//파일저장

		try {

			if(lists!=null){

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(lists);

				fos.close();
				oos.close();
				//System.out.println("회원가입성공!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}











	public void userPrint(){//출력

		
		
		// 출력 최상단 수정System.out.println();
		
		Iterator<UserVO> it = lists.iterator();
		while(it.hasNext()){
			UserVO vo = it.next();

			System.out.println(vo.toString());
		}
	}









	public void userInput(){//입력

		Scanner sc = new Scanner(System.in);
		UserVO vo = new UserVO();

		String pw1;

		System.out.println("  ID :   ");
		vo.setId(sc.next());

		if(vo.getId().length()<5||vo.getId().length()>15){
			System.out.println("  ID는 5~10자이내, 영문자와 숫자를 혼용하여 만드세요.  ");
		}

		int tot =0;

		for(int i =0; i<vo.getId().length();i++){

			char ch = vo.getId().charAt(i);

			if((ch<64||ch>90)&&(ch<97||ch>122)&&(ch<48||ch>57)){
			}

			if(ch>=48&&ch<=57){
				tot++;
			}
		}

		if(tot==0||tot==vo.getId().length()){
			System.out.println("  영문자 숫자 혼용입니다  ");

			return;
		}

		if(searchId(vo.getId())){
			System.out.println("  ID가 존재합니다..  ");
			return;
		}

		vo.setUserId(vo.getId());
		while(true){
			System.out.print("  비밀번호 :   ");
			vo.setPw(sc.next());
			System.out.print("  비밀번호 재확인  ");
			pw1 = sc.next();
			if(vo.getPw().equals(pw1)){
				break;
			}
		}

		System.out.print("  이름 :   ");
		vo.setName(sc.next());
		System.out.print("  성별 :   ");
		vo.setGender(sc.next());
		System.out.print("  생년월일 :   ");
		vo.setBirth(sc.next());
		System.out.print("  Email :   ");
		vo.setEmail(sc.next());
		System.out.print("  전화번호 :   ");
		vo.setTel(sc.next());

		if(lists==null)
			lists = new ArrayList<UserVO>();
		lists.add(vo);



		System.out.println("  회원가입이 완료되었습니다.  ");


	}



	public boolean searchId(String id) {



		Iterator<UserVO> it = lists.iterator();

		while(it.hasNext()){

			UserVO vo = it.next();
			if(vo.getId().equals(id)){
				return true;
			}

		}
		return false;




	}


	/*public void searchId() {

		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		System.out.println("검색할 아이디?");
		String searchid = sc.next();

		Iterator<UserVO> it =lists.iterator();

		while(it.hasNext()){
			UserVO vo = it.next();
			if(searchid.equals(vo.getId())){
				flag =true;

			}	
		}
	}

	 */





	public void searchUser() {

		boolean flag = false;
		System.out.println("  검색할 아이디?  ");
		String searchid = sc.next();

		Iterator<UserVO> it =lists.iterator();

		while(it.hasNext()){
			UserVO vo = it.next();
			if(searchid.equals(vo.getId())){
				System.out.println(vo.toString());
				flag =true;
			}	
		}
		if(!flag){
			System.out.println("  찾는대상이 없습니다.  ");
		}
	}
	//회원탈퇴 , 검색

	public void userUpdate(){

		String pw2="";
		int index = 0;
		boolean flag = false;

		System.out.println("  수정할 아이디?  ");
		String searchid = sc.next();

		Iterator<UserVO> it =lists.iterator();

		while(it.hasNext()){
			UserVO vo = it.next();
			if(searchid.equals(vo.getId())){
				System.out.println(vo.toString());
				flag =true;
			}	
		}
		if(!flag){
			System.out.println("  찾는대상이 없습니다.  ");
			return;
		}

		UserVO vo2 = new UserVO();
		vo2.setId(searchid);

		while(true){
			System.out.print("  비밀번호 :   ");
			vo2.setPw(sc.next());
			System.out.print("  비밀번호 재확인:   ");
			pw2 = sc.next();
			if(vo2.getPw().equals(pw2)){
				break;
			}
		}

		System.out.print("  이름 :   ");
		vo2.setName(sc.next());
		System.out.print("  성별 :   ");
		vo2.setGender(sc.next());
		System.out.print("  생년월일 :   ");
		vo2.setBirth(sc.next());
		System.out.print("  Email :   ");
		vo2.setEmail(sc.next());
		System.out.print("  전화번호 :   ");
		vo2.setTel(sc.next());
		vo2.setUserId(searchid);

		it =lists.iterator();

		while(it.hasNext()){
			UserVO vo = it.next();
			if(searchid.equals(vo.getId())){
				index = lists.indexOf(vo);
				lists.set(index, vo2);

				System.out.println("  수정되었습니다.  ");

				flag =true;
			}	
		}
		if(!flag){
			System.out.println("  찾는 대상이 없습니다.  ");
		}


	}


	//로그인(대여정보 및 책관련메뉴) ,
	public void userLogin(){


	}







	//회원탈퇴
	public void userDelete() {

		System.out.println("  삭제할 아이디?  ");
		String deleteId = sc.next();

		Iterator<UserVO> it = lists.iterator();

		while(it.hasNext()){

			UserVO vo = it.next();
			if(deleteId.equals(vo.getId())){
				lists.remove(vo);
				System.out.println("  삭제되었습니다  ");
			}


		}
	}






	public void rentalUserList(String searchid){ // id값을 받아서 대여중이아닌지, 대여중이라면 누가빌렸는지



		if(searchid.equals("")){
			System.out.println("  대여중이 아닌 도서입니다  ");
			return;
		}

		Iterator<UserVO> userit = lists.iterator();
		while(userit.hasNext()){
			UserVO uvo = userit.next();
			if(searchid.equals(uvo.getId())){
				System.out.println("  대여자정보: "+uvo.toString());

			}

		}

	}




	public void print(){//출력

		Iterator<UserVO> it = lists.iterator();
		while(it.hasNext()){
			UserVO vo = it.next();
			System.out.println(vo.toString());
		}
	}











}








