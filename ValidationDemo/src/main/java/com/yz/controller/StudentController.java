package com.yz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yz.entity.Student;

@RestController
public class StudentController {

	@PostMapping("/addStudent")
	public String testValid(@RequestBody @Valid Student stu,BindingResult result) {
		
		StringBuffer  errorMsg = new StringBuffer();
		if(result.hasErrors()) {
			List<ObjectError> errorList = result.getAllErrors();
			for (ObjectError error : errorList) {
				System.out.println(error.getDefaultMessage());//循环打印错误;
				errorMsg.append(error.getDefaultMessage()+";<br/>");//向集合中追加错误语句
			}
			
		
		}
		if(errorMsg.length()>0) {
			return errorMsg.toString();
		}
		
		
      return "成功";
	}
	
}
