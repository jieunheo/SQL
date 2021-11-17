package ezen;

public class DBTest
{
	public static void main(String[] args)
	{
		DBManager db = new DBManager();
		if ( db.DBOpen() == true )
		{
			System.out.println("DB연결 성공");
			
			String sql = "";
			
			//SQL구문 실행 모드
			//0-insert, 1-delete, 2-update, 3-select
			int mode = 3;
			
			if (mode == 0)
			{
				for (int i=1; i<=100; i++)
				{
					sql  = "insert into memo ";
					sql += "(mtitle, mnote) ";
					sql += "values ";
					sql += "('" + i + "번째 제목입니다.','" + i + "번째 메모입니다.');";
					db.RunSQL(sql);
				}
				
				System.out.println("insert 성공");
			} else if (mode == 1)
			{
				sql = "delete from memo;";
				db.RunSQL(sql);
				
				System.out.println("delete 성공");
			} else if (mode == 2)
			{
				sql = "update memo set mtitle = 'My Title';";
				db.RunSQL(sql);
				
				System.out.println("update 성공");
			} else if (mode == 3)
			{
				sql = "select mno, mnote from memo order by mno desc;";
				if ( db.OpenQuery(sql) == true )
				{
					while (db.GetNext())
					{
						String mno = db.GetValue("mno");
						String mnote = db.GetValue("mnote");
						
						System.out.println("mno: " + mno);
						System.out.println("mnote: " + mnote);
						System.out.println("==========");
					}
					
					db.CloseQuery();
					System.out.println("select 성공");
				} else
				{
					System.out.println("select 실패");
				}
			}
			
			db.DBClose(); //db 닫기
		} else
		{
			System.out.println("DB연결 오류");
		}
	}
}