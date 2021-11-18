package ezen;

/* DTO: Data Transfer Object */
/* DAO: Data Access Object */
public class MemoDTO
{
	/* 'À» ''·Î ¹Ù²Þ */
	private String _R(String value)
	{
		return value.replace("'", "''");
	}
	
	/* MemoVo¸¦ DB¿¡ ÀúÀå */
	public boolean Insert(MemoVO vo)
	{
		DBManager db = new DBManager();
		
		//DB ¿ÀÇÂ
		if ( db.DBOpen() == false ) return false;
		
		//insert ½ÇÇà
		String sql = "";
		sql += "insert into memo ";
		sql += "(mtitle, mnote) ";
		sql += "values ";
		sql += "('" + _R(vo.getTitle()) + "','" + _R(vo.getNote()) + "');";
		db.RunSQL(sql);
		
		//DB ´ÝÀ½
		db.DBClose();
		
		return true;
	}
}