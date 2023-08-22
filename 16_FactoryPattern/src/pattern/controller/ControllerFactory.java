package pattern.controller;

import pattern.controller.component.FindController;

// 15 ActionFactory랑 같은거임
public class ControllerFactory {

	// 싱글톤 패턴 
	// * 싱글톤 패턴이란 /js
	//   클래스가 최초 인스턴스화 할때에 한번만 메모리에 객체를 생성하고 이 객체를 사용하는 디자인 패턴이다. 
	//   즉 클래스를 여러번 인스턴스화 하더라도 새로운 객체를 생성하는것이 아닌 기존의 객체를 공유한다.
	
	// 여기서부터
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {
		System.out.println("ControllerFactory Creating...");
	}
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	// 여기까지가 싱글톤 패턴 만드는 부분
	
	// createControlller : 컨트롤러 생성하는 기능
	public Controller createController(String command) {
		
		Controller controller = null;
		
		if(command.equals("findModel")) {
			controller = new FindController();
		}
		
		return controller;
		
	}
	
}
