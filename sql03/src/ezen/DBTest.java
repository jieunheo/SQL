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
			/* //insert
			for (int i=1; i<=100; i++)
			{
				vo.setTitle("이것은 제목" + i + "입니다.");
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
			vo.setTitle("바꾼 제목");
			vo.setNote("바꾼 내용");
			dto.Update(vo);
			
			dto.DBClose(); //db닫기
		}
	}
}