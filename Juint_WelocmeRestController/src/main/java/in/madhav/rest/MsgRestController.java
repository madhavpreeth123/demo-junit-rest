package in.madhav.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.madhav.service.MsgService;

@RestController
public class MsgRestController {

	@Autowired
	private MsgService service;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		
		String msg = service.getMsg();
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/greet")
	public ResponseEntity<String> greet(){
		
		String msg = service.getGreet();
		
		return new ResponseEntity<>(msg,HttpStatus.OK);
		
	}
	
}
