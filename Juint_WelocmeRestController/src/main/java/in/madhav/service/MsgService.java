package in.madhav.service;

import org.springframework.stereotype.Service;

@Service
public class MsgService {

	public String getMsg() {

		String name = "welcome";

		return name;

	}

	public String getGreet() {

		String name = "Good Luck...";

		return name;
	}

}
