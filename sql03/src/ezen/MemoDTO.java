package ezen;

import java.util.ArrayList;

/* DTO: Data Transfer Object */
/* DAO: Data Access Object */
public class MemoDTO extends DBManager
{
	/* '�� ''�� �ٲ� */
	private String _R(String value)
	{
		return value.replace("'", "''");
	}
	
	/* MemoVo�� insert */
	public boolean Insert(MemoVO vo)
	{
		//sql����
		String sql = "";
		sql += "insert into memo ";
		sql += "(mtitle, mnote) ";
		sql += "values ";
		sql += "('" + _R(vo.getTitle()) + "','" + _R(vo.getNote()) + "');";
		
		//insert ����
		return RunSQL(sql);
	}
	
	/* MemoVO�� Select */
	public MemoVO Select(int no)
	{
		//sql����
		String sql = "";
		sql += "select * ";
		sql += "from memo ";
		sql += "where mno = " + no + ";";
		
		//select ����
		if (OpenQuery(sql) == false) return null; //���� ����
		if (GetNext() == false) 	 return null; //������ Ȯ��

		MemoVO vo = new MemoVO(); //������ ��ü
		vo.setNo(Integer.parseInt(GetValue("mno")));
		vo.setTitle(GetValue("mtitle"));
		vo.setNote(GetValue("mnote"));
		vo.setDate(GetValue("mdate"));
		
		CloseQuery(); //���� �ݱ�
		return vo;
	}

	/* MemoVO�� ��ü ���� Select - �迭 */
	public MemoVO[] SelectList()
	{
		//sql����
		String sql = "";
		sql = "select count(*) as count from memo;";
		
		//������ ���� ������ŭ �迭 ����
		if (OpenQuery(sql) == false) return null; //���� ����
		if (GetNext() == false) 	 return null; //������ Ȯ��

		MemoVO[] list = null; //������ ��ü
		int count = GetInteger("count"); //������ ���� Ȯ��
		CloseQuery(); //���� �ݱ�
		
		list = new MemoVO[count]; //������ŭ ����
		
		//�迭�� �� �� �߰�
		int i = 0;
		sql = "select * from memo order by mno;";
		if (OpenQuery(sql) == false) return null; //���� ����
		while(GetNext())
		{
			MemoVO vo = new MemoVO(); //����
			vo.setNo(GetInteger("mno"));
			vo.setTitle(GetValue("mtitle"));
			vo.setNote(GetValue("mnote"));
			vo.setDate(GetValue("mdate"));
			list[i] = vo;
			i++;
		}
		
		CloseQuery(); //���� �ݱ�
		return list;
	}

	/* MemoVO�� ��ü ���� Select - Arraylist */
//	public ArrayList<MemoVO> SelectArray()
//	{
//		//sql����
//		String sql = "";
//		sql = "select count(*) as count from memo;";
//
//		ArrayList<MemoVO> array = null; //������ ��ü
//		array = new ArrayList<MemoVO>();
//		
//		//�迭�� �� �� �߰�
//		sql = "select * from memo order by mno;";
//		if (OpenQuery(sql) == false) return null; //���� ����
//		while(GetNext())
//		{
//			MemoVO vo = new MemoVO(); //����
//			vo.setNo(Integer.parseInt(GetValue("mno")));
//			vo.setTitle(GetValue("mtitle"));
//			vo.setNote(GetValue("mnote"));
//			vo.setDate(GetValue("mdate"));
//			array.add(vo);
//		}
//		
//		CloseQuery(); //���� �ݱ�
//		return array;
//	}
	
	/* MemoVO�� delete */
	public boolean Delete(int no)
	{
		//sql����
		String sql = "";
		sql += "delete from memo ";
		sql += "where mno = " + no + ";";

		//delete ����
		return RunSQL(sql);
	}
	
	/* MemoVo�� update */
	public boolean Update(MemoVO vo)
	{
		//sql����
		String sql = "";
		sql += "update memo ";
		sql += "set mtitle = '" + _R(vo.getTitle()) + "', ";
		sql += "mnote = '" + _R(vo.getNote()) + "' ";
		sql += "where mno = " + vo.getNo() + ";";

		//update ����
		return RunSQL(sql);
	}
}