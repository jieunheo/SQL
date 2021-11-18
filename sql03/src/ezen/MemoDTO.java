package ezen;

/* DTO: Data Transfer Object */
/* DAO: Data Access Object */
public class MemoDTO extends DBManager
{
	/* '�� ''�� �ٲ� */
	private String _R(String value)
	{
		return value.replace("'", "''");
	}
	
	/* MemoVo�� DB�� ���� */
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