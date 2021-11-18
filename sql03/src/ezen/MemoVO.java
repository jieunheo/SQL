package ezen;

/* VO: Value Object */
public class MemoVO
{
	private int    no;    //��ȣ
	private String title; //����
	private String note;  //����
	private String date;  //����
	
	/* ������ */
	public MemoVO() {}
	public MemoVO(String title, String note) {
		this.title = title;
		this.note = note;
	}
	public MemoVO(int no, String title, String note,String date) {
		this.no = no;
		this.title = title;
		this.note = note;
		this.date = date;
	}
	
	/* getter */
	public int    getNo()    { return no;    }
	public String getTitle() { return title; }
	public String getNote()  { return note;  }
	public String getDate()  { return date;  }
	
	/* setter */
	public void setNo(int no)		   { this.no = no;		 }
	public void setTitle(String title) { this.title = title; }
	public void setNote(String note)   { this.note = note;	 }
	public void setDate(String date)   { this.date = date;	 }
	
	/* print Info */
	public void PrintInfo()
	{
		System.out.println("��ȣ: " + no);
		System.out.println("����: " + title);
		System.out.println("����: " + note);
		System.out.println("����: " + date);
	}
}