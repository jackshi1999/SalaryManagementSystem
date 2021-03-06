package com.jack.salarymanagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jack.salarymanagement.client.AdminClient;
import com.jack.salarymanagement.models.AdminLogin;
import com.jack.salarymanagement.models.EmployeeAdminAccess;
import com.jack.salarymanagement.pojo.ReturnMessage;
import com.jack.salarymanagement.utilities.StringConstants;

@Controller
public class SalaryManagementAdminController {

	@Autowired
	private AdminClient aClient;
	
	static List<String> designationList = null;
	static Integer employeeid = 0;
	
	static {
		designationList = new ArrayList<>();
		designationList.add(StringConstants.CHOOSE_DESIGNATION);
		designationList.add(StringConstants.PROGRAMMER_ANALYST_TRAINEE);
		designationList.add(StringConstants.PROGGRAMMER_ANALYST);
		designationList.add(StringConstants.ASSOSCIATE);
		designationList.add(StringConstants.SR_ASSOSCIATE);
		designationList.add(StringConstants.MANAGER);
		designationList.add(StringConstants.SR_MANAGER);
		designationList.add(StringConstants.BUSINESS_LEAD);
	}
	
	@GetMapping("/loginadmin")
	public String showLoginPage()
	{
		return "login_admin";
	}
	
	@PostMapping("/dologinadmin")
	public String doLogin(@ModelAttribute AdminLogin aLogin,HttpSession session)
	{
		//send aLogin to BuesinessLayer
		ReturnMessage returnMessage = aClient.doValidateAdmin(aLogin);
		String returnPage = null;
		
		if(returnMessage.isValid())
		{
			returnPage = "redirect:/adminhome";
		}
		else
		{
			session.setAttribute("condition", StringConstants.FALSE);
			session.setAttribute("message", StringConstants.ERROR_LOGIN);
			returnPage = "redirect:/loginadmin";
		}
		return returnPage;
	}
	
	@GetMapping("/adminhome")
	public String showAdminHome(Model model)
	{
		model.addAttribute("designationList",designationList);
		model.addAttribute("employeeid", employeeid);
		return "adminhome";
	}
	
	@PostMapping("/dodesignation")
	public String doDesignation(@ModelAttribute EmployeeAdminAccess eAccess,HttpSession session)
	{
		//send eAccess to BusinessLayer
		ReturnMessage returnMessage = aClient.doSetDesignation(eAccess);
		String returnPage = null;
		
		if(returnMessage.isValid())
		{
			session.setAttribute("condition", StringConstants.TRUE);
			session.setAttribute("message", returnMessage.getMessage());
			returnPage = "redirect:/adminhome";
		}
		else
		{
			session.setAttribute("condition", StringConstants.FALSE);
			session.setAttribute("message", returnMessage.getMessage());
			returnPage = "redirect:/adminhome";
		}
		return returnPage;
	}
	
	@PostMapping("/docalculatesalary")
	public String doCalculateSalary(@RequestParam Integer employeeid,HttpSession session)
	{
		//send employeeid to BusinessLayer
		ReturnMessage returnMessage = aClient.doCalculateSalary(employeeid);
		String returnPage = null;
		
		if(returnMessage.isValid())
		{
			session.setAttribute("condition", StringConstants.TRUE);
			session.setAttribute("message", returnMessage.getMessage());
			returnPage = "redirect:/adminhome";
		}
		else
		{
			session.setAttribute("condition", StringConstants.FALSE);
			session.setAttribute("message", returnMessage.getMessage());
			returnPage = "redirect:/adminhome";
		}
		return returnPage;
	}
}
