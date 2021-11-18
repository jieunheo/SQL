package ezen;

/* DTO: Data Transfer Object */
/* DAO: Data Access Object */
public class MemoDTO extends DBManager
{
	/* '을 ''로 바꿈 */
	private String _R(String value)
	{
		return value.replace("'", "''");
	}
	
	/* MemoVo를 DB에 저장 */
	public boolean Insert(MemoVO vo)
	{
		//insert 실행
		String sql = "";
		sql += "insert into memo ";
		sql += "(mtitle, mnote) ";
		sql += "values ";
		sql += "('" + _R(vo.getTitle()) + "','" + _R(vo.getNote()) + "');";
		return RunSQL(sql);
	}
	
	/* MemoVO를 Select */
	public MemoVO Select(int no)
	{
		MemoVO vo = new MemoVO();
		
		//select 실행
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