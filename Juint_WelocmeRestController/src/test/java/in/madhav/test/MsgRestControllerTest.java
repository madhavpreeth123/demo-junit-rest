package in.madhav.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.madhav.rest.MsgRestController;
import in.madhav.service.MsgService;

@WebMvcTest(value = MsgRestController.class)
public class MsgRestControllerTest {

	//@Autowired// inject real object
	
	@MockBean //inject dummy object
	private MsgService mockService;
	
	@Autowired //to set http req to rest methods
	private MockMvc mockMvc;
	
	
	@Test
	public void testWelcome() throws Exception {
		when(mockService.getMsg()).thenReturn("welcome");
		
		//prepare http req
		
		MockHttpServletRequestBuilder requestBuilder
		= MockMvcRequestBuilders.get("/welcome");
		
		 MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		 MockHttpServletResponse response = mvcResult.getResponse();
		 
		 int status = response.getStatus();
		 
		 assertEquals(200, status);
		
	}
	
	
	@Test
	public void testGreet() throws Exception {
		
		when(mockService.getGreet()).thenReturn("Good Luck...");
		
		MockHttpServletRequestBuilder mockHttpServletRequestBuilder =
				MockMvcRequestBuilders.get("/greet");
		
		MvcResult result = mockMvc.perform(mockHttpServletRequestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		int status = response.getStatus();
		
		assertEquals(200, status);
	}
	
}
