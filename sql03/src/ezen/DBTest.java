package ezen;

public class DBTest
{
	public static void main(String[] args)
	{
		MemoVO vo = new MemoVO();
		vo.setNo(1);
		vo.setTitle("�̰��� �����Դϴ�.");
		vo.setNote("�̰��� �����Դϴ�.");
		vo.setDate("2021-11-18");
		vo.PrintInfo();
		
		MemoDTO dto = new MemoDTO();
		if (dto.DBOpen() == true) //db����
		{
			/*
			for (int i=1; i<=100; i++)
			{
				vo.setTitle("�̰��� ����" + i + "�Դϴ�.");
				dto.Insert(vo);
			}
			*/
			
			vo = dto.Select(303);
			if (vo != null)
			{
				vo.PrintInfo();
			}
			
			dto.DBClose(); //db�ݱ�
		}
	}
}