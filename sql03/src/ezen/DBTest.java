package ezen;

public class DBTest
{
	public static void main(String[] args)
	{
		MemoVO vo = new MemoVO();
		vo.setNo(1);
		vo.setTitle("�̰��� '����'�Դϴ�.");
		vo.setNote("�̰��� �����Դϴ�.");
		vo.setDate("2021-11-18");
		vo.PrintInfo();
		
		MemoDTO dto = new MemoDTO();
		dto.DBOpen();
		dto.Insert(vo);
		dto.DBClose();
	}
}