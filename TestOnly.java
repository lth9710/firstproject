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
		
		//Thread t2 = Thread.currentThread(); ������ ������� ����
		t1.join();
		
		
		TestOnly test = new TestOnly();
		test.firstInterface();
		
		
		
		


		/*System.out.println("1.ȸ������ 2.ȸ����� 3.���� 4.���� 5.ã�� 6.����: ");
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
		System.out.print("1.�����߰�\n2.��������\n3.������ȸ\n4.�����뿩\n5.�����ݳ�\n6.id�˻�\n7.����:");
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
			System.out.println("������������������������");
			System.out.print("��1.�α���    2.����  ��\n");
			System.out.print("������������������������\n : ");
			int ch= sc.nextInt();
			switch(ch){

			case 1:
				//�α���Ȯ��
				secondInterface();
				return;

			case 2:
				System.out.println("��������������������������");
				System.out.println("��  ** �����մϴ�  **   ��");
				System.out.print("��������������������������\n  ");
				books.writeBookFile();
				ob.userWriteFile();
			
				System.exit(0);
			
			}
		}

	}

	public void secondInterface(){

		while(true){

			System.out.println("������������������������������������������������������������������������");
			System.out.print("��1.��������\t2.ȸ������\t3.�������\t4.���� \t   5.����"+"     ��\n");
			System.out.print("������������������������������������������������������������������������\n : ");
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
					
				
				System.out.println("��������������������������");
				System.out.println("��  ** �����մϴ�  **   ��");
				System.out.print("��������������������������\n  ");
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

			System.out.println("����������������������������������������������������������������������������������������������������������");
			System.out.print("��1.�����뿩       2.�����ݳ�      3.�뿩���      4.�����߰�      5.��������      6.����       7.����  ��\n");
			System.out.print("����������������������������������������������������������������������������������������������������������\n : ");
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
				System.out.println("��������������������������");
				System.out.println("��  ** �����մϴ�  **   ��");
				System.out.print("��������������������������\n  ");
				ob.userWriteFile();
				System.exit(0);

			}
		}
	}








	public void userAdmin(){

		while(true){


			System.out.println("������������������������������������������������������������������������������������������������������");
			System.out.print("��1.ȸ�����       2.ȸ�����        3.ȸ��Ż��        4.ȸ����������        5.����        6.����   ��\n");
			System.out.print("������������������������������������������������������������������������������������������������������\n : ");
			
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
				System.out.println("��������������������������");
				System.out.println("��  ** �����մϴ�  **   ��");
				System.out.print("��������������������������\n  ");
				books.writeBookFile();
				ob.userWriteFile();
				System.exit(0);
			}
		}
	}





	public void monney(){
		
		while(true){
			
			System.out.println("������������������������������");
			System.out.print("��1.�Ѹ���  2.����  3.����  ��\n");
			System.out.print("������������������������������\n : ");
			
			
			int ch = sc.nextInt();

			switch(ch){
			case 1:
				books.total();
				break;
			case 2:
				secondInterface();
				break;
			
			default:
				System.out.println("��������������������������");
				System.out.println("��  ** �����մϴ�  **   ��");
				System.out.print("��������������������������\n  ");
				books.writeBookFile();
				ob.userWriteFile();
				System.exit(0);
			}
		}
			
			
		}
	
		
		
		
		
		

		//System.out.print("1.�����뿩 \t2.�����ݳ�\t3.ȸ�����\t4.�뿩���\t5.��ü���\n6.�����߰�"
		//		+ "\t7.��������\t8.ȸ����������\t9.ȸ����� \t0.���������\n:");
	}



	/*public void secondInterface(){
		System.out.println();
		System.out.print("1.�����뿩 \t2.�����ݳ�\t3.ȸ�����\t4.�뿩���\t5.��ü���\n6.�����߰�"
				+ "\t7.��������\t8.ȸ����������\t9.ȸ����� \t0.���������\n:");

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






