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
	//System.getProperty() ����Ǵ� ���� �ּ� ����
	private File f = new File(path, "\\data\\library6.txt");//���ϻ���


	@SuppressWarnings("unchecked")
	public User(){

		try {
			if(!f.getParentFile().exists()){//�����̾�����
				f.getParentFile().mkdirs();
			}

			if(f.exists()){//������������
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
			// rentBook�� rental(t/f) ����
			user.getRentalBook().add(rentBook.getId());
		}else{
			System.out.println("�뿩�ϰ��� �ϴ� å�� �����ϴ�.");
		}
	}



	public BookVO searchById(int bookId) {
				boolean flag = false;
		System.out.println("�˻��� ���̵�?");
		String searchid = sc.next();

		Iterator<BookVO> it =blists.iterator();

		while(it.hasNext()){
			BookVO vo = it.next();
			if(searchid.equals(vo.getId())){
				bookId=blists.indexOf(vo);
			}	
		}
		if(!flag){
			System.out.println("ã�´���� �����ϴ�.");
		}

		return  blists.get(bookId);

	}
	 */

	public void userWriteFile(){//��������

		try {

			if(lists!=null){

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(lists);

				fos.close();
				oos.close();
				//System.out.println("ȸ�����Լ���!");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}











	public void userPrint(){//���

		
		
		// ��� �ֻ�� ����System.out.println();
		
		Iterator<UserVO> it = lists.iterator();
		while(it.hasNext()){
			UserVO vo = it.next();

			System.out.println(vo.toString());
		}
	}









	public void userInput(){//�Է�

		Scanner sc = new Scanner(System.in);
		UserVO vo = new UserVO();

		String pw1;

		System.out.println("  ID :   ");
		vo.setId(sc.next());

		if(vo.getId().length()<5||vo.getId().length()>15){
			System.out.println("  ID�� 5~10���̳�, �����ڿ� ���ڸ� ȥ���Ͽ� ���弼��.  ");
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
			System.out.println("  ������ ���� ȥ���Դϴ�  ");

			return;
		}

		if(searchId(vo.getId())){
			System.out.println("  ID�� �����մϴ�..  ");
			return;
		}

		vo.setUserId(vo.getId());
		while(true){
			System.out.print("  ��й�ȣ :   ");
			vo.setPw(sc.next());
			System.out.print("  ��й�ȣ ��Ȯ��  ");
			pw1 = sc.next();
			if(vo.getPw().equals(pw1)){
				break;
			}
		}

		System.out.print("  �̸� :   ");
		vo.setName(sc.next());
		System.out.print("  ���� :   ");
		vo.setGender(sc.next());
		System.out.print("  ������� :   ");
		vo.setBirth(sc.next());
		System.out.print("  Email :   ");
		vo.setEmail(sc.next());
		System.out.print("  ��ȭ��ȣ :   ");
		vo.setTel(sc.next());

		if(lists==null)
			lists = new ArrayList<UserVO>();
		lists.add(vo);



		System.out.println("  ȸ�������� �Ϸ�Ǿ����ϴ�.  ");


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
		System.out.println("�˻��� ���̵�?");
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
		System.out.println("  �˻��� ���̵�?  ");
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
			System.out.println("  ã�´���� �����ϴ�.  ");
		}
	}
	//ȸ��Ż�� , �˻�

	public void userUpdate(){

		String pw2="";
		int index = 0;
		boolean flag = false;

		System.out.println("  ������ ���̵�?  ");
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
			System.out.println("  ã�´���� �����ϴ�.  ");
			return;
		}

		UserVO vo2 = new UserVO();
		vo2.setId(searchid);

		while(true){
			System.out.print("  ��й�ȣ :   ");
			vo2.setPw(sc.next());
			System.out.print("  ��й�ȣ ��Ȯ��:   ");
			pw2 = sc.next();
			if(vo2.getPw().equals(pw2)){
				break;
			}
		}

		System.out.print("  �̸� :   ");
		vo2.setName(sc.next());
		System.out.print("  ���� :   ");
		vo2.setGender(sc.next());
		System.out.print("  ������� :   ");
		vo2.setBirth(sc.next());
		System.out.print("  Email :   ");
		vo2.setEmail(sc.next());
		System.out.print("  ��ȭ��ȣ :   ");
		vo2.setTel(sc.next());
		vo2.setUserId(searchid);

		it =lists.iterator();

		while(it.hasNext()){
			UserVO vo = it.next();
			if(searchid.equals(vo.getId())){
				index = lists.indexOf(vo);
				lists.set(index, vo2);

				System.out.println("  �����Ǿ����ϴ�.  ");

				flag =true;
			}	
		}
		if(!flag){
			System.out.println("  ã�� ����� �����ϴ�.  ");
		}


	}


	//�α���(�뿩���� �� å���ø޴�) ,
	public void userLogin(){


	}







	//ȸ��Ż��
	public void userDelete() {

		System.out.println("  ������ ���̵�?  ");
		String deleteId = sc.next();

		Iterator<UserVO> it = lists.iterator();

		while(it.hasNext()){

			UserVO vo = it.next();
			if(deleteId.equals(vo.getId())){
				lists.remove(vo);
				System.out.println("  �����Ǿ����ϴ�  ");
			}


		}
	}






	public void rentalUserList(String searchid){ // id���� �޾Ƽ� �뿩���̾ƴ���, �뿩���̶�� �������ȴ���



		if(searchid.equals("")){
			System.out.println("  �뿩���� �ƴ� �����Դϴ�  ");
			return;
		}

		Iterator<UserVO> userit = lists.iterator();
		while(userit.hasNext()){
			UserVO uvo = userit.next();
			if(searchid.equals(uvo.getId())){
				System.out.println("  �뿩������: "+uvo.toString());

			}

		}

	}




	public void print(){//���

		Iterator<UserVO> it = lists.iterator();
		while(it.hasNext()){
			UserVO vo = it.next();
			System.out.println(vo.toString());
		}
	}











}








