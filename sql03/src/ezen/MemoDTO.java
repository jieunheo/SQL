package ezen;

/* DTO: Data Transfer Object */
/* DAO: Data Access Object */
public class MemoDTO
{
	/* '�� ''�� �ٲ� */
	private String _R(String value)
	{
		return value.replace("'", "''");
	}
	
	/* MemoVo�� DB�� ���� */
	public boolean Insert(MemoVO vo)
	{
		DBManager db = new DBManager();
		
		//DB ����
		if ( db.DBOpen() == false ) return false;
		
		//insert ����
		String sql = "";
		sql += "insert into memo ";
		sql += "(mtitle, mnote) ";
		sql += "values ";
		sql += "('" + _R(vo.getTitle()) + "','" + _R(vo.getNote()) + "');";
		db.RunSQL(sql);
		
		//DB ����
		db.DBClose();
		
		return true;
	}
}