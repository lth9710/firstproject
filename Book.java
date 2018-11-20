package com.project1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.net.ssl.SSLEngineResult.Status;

public class Book implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	Scanner sc = new Scanner(System.in);
	private List<BookVO> lists = new ArrayList<BookVO>();
	private String path = System.getProperty("user.dir");
	private File f = new File(path, "\\data\\books7.txt");
	int tot, tot1 ,tot2 =0;
	//private List<UserVO> uLists = new ArrayList<UserVO>();
	@SuppressWarnings("unchecked")
	public Book() { // 북파일 생성하는 생성자

		try {

			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();

			}
			if (f.exists()) {

				FileInputStream fis = new FileInputStream(f);

				ObjectInputStream ois = new ObjectInputStream(fis);

				lists = (ArrayList<BookVO>) ois.readObject();

				fis.close();
				ois.close();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void writeBookFile() { // 파일저장하는메소드

		try {

			if (lists != null) {

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);// 리스트로 파일을저장

				fos.close();
				oos.close();
				//System.out.println("파일 저장 성공!");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void bookPrint() {

		
		//최상단 출력수정
		Iterator<BookVO> it = lists.iterator();

		while (it.hasNext()) {
			BookVO vo = it.next();
			System.out.println(vo.toString());

		}

	}

	public void bookInput() {// 도서추가

		Scanner sc = new Scanner(System.in);

		BookVO vo = new BookVO();

		
		
		try {
			
		
		System.out.println("  도서번호?  ");
		vo.setId(sc.nextInt());

		System.out.println("  책이름?  ");
		vo.setName(sc.next());

		System.out.println("  저자?  ");
		vo.setAuthor(sc.next());

		vo.setRental(false);

		if (lists == null)
			lists = new ArrayList<BookVO>();

		lists.add(vo);

		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}
		

	}// end of input

	public void bookDelete() {// 삭제메소드
		try {
			
		
		
		
		System.out.println("  삭제할 책의 번호를 입력하세요  ");
		int n = sc.nextInt();

		for (int i = 0; i < lists.size(); i++) {

			if (n == lists.get(i).getId())
				lists.remove(i);
			System.out.println("삭제되었습니다");
			break;

		}// end of for

		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다");
			sc=new Scanner(System.in);
		
		}		

	}// end of delete

	public void bookBorrow() {

		
		try {
		int w=0;
			
		System.out.print(" 대여할 도서 번호를 입력하세요 \n :");
		
		w = sc.nextInt();
		
		int novel = 1000;
		int carton = 400;
		String w1 = Integer.toString(w);
		String userId="";

		System.out.println(" 대여하는사람의 ID를 입력하세요 ");
		userId=sc.next();

		for (int i = 0; i < lists.size(); i++) {
			if (w == lists.get(i).getId()) {
				if (lists.get(i).isRental()) {
					System.out.println("  이미 대여중입니다  ");
					return;
				} else if ((!lists.get(i).isRental())) {
					System.out.println("  정상적으로 대여되었습니다.  ");
					lists.get(i).setRental(true);
					lists.get(i).setUserId(userId);
					break;
				}

			}
		}	


		if(w1.charAt(0)<='4'){
			tot1 += novel;

		}else if(w1.charAt(0)>'4'){
			tot2 += carton;

		}

		tot = tot1 +tot2;

		System.out.println("┏──────────┓");
		System.out.println("┃1.추가   2.완료     ┃");
		System.out.print("┗──────────┛\n : ");
		if(sc.nextInt()==1)
			bookBorrow();
		else{
			System.out.println("  "+tot+"원 입니다  ");
			
		}
		
		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}
		
	}



	public void bookReturn() {

		
		try {
			
		
		System.out.println("  반납할 도서 번호를 입력하세요  ");
		int w = sc.nextInt();

		for (int i = 0; i < lists.size(); i++) {

			if (w == lists.get(i).getId())
				if (!lists.get(i).isRental()) {
					System.out.println("  대여중이 아닙니다  ");
				} else if (lists.get(i).isRental()) {
					System.out.println("  정상적으로 반납되었습니다.  ");
					lists.get(i).setRental(false);
					lists.get(i).setUserId(null);
				}

		}
		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다");
			sc=new Scanner(System.in);
		}
	}

	public void searchBook() {


		int id = 0;
		UserVO ob = new UserVO();
		boolean flag = false;
		System.out.println("  검색할 도서번호?  ");
		String searchid = sc.next();

		Iterator<BookVO> it = lists.iterator();

		while (it.hasNext()) {
			BookVO vo = it.next();
			if (searchid.equals(vo.getId())) {
				System.out.println(vo.toString());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("  찾는대상이 없습니다.  ");
		}
	}

	public boolean searchFlagBook() {

		boolean flag = false;
		System.out.println("  검색할 도서번호?  ");
		String searchid = sc.next();

		Iterator<BookVO> it = lists.iterator();

		while (it.hasNext()) {
			BookVO vo = it.next();
			if (searchid.equals(vo.getId())) {
				System.out.println(vo.toString());
				flag = true;
				break;
			}
		}
		if (!flag) {
			System.out.println("  찾는대상이 없습니다.  ");
		}
		return flag;
	}

	public List<Integer> rentalBookList() { // 도서번호를받아서 책정보출력한후 도서번호반환


		
		int id = 0;
		System.out.println("  검색할 도서번호?  ");
		int searchid = sc.nextInt();

		
		List<Integer> booklist = new ArrayList<Integer>();



		Iterator<BookVO> it = lists.iterator();
		while (it.hasNext()) {
			BookVO vo = it.next();
			

			if (searchid==(vo.getId())) { // 도서번호와 검색할 도서번호 가 같으면
				if(vo.isRental()){ // 대출된도서인지 대출안된도서인지 구분
					System.out.println(vo.toString()); // 대출된도서라면 책정보를 출력
					 booklist.add(id, vo.getId()); 	//  인트속성 리스트에 책의 번호를 더함
					id++;
				}

				

			}else{
				
			}
		}
		return booklist;// 리스트에 번호들을 반환함


		


	}

	
/*public int rentalBookList() { // 도서번호를받아서 책정보출력한후 도서번호반환


		
		int id = 0;
		System.out.println("검색할 도서번호?");
		int searchid = sc.nextInt();

		



		Iterator<BookVO> it = lists.iterator();
		while (it.hasNext()) {
			BookVO vo = it.next();
			

			if (searchid==(vo.getId())) { // 도서번호와 검색할 도서번호 가 같으면
				if(vo.isRental()){ // 대출된도서인지 대출안된도서인지 구분
					System.out.println(vo.toString()); // 대출된도서라면 책정보를 출력
					id =vo.getId();
					
					//  인트속성 리스트에 책의 번호를 더함
					
				}

				

			}else{
				
			}
		}
		return id;// 리스트에 번호들을 반환함


		


	}*/



	public String getUserId(int id){//도서번호를통해서 USerid를 가져와야함

		String getid="";
		

		Iterator<BookVO> it = lists.iterator();

		while (it.hasNext()) {
			BookVO vo = it.next();
			if (id==(vo.getId())) {//도서번호와 책의 번호가 같으면
				
				getid=vo.getUserId(); // 해당도서의 사용자id를 가져옴
				
			}else{
				break;
			}
		}


		return getid;

	}

	public void total() {
		System.out.println("  "+tot);
	}

}
