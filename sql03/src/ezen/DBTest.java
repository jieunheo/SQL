package ezen;

public class DBTest
{
	public static void main(String[] args)
	{
		MemoVO vo = new MemoVO();
		vo.setNo(1);
		vo.setTitle("이것은 제목입니다.");
		vo.setNote("이것은 내용입니다.");
		vo.setDate("2021-11-18");
		vo.PrintInfo();
		
		MemoDTO dto = new MemoDTO();
		if (dto.DBOpen() == true) //db열기
		{
			/*
			for (int i=1; i<=100; i++)
			{
				vo.setTitle("이것은 제목" + i + "입니다.");
				dto.Insert(vo);
			}
			*/
			
			vo = dto.Select(303);
			if (vo != null)
			{
				vo.PrintInfo();
			}
			
			dto.DBClose(); //db닫기
		}
	}
}