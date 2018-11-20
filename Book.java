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
	public Book() { // ������ �����ϴ� ������

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

	public void writeBookFile() { // ���������ϴ¸޼ҵ�

		try {

			if (lists != null) {

				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(lists);// ����Ʈ�� ����������

				fos.close();
				oos.close();
				//System.out.println("���� ���� ����!");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void bookPrint() {

		
		//�ֻ�� ��¼���
		Iterator<BookVO> it = lists.iterator();

		while (it.hasNext()) {
			BookVO vo = it.next();
			System.out.println(vo.toString());

		}

	}

	public void bookInput() {// �����߰�

		Scanner sc = new Scanner(System.in);

		BookVO vo = new BookVO();

		
		
		try {
			
		
		System.out.println("  ������ȣ?  ");
		vo.setId(sc.nextInt());

		System.out.println("  å�̸�?  ");
		vo.setName(sc.next());

		System.out.println("  ����?  ");
		vo.setAuthor(sc.next());

		vo.setRental(false);

		if (lists == null)
			lists = new ArrayList<BookVO>();

		lists.add(vo);

		} catch (Exception e) {
			System.out.println("�߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}
		

	}// end of input

	public void bookDelete() {// �����޼ҵ�
		try {
			
		
		
		
		System.out.println("  ������ å�� ��ȣ�� �Է��ϼ���  ");
		int n = sc.nextInt();

		for (int i = 0; i < lists.size(); i++) {

			if (n == lists.get(i).getId())
				lists.remove(i);
			System.out.println("�����Ǿ����ϴ�");
			break;

		}// end of for

		} catch (Exception e) {
			System.out.println("�߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		
		}		

	}// end of delete

	public void bookBorrow() {

		
		try {
		int w=0;
			
		System.out.print(" �뿩�� ���� ��ȣ�� �Է��ϼ��� \n :");
		
		w = sc.nextInt();
		
		int novel = 1000;
		int carton = 400;
		String w1 = Integer.toString(w);
		String userId="";

		System.out.println(" �뿩�ϴ»���� ID�� �Է��ϼ��� ");
		userId=sc.next();

		for (int i = 0; i < lists.size(); i++) {
			if (w == lists.get(i).getId()) {
				if (lists.get(i).isRental()) {
					System.out.println("  �̹� �뿩���Դϴ�  ");
					return;
				} else if ((!lists.get(i).isRental())) {
					System.out.println("  ���������� �뿩�Ǿ����ϴ�.  ");
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

		System.out.println("������������������������");
		System.out.println("��1.�߰�   2.�Ϸ�     ��");
		System.out.print("������������������������\n : ");
		if(sc.nextInt()==1)
			bookBorrow();
		else{
			System.out.println("  "+tot+"�� �Դϴ�  ");
			
		}
		
		} catch (Exception e) {
			System.out.println("�߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}
		
	}



	public void bookReturn() {

		
		try {
			
		
		System.out.println("  �ݳ��� ���� ��ȣ�� �Է��ϼ���  ");
		int w = sc.nextInt();

		for (int i = 0; i < lists.size(); i++) {

			if (w == lists.get(i).getId())
				if (!lists.get(i).isRental()) {
					System.out.println("  �뿩���� �ƴմϴ�  ");
				} else if (lists.get(i).isRental()) {
					System.out.println("  ���������� �ݳ��Ǿ����ϴ�.  ");
					lists.get(i).setRental(false);
					lists.get(i).setUserId(null);
				}

		}
		} catch (Exception e) {
			System.out.println("�߸��Է��ϼ̽��ϴ�");
			sc=new Scanner(System.in);
		}
	}

	public void searchBook() {


		int id = 0;
		UserVO ob = new UserVO();
		boolean flag = false;
		System.out.println("  �˻��� ������ȣ?  ");
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
			System.out.println("  ã�´���� �����ϴ�.  ");
		}
	}

	public boolean searchFlagBook() {

		boolean flag = false;
		System.out.println("  �˻��� ������ȣ?  ");
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
			System.out.println("  ã�´���� �����ϴ�.  ");
		}
		return flag;
	}

	public List<Integer> rentalBookList() { // ������ȣ���޾Ƽ� å����������� ������ȣ��ȯ


		
		int id = 0;
		System.out.println("  �˻��� ������ȣ?  ");
		int searchid = sc.nextInt();

		
		List<Integer> booklist = new ArrayList<Integer>();



		Iterator<BookVO> it = lists.iterator();
		while (it.hasNext()) {
			BookVO vo = it.next();
			

			if (searchid==(vo.getId())) { // ������ȣ�� �˻��� ������ȣ �� ������
				if(vo.isRental()){ // ����ȵ������� ����ȵȵ������� ����
					System.out.println(vo.toString()); // ����ȵ������ å������ ���
					 booklist.add(id, vo.getId()); 	//  ��Ʈ�Ӽ� ����Ʈ�� å�� ��ȣ�� ����
					id++;
				}

				

			}else{
				
			}
		}
		return booklist;// ����Ʈ�� ��ȣ���� ��ȯ��


		


	}

	
/*public int rentalBookList() { // ������ȣ���޾Ƽ� å����������� ������ȣ��ȯ


		
		int id = 0;
		System.out.println("�˻��� ������ȣ?");
		int searchid = sc.nextInt();

		



		Iterator<BookVO> it = lists.iterator();
		while (it.hasNext()) {
			BookVO vo = it.next();
			

			if (searchid==(vo.getId())) { // ������ȣ�� �˻��� ������ȣ �� ������
				if(vo.isRental()){ // ����ȵ������� ����ȵȵ������� ����
					System.out.println(vo.toString()); // ����ȵ������ å������ ���
					id =vo.getId();
					
					//  ��Ʈ�Ӽ� ����Ʈ�� å�� ��ȣ�� ����
					
				}

				

			}else{
				
			}
		}
		return id;// ����Ʈ�� ��ȣ���� ��ȯ��


		


	}*/



	public String getUserId(int id){//������ȣ�����ؼ� USerid�� �����;���

		String getid="";
		

		Iterator<BookVO> it = lists.iterator();

		while (it.hasNext()) {
			BookVO vo = it.next();
			if (id==(vo.getId())) {//������ȣ�� å�� ��ȣ�� ������
				
				getid=vo.getUserId(); // �ش絵���� �����id�� ������
				
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
