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
			/* //insert
			for (int i=1; i<=100; i++)
			{
				vo.setTitle("�̰��� ����" + i + "�Դϴ�.");
				dto.Insert(vo);
			}
			*/
			
			/* //select
			vo = dto.Select(303);
			if (vo != null)
			{
				vo.PrintInfo();
			}
			*/
			
			/* //delete
			dto.Delete(303);
			*/
			
			//update
			vo = dto.Select(304);
			vo.PrintInfo();
			vo.setTitle("�ٲ� ����");
			vo.setNote("�ٲ� ����");
			dto.Update(vo);
			
			dto.DBClose(); //db�ݱ�
		}
	}
}