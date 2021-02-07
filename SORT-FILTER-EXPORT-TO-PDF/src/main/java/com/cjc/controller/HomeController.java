package com.cjc.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cjc.export.ExportToExcel;
import com.cjc.export.ExportToPdf;
import com.cjc.model.Student;
import com.cjc.repository.HomeRepository;
import com.cjc.service.HomeService;

@Controller
public class HomeController {

	List<Student> sList; // declared globally for methods login check, excel and pdf generation

	@Autowired
	HomeService hs;

	@Autowired
	HomeRepository hr;

	@RequestMapping("/")
	// this method is useful when there is no web.xml file
	public String prelogin() {

		System.out.println("this is my Prelogin Method");
		return "login";
	}

	@RequestMapping("/register")
	public String preregister() {
		return "register";
	}

	@RequestMapping("/log")
	public String register() {
		return "login";
	}

	@RequestMapping("/reg")
	public String registerData(@ModelAttribute("stu") Student s, Model m) {
		int id = hs.saveData(s);
		if (id > 0) {
			String message = s.getId() + " Added Successfully! You can now login";
			m.addAttribute("msg", message);
			return "login";
		}
		else {
			String message = "Id " + s.getId() + " is Allready Present! Please enter another ID";
			m.addAttribute("msg", message);
			return "register";
		}
	}

	@RequestMapping("*")
	public String errorMapping() {
		System.out.println("This is error page controller");
		return "error";
	}

	@RequestMapping(value = "/login")
	public String loginData(@RequestParam("uname") String uname, @RequestParam("pass") String pass, Model m) {
		System.out.println("This is Login page Controller");
		// List<Student> sList;

		if (uname.equals("admin") && pass.equals("admin")) {
			sList = hs.loginCheck(uname, pass);
			m.addAttribute("data", sList);
		}
		else {
			sList = hr.findByUnameAndPass(uname, pass);
			m.addAttribute("data", sList);
		}
		if (!sList.isEmpty()) {
			m.addAttribute("data", sList);
			return "success";
		}
		else {
			String message = "Incorrect User name or password";
			m.addAttribute("msg", message);
			return "login";
		}
	}

	@RequestMapping("/delete")
	public String deleteData(@RequestParam("select") int id, Model m) {
		System.out.println("This is Delete Page Controller");
		hs.deleteStudent(id);
		List<Student> slist = hs.getAllStu();
		m.addAttribute("data", slist);
		return "success";
	}

	@RequestMapping("/edit")
	public String editData(@RequestParam("select") int id, Model m) {
		System.out.println("This is Edit Page Controller");
		Student stu = hs.getStudentById(id);
		m.addAttribute("stu", stu);
		return "update";
	}

	@RequestMapping("/update")
	public String updateData(@ModelAttribute("stu") Student stu, Model m) {
		System.out.println("This is Update Page Controller");
		hs.updateStudent(stu);
		List<Student> sList = hs.getAllStu();
		m.addAttribute("data", sList);
		return "success";
	}

	@RequestMapping("/sort")
	public String Sortdata(@RequestParam("sortvalue") int value, Model m) {
		System.out.println("This is sort page controller");
		List<Student> sList = hs.allSortedStu(value);
		m.addAttribute("data", sList);
		return "success";
	}

	@RequestMapping("/clear")
	public String clearFilter(Model m) {
		System.out.println("This is clearFilter page controller");
		List<Student> sList = hs.getAllStu();
		m.addAttribute("data", sList);
		return "success";
	}

	@RequestMapping("/filter")
	public String filterStudents(@RequestParam("keyword") String keyword, Model m) {
		System.out.println("This is Filter page controller");
		List<Student> sList = hs.filterStudents(keyword);
		m.addAttribute("data", sList);
		m.addAttribute("keyword", keyword);
		return "success";
	}

	@GetMapping(value = "/exportpdf", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> employeeReports(HttpServletResponse response) throws IOException {

		// List<Student> sList = hs.getAllStu();
		ByteArrayInputStream bis = ExportToPdf.StudentExport(sList);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=Students.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	@GetMapping("/exportexcel")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=students.xlsx";
		response.setHeader(headerKey, headerValue);

		// List<Student> listUsers = hs.getAllStu();

		ExportToExcel excelExporter = new ExportToExcel(sList);

		excelExporter.export(response);
	}

}
