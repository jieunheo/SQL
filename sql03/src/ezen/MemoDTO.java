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
		//sql구문
		String sql = "";
		sql += "insert into memo ";
		sql += "(mtitle, mnote) ";
		sql += "values ";
		sql += "('" + _R(vo.getTitle()) + "','" + _R(vo.getNote()) + "');";
		
		//insert 실행
		return RunSQL(sql);
	}
	
	/* MemoVO를 Select */
	public MemoVO Select(int no)
	{
		//sql구문
		String sql = "";
		sql += "select * ";
		sql += "from memo ";
		sql += "where mno = " + no + ";";
		
		//select 실행
		if (OpenQuery(sql) == false) return null; //쿼리 열기
		if (GetNext() == false) 	 return null; //다음값 확인

		MemoVO vo = new MemoVO(); //내보낼 객체
		vo.setNo(Integer.parseInt(GetValue("mno")));
		vo.setTitle(GetValue("mtitle"));
		vo.setNote(GetValue("mnote"));
		vo.setDate(GetValue("mdate"));
		
		CloseQuery(); //쿼리 닫기
		return vo;
	}
}