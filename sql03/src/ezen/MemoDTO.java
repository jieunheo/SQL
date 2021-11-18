package ezen;

import java.util.ArrayList;

/* DTO: Data Transfer Object */
/* DAO: Data Access Object */
public class MemoDTO extends DBManager
{
	/* '을 ''로 바꿈 */
	private String _R(String value)
	{
		return value.replace("'", "''");
	}
	
	/* MemoVo를 insert */
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

	/* MemoVO의 전체 값을 Select - 배열 */
	public MemoVO[] SelectList()
	{
		//sql구문
		String sql = "";
		sql = "select count(*) as count from memo;";
		
		//가져올 값의 갯수만큼 배열 생성
		if (OpenQuery(sql) == false) return null; //쿼리 열기
		if (GetNext() == false) 	 return null; //다음값 확인

		MemoVO[] list = null; //내보낼 객체
		int count = GetInteger("count"); //가져올 갯수 확인
		CloseQuery(); //쿼리 닫기
		
		list = new MemoVO[count]; //갯수만큼 생성
		
		//배열에 각 값 추가
		int i = 0;
		sql = "select * from memo order by mno;";
		if (OpenQuery(sql) == false) return null; //쿼리 열기
		while(GetNext())
		{
			MemoVO vo = new MemoVO(); //한줄
			vo.setNo(GetInteger("mno"));
			vo.setTitle(GetValue("mtitle"));
			vo.setNote(GetValue("mnote"));
			vo.setDate(GetValue("mdate"));
			list[i] = vo;
			i++;
		}
		
		CloseQuery(); //쿼리 닫기
		return list;
	}

	/* MemoVO의 전체 값을 Select - Arraylist */
//	public ArrayList<MemoVO> SelectArray()
//	{
//		//sql구문
//		String sql = "";
//		sql = "select count(*) as count from memo;";
//
//		ArrayList<MemoVO> array = null; //내보낼 객체
//		array = new ArrayList<MemoVO>();
//		
//		//배열에 각 값 추가
//		sql = "select * from memo order by mno;";
//		if (OpenQuery(sql) == false) return null; //쿼리 열기
//		while(GetNext())
//		{
//			MemoVO vo = new MemoVO(); //한줄
//			vo.setNo(Integer.parseInt(GetValue("mno")));
//			vo.setTitle(GetValue("mtitle"));
//			vo.setNote(GetValue("mnote"));
//			vo.setDate(GetValue("mdate"));
//			array.add(vo);
//		}
//		
//		CloseQuery(); //쿼리 닫기
//		return array;
//	}
	
	/* MemoVO를 delete */
	public boolean Delete(int no)
	{
		//sql구문
		String sql = "";
		sql += "delete from memo ";
		sql += "where mno = " + no + ";";

		//delete 실행
		return RunSQL(sql);
	}
	
	/* MemoVo를 update */
	public boolean Update(MemoVO vo)
	{
		//sql구문
		String sql = "";
		sql += "update memo ";
		sql += "set mtitle = '" + _R(vo.getTitle()) + "', ";
		sql += "mnote = '" + _R(vo.getNote()) + "' ";
		sql += "where mno = " + vo.getNo() + ";";

		//update 실행
		return RunSQL(sql);
	}
}