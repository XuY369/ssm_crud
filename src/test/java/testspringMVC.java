//import com.github.pagehelper.PageInfo;
//import org.junit.Before;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:springMVC.xml"})
//public class testspringMVC {
//
//    @Autowired
//    WebAppConfiguration configuration;
//    MockMvc mockMvc;
//
//    @Before
//    public void initMokcMvc(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(configuration).build();
//    }
//    public void getPageInfo(){
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("5"))
//                .andReturn();
//        MockHttpServletRequest request = mvcResult.getRequest();
//        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
//        System.out.println(pageInfo.getPageNum());
//    }
//}
//
