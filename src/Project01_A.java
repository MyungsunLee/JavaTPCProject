import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import kr.inflearn.BookDTO;

public class Project01_A {
	public static void main(String[] args) {
		
		BookDTO dto = new BookDTO("자바","에이콘",670,2100);
		
		Gson g = new Gson();
		
		String json = g.toJson(dto);
		
		System.out.println(json);
		
//		JSON -> Object(BookDTO)
		BookDTO dto1 = g.fromJson(json, BookDTO.class);
		System.out.println(dto1);
		System.out.println(dto1.getTitle() + "\t" + dto1.getPrice());
		
		
		
//		Object(List<BookDTO>) -> JSON(String)
		List<BookDTO> lst = new ArrayList<BookDTO>();
		
		lst.add(new BookDTO("자바1","에이콘1",2100,670));
		lst.add(new BookDTO("자바2","에이콘2",3000,670));
		lst.add(new BookDTO("자바3","에이콘3",2700,670));
		
		String lstJson = g.toJson(lst);
		System.out.println(lstJson);
		
//		JSON(String) -> Object(List<BookDTO>) 타입 역추적
		List<BookDTO> lst2= g.fromJson(lstJson, new TypeToken<List<BookDTO>>() {}.getType());
		for (BookDTO vo : lst2) {
			System.out.println(vo);
			
		}
		
		
		
		
		
		
	}
}
