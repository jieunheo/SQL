package ezen;

public class DBTest
{
	public static void main(String[] args)
	{
		DBManager db = new DBManager();
		if ( db.DBOpen() == true )
		{
			System.out.println("DB���� ����");
			
			String sql = "";
			
			//SQL���� ���� ���
			//0-insert, 1-delete, 2-update, 3-select
			int mode = 3;
			
			if (mode == 0)
			{
				for (int i=1; i<=100; i++)
				{
					sql  = "insert into memo ";
					sql += "(mtitle, mnote) ";
					sql += "values ";
					sql += "('" + i + "��° �����Դϴ�.','" + i + "��° �޸��Դϴ�.');";
					db.RunSQL(sql);
				}
				
				System.out.println("insert ����");
			} else if (mode == 1)
			{
				sql = "delete from memo;";
				db.RunSQL(sql);
				
				System.out.println("delete ����");
			} else if (mode == 2)
			{
				sql = "update memo set mtitle = 'My Title';";
				db.RunSQL(sql);
				
				System.out.println("update ����");
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
					System.out.println("select ����");
				} else
				{
					System.out.println("select ����");
				}
			}
			
			db.DBClose(); //db �ݱ�
		} else
		{
			System.out.println("DB���� ����");
		}
	}
}