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
		//insert ����
		String sql = "";
		sql += "insert into memo ";
		sql += "(mtitle, mnote) ";
		sql += "values ";
		sql += "('" + _R(vo.getTitle()) + "','" + _R(vo.getNote()) + "');";
		return RunSQL(sql);
	}
	
	/* MemoVO�� Select */
	public MemoVO Select(int no)
	{
		MemoVO vo = new MemoVO();
		
		//select ����
		String sql = "";
		sql += "select * ";
		sql += "from memo ";
		sql += "where mno = " + no + ";";
		if (OpenQuery(sql) == false) return null;
		if (GetNext() == false) return null;
		
		while (GetNext())
		{
			vo.setNo(Integer.parseInt(GetValue("mno")));
			vo.setTitle(GetValue("mtitle"));
			vo.setNote(GetValue("mnote"));
			vo.setDate(GetValue("mdate"));
		}
		
		CloseQuery();
		return vo;
	}
}