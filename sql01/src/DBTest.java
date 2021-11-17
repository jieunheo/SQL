import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest
{
	public static void main(String[] args)
	{
		try
		{
			//JDBC ����̹� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//db������ ����
			String host = "jdbc:mysql://localhost:3306/ezen";
			host += "?useUnicode=ture&characterEncoding=utf-8&serverTimezone=UTC"; //db�ּ�
			String userid = "root"; //id
			String userpw = "ezen"; //pw
			
			//db����
			Connection conn = null;
			conn = DriverManager.getConnection(host, userid, userpw);
			
			//�۾� ó���� Ŭ���� �Ҵ�
			Statement stmt = conn.createStatement();
			String sql; //sql����
			
			//sql�� ���� - �����ݷ� ���� ����
			/*
			sql = "insert into memo (mnote) values ('���° �޸��Դϱ�?');";
			stmt.executeUpdate(sql);
			stmt.close();
			
			stmt = conn.createStatement();
			sql = "delete from memo";
			stmt.executeUpdate(sql);
			stmt.close();
			
			stmt = conn.createStatement();
			sql = "update memo set mnote = 'hello' where mno = 5;";
			stmt.executeUpdate(sql);
			stmt.close();
			*/
			
			stmt = conn.createStatement();
			sql = "select mno, mnote from memo order by mno desc;";
			ResultSet result = stmt.executeQuery(sql);	//select�� executeQuery()�� �޾ƿ�
			while (result.next() == true)				//������ ���� ���� �ٿ� �����Ͱ� �ִٸ�
			{
				int mno = result.getInt("mno");			//mno Į���� ��������(Į�� �ε����� ������ ��� ����)
				String mnote = result.getString("mnote");
				System.out.println("mno: " + mno);
				System.out.println("mnote: " + mnote);
				System.out.println("==========");
			}
			stmt.close(); //statment �ݱ�(*�ʼ�)
			
			conn.close(); //db���� ����(*�ʼ�)
		} catch (ClassNotFoundException e)
		{	//Class.forName()
			e.printStackTrace();
			return;
		} catch (SQLException e)
		{	//DriverManager.getConnection()
			e.printStackTrace();
			return;
		}
	}
}