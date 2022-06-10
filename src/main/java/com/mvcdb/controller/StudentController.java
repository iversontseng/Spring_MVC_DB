package com.mvcdb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdb.service.StudentSearch;
import com.mvcdb.model.Students;
@Controller
public class StudentController {
	@Autowired
	private StudentSearch search;
	
	@RequestMapping("/")
	public String viewhomepage(Model model) {
		List<Students> liststudent = search.listAll();
		model.addAttribute("List",liststudent);
		return "index";
	}
	@RequestMapping("/new")
	public String NewStudentForm(Model model) {
		Students stu = new Students();
		model.addAttribute("student",stu);
		
		return "new_student";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String Savestudent(@ModelAttribute("student")Students stu) {
		search.save(stu);
		return "redirect:/";
	}
	@RequestMapping("/edit/{ID}")
	public ModelAndView showEditstudentPage(@PathVariable(name = "ID") Long ID) {
	    ModelAndView mav = new ModelAndView("edit_student");
	    Students stu = search.get(ID);
	    mav.addObject("student", stu);
	     
	    return mav;
	}

	@RequestMapping("/delete/{ID}")
	public String deleteProduct(@PathVariable(name = "ID") Long ID) {
		search.delete(ID);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public String searchresult(Model model,HttpServletRequest req) {
		String name = req.getParameter("name");
		List<Students> liststudent = search.findByName(name);
		model.addAttribute("List",liststudent);
		return "result";
	}
}
