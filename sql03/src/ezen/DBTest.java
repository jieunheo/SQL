package ezen;

public class DBTest
{
	public static void main(String[] args)
	{
		MemoVO vo = new MemoVO();
		vo.setNo(1);
		vo.setTitle("이것은 '제목'입니다.");
		vo.setNote("이것은 내용입니다.");
		vo.setDate("2021-11-18");
		vo.PrintInfo();
		
		MemoDTO dto = new MemoDTO();
		dto.DBOpen(); //db열기
		for (int i=0; i<100; i++)
		{
			dto.Insert(vo);
		}
		dto.DBClose(); //db닫기
	}
}