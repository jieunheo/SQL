package ezen;

import java.util.ArrayList;

public class DBTest
{
	public static void main(String[] args)
	{
		MemoVO vo = new MemoVO();    //memo 객체
		MemoDTO dto = new MemoDTO(); //memo 컨트롤러
		
		if (dto.DBOpen() == true) //db열기
		{
			//0-insert, 1-select
			//2-delete, 3-update
			//4-select list
			int mode = 4;
			
			switch (mode)
			{
				case 0: //insert
					for (int i=1; i<=100; i++)
					{
						vo.setTitle("이것은 제목" + i + "입니다.");
						dto.Insert(vo);
					}
					break;
				case 1: //select
					vo = dto.Select(303);
					if (vo != null) vo.PrintInfo();
					break;
				case 2: //delete
					dto.Delete(301);
					break;
				case 3: //update
					vo = dto.Select(302);
					vo.PrintInfo();
					vo.setTitle("302 바꾼 제목1");
					vo.setNote("302 바꾼 내용1");
					dto.Update(vo);
					break;
				case 4: //select list
					MemoVO[] volist = dto.SelectList();
					for(MemoVO item : volist)
					{
						if( item != null) item.PrintInfo();
					}
					break;
//				case 5: //select arraylist
//					ArrayList<MemoVO> list;
//					list = dto.SelectArray();
//					/*
//					for(int i=0; i < list.size(); i++)
//					{
//						MemoVO item = (MemoVO)list.get(i);
//						item.PrintInfo();
//					}
//					*/
//					for(MemoVO temp : list)
//					{
//						temp.PrintInfo();
//					}
//					break;
			}
			dto.DBClose(); //db닫기
		}
	}
}