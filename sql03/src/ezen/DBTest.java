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
		dto.DBOpen(); //db����
		for (int i=0; i<100; i++)
		{
			dto.Insert(vo);
		}
		dto.DBClose(); //db�ݱ�
	}
}