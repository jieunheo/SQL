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
			//JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//db연결할 변수
			String host = "jdbc:mysql://localhost:3306/ezen";
			host += "?useUnicode=ture&characterEncoding=utf-8&serverTimezone=UTC"; //db주소
			String userid = "root"; //id
			String userpw = "ezen"; //pw
			
			//db연결
			Connection conn = null;
			conn = DriverManager.getConnection(host, userid, userpw);
			
			//작업 처리용 클래스 할당
			Statement stmt = conn.createStatement();
			String sql; //sql구문
			
			//sql문 적용 - 세미콜론 생략 가능
			/*
			sql = "insert into memo (mnote) values ('몇번째 메모입니까?');";
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
			ResultSet result = stmt.executeQuery(sql);	//select는 executeQuery()로 받아옴
			while (result.next() == true)				//가져온 값의 다음 줄에 데이터가 있다면
			{
				int mno = result.getInt("mno");			//mno 칼럼값 가져오기(칼럼 인덱스를 값으로 사용 가능)
				String mnote = result.getString("mnote");
				System.out.println("mno: " + mno);
				System.out.println("mnote: " + mnote);
				System.out.println("==========");
			}
			stmt.close(); //statment 닫기(*필수)
			
			conn.close(); //db연결 종료(*필수)
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