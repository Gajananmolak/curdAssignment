package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class MyController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping("getAll")
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll();
	}
	
	
	@RequestMapping("insert")
	public Student addStudent(@RequestBody Student student)
	{
		return studentRepository.save(student);
	}
	
	
	@RequestMapping("update{id}")
	public String updateStudent(@PathVariable int id, @RequestBody Student student)
	{
		try 
		{
		
		    Student student1= studentRepository.findById(id).get();
		
		    student1.setFirstName(student.getFirstName());
		    student1.setLastName(student.getLastName());
		    student1.setCity(student.getCity());
		    student1.setAge(student.getAge());
		
		     studentRepository.save(student1);
		      return "Successfully update";
		
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return "Not update";
		}
		
	}
	
	@RequestMapping("delete{id}")
	public String delete(@PathVariable int id)
	{
		try 
		{
			studentRepository.deleteById(id);
			return "Successfully Deleted";
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Not Deleted";
			
		}
		
	}

}
