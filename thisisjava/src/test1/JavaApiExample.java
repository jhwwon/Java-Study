package test1;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaApiExample {

	public static void main(String[] args) throws Exception {		
		apitest();		// 1
		first();		// 2
		second();		// 3
	}
	
	// web api get 요청
	private static void apitest() throws Exception {
		// 1. HttpClient 객체 생성
		HttpClient client = HttpClient.newHttpClient();
		
		// 요청 파라미터
		String jsonBody = String.format(
	            "{\"contents\": [{\"parts\": [{\"text\": \"%s\"}]}]}",
	            // JSON 문자열 내에 따옴표가 포함될 경우 이스케이프 처리가 필요합니다.
	            // 여기서는 간단화를 위해 사용자가 일반 텍스트를 입력한다고 가정합니다.
	            // 실제 사용 시 prompt 내부에 특수문자가 있다면 `prompt.replace("\"", "\\\"")` 등으로 처리해야 합니다.
	            "java에서 method는 어떻게 선언하고 호출해야 하나요?" // 프롬프트 내의 따옴표를 이스케이프 처리
	        );
		
		// 2. 요청할 URL를 설정하고 HttpRequest 객체 생성
		HttpRequest request = HttpRequest.newBuilder()
			//.uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
			.uri(URI.create("https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent"))
			.header("Content-Type", "application/json")
			.header("X-goog-api-key", "AIzaSyCaO0UssKxDz6ubMFEiuW6BaQaLI2dwPCI")
			//.GET()													// method get요청
			.POST(HttpRequest.BodyPublishers.ofString(jsonBody))		// method post요청
			.build();
		
		// 3. 실제 API요청을 하고 응답을 받음
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		// 4. Response값을 콘솔에 출력
		System.out.println(response.body());
	}
	
	private static void first() {
		System.out.println("1번 함수");
	}
	private static void second() {
		System.out.println("2번 함수");
	}

}
