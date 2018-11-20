package com.project1;

import java.io.Serializable;
import java.util.Scanner;

import com.project2.EndScreen;
import com.project2.StartScreen;


public class TestOnly implements Serializable{

	private static final long serialVersionUID = 1L;


	Book books = new Book();
	User ob = new User();
	Scanner sc = new Scanner(System.in);
	BookUser bu = new BookUser();
	Thread t3 = new EndScreen();
	
	
	
	
	public static void main(String[] args) {
		try {
			
		
		Thread t1 = new StartScreen();
		t1.start();
		
		//Thread t2 = Thread.currentThread(); 메인을 쓰레드로 지정
		t1.join();
		
		
		TestOnly test = new TestOnly();
		test.firstInterface();
		
		
		
		


		/*System.out.println("1.회원가입 2.회원목록 3.저장 4.종료 5.찾기 6.수정: ");
				ch = sc.nextInt();


			switch(ch){

			case 1: ob.userInput();break;
			case 2: ob.userPrint();break;
			case 3: ob.userWriteFile();break;
			case 4: ob.userWriteFile();System.exit(0);break;
			case 5:	ob.searchId();break;
			case 6: ob.userUpdate();	
			}
		}
		 */



		/*int chBook=0;
		Scanner sc = new Scanner(System.in);


		Book books = new Book();


		while(true){
		System.out.print("1.도서추가\n2.도서삭제\n3.도서조회\n4.도서대여\n5.도서반납\n6.id검색\n7.종료:");
		chBook=sc.nextInt();


			switch(chBook){

			case 1:
				books.bookInput();
				break;
			case 2:
				books.bookDelete();
				break;
			case 3:
				books.bookPrint();
				break;
			case 4:
				books.bookBorrow();
				break;
			case 5:
				books.bookReturn();
				break;
			case 6:
				System.out.println(books.rentalList());
				break;
			default:
				books.writeBookFile();
				System.exit(0);







			}
		}
		 */
		} catch (Exception e) {
			// TODO: handle exception
		}
	}//end of main

	public void firstInterface(){


		while(true){
			System.out.println("┏──────────┓");
			System.out.print("┃1.로그인    2.종료  ┃\n");
			System.out.print("┗──────────┛\n : ");
			int ch= sc.nextInt();
			switch(ch){

			case 1:
				//로그인확인
				secondInterface();
				return;

			case 2:
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				books.writeBookFile();
				ob.userWriteFile();
			
				System.exit(0);
			
			}
		}

	}

	public void secondInterface(){

		while(true){

			System.out.println("┏──────────────────────────────────┓");
			System.out.print("┃1.도서관리\t2.회원관리\t3.정산관리\t4.이전 \t   5.종료"+"     ┃\n");
			System.out.print("┗──────────────────────────────────┛\n : ");
			int ch = sc.nextInt();

			switch(ch){
			case 1:
				bookAdmin(); 
				break;
			case 2:
				userAdmin(); 
				break;
			case 3:
				monney(); 
				break;
			case 4:
				firstInterface(); 
				break;
			
			
			default:
				try {
					
				
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				books.writeBookFile();
				ob.userWriteFile();
				t3.start();
				t3.join();
				System.exit(0);
				
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}

	}


	public void bookAdmin(){

		while(true){

			System.out.println("┏───────────────────────────────────────────────────┓");
			System.out.print("┃1.도서대여       2.도서반납      3.대여목록      4.도서추가      5.도서삭제      6.이전       7.종료  ┃\n");
			System.out.print("┗───────────────────────────────────────────────────┛\n : ");
			int ch = sc.nextInt();

			switch(ch){
			case 0:
				books.rentalBookList();
				break;
			case 1:
				books.bookBorrow();
				break;

			case 2:
				books.bookReturn();
				break;

			case 3:
				books.bookPrint();
				break;
			case 4:
				books.bookInput();
				break;

			case 5:
				books.bookDelete();
				break;
			case 6:	
				secondInterface();
				break;
			default:
				books.writeBookFile();
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				ob.userWriteFile();
				System.exit(0);

			}
		}
	}








	public void userAdmin(){

		while(true){


			System.out.println("┏─────────────────────────────────────────────────┓");
			System.out.print("┃1.회원목록       2.회원등록        3.회원탈퇴        4.회원정보수정        5.이전        6.종료   ┃\n");
			System.out.print("┗─────────────────────────────────────────────────┛\n : ");
			
			int ch = sc.nextInt();

			switch(ch){
			case 1:
				ob.userPrint();
				break;
			case 2:
				ob.userInput();
				break;
			case 3:
				ob.userDelete();
				break;
			case 4:
				ob.userUpdate();
				break;
			case 5:
				secondInterface();
				break;
			default:
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				books.writeBookFile();
				ob.userWriteFile();
				System.exit(0);
			}
		}
	}





	public void monney(){
		
		while(true){
			
			System.out.println("┏─────────────┓");
			System.out.print("┃1.총매출  2.이전  3.종료  ┃\n");
			System.out.print("┗─────────────┛\n : ");
			
			
			int ch = sc.nextInt();

			switch(ch){
			case 1:
				books.total();
				break;
			case 2:
				secondInterface();
				break;
			
			default:
				System.out.println("┏───────────┓");
				System.out.println("┃  ** 종료합니다  **   ┃");
				System.out.print("┗───────────┛\n  ");
				books.writeBookFile();
				ob.userWriteFile();
				System.exit(0);
			}
		}
			
			
		}
	
		
		
		
		
		

		//System.out.print("1.도서대여 \t2.도서반납\t3.회원목록\t4.대여목록\t5.연체목록\n6.도서추가"
		//		+ "\t7.도서삭제\t8.회원정보수정\t9.회원등록 \t0.저장및종료\n:");
	}



	/*public void secondInterface(){
		System.out.println();
		System.out.print("1.도서대여 \t2.도서반납\t3.회원목록\t4.대여목록\t5.연체목록\n6.도서추가"
				+ "\t7.도서삭제\t8.회원정보수정\t9.회원등록 \t0.저장및종료\n:");

		int ch= sc.nextInt();


			switch(ch){
			case 1:
				books.bookBorrow();
				break;

			case 2:
				books.bookReturn();
				break;

			case 3:
				ob.userPrint();
				break;
			case 4:
				books.bookPrint();
				break;
			case 5:
				bu.searchBookUser();
				break;
			case 6:
				books.bookInput();
				break;

			case 7:
				books.bookDelete();
				break;

			case 8:
				ob.userUpdate();
				break;

			case 9:
				ob.userInput();
				break;
			case 0:
				books.writeBookFile();
				ob.userWriteFile();
				System.exit(0);

			}
			while(true){

				secondInterface();

				if(ch==0)
					return;
			}



		}*/






