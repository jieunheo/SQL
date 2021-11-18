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
}