import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.JSONObject;

public class Project01_E {

	public static void map_service(String point_x, String point_y, String address) {
		String URL_STATICMAP = "https://naveropenapi.apigw.ntruss.com/map-static/v2/raster?";
		
		try {
			String pos = URLEncoder.encode(point_x + " " + point_y,"UTF-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		
		String clientId = "3dbkfwpg2l";
		String clientSecret = "cHLyuA55lqMYyL1KnbQrmeTmm8k7JUVAxd7kamr5";
		
		try {
			System.out.println("주소를 입력하세요");
			
			String address = io.readLine();
			String addr = URLEncoder.encode(address,"UTF-8"); // 입력 공백도 문자처리 해줘야 하기 떄문
			String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr;
			URL url = new URL(apiURL);
			
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			
			int responseCode = con.getResponseCode();
			
			
			BufferedReader br;
			if (responseCode == 200) { // 정상호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			}else {
				System.out.println(responseCode);
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer(); // 문자열 추가 변경시 사용
			
			String x="";// 경도
			String y="";// 위도
			String z="";// 주소
			
			while((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
			
			JSONTokener tokener = new JSONTokener(response.toString());
			JSONObject object = new JSONObject(tokener);
			
			JSONArray arr = object.getJSONArray("addresses");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject temp = (JSONObject) arr.get(i);
				
				System.out.println("address : " + temp.get("roadAddress"));
				System.out.println("jibunAddress : " + temp.get("jibunAddress"));
				System.out.println("경도 : " + temp.get("x"));
				System.out.println("위도 : " + temp.get("y"));
				System.out.println(temp);
				x = (String)temp.get("x");
				y = (String)temp.get("y");
				z = (String)temp.get("roadAddress");
				
				// map_service(경도(x),위도(y),주소(address)) : 지도 이미지 생성 메서드 호출)
				
			}
			
			map_service(x,y,z);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
