package oct17.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 
{
	@Autowired
	EmployeeService service;
	@RequestMapping("/")
	public String show( Model model)
	{
		System.out.println("displaydata");
		List<Employee> list=service.displatdata();
		for(Employee e:list)
		{
			System.out.println(e.getId()+" "+ e.getName());
			
		}
		model.addAttribute("abc",list);
		return "index";
	}
	@RequestMapping("/addData")
	public String newData(Model model)
	{
		Employee employee=new Employee();
		model.addAttribute("Employee",employee);
		return "add_pro";
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveAfter(@ModelAttribute("employee") Employee employee)
	{
		service.saveEmployee(employee);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editData(@PathVariable(name="id") int id)
	{
		ModelAndView modelAndView=new ModelAndView();
		Employee employee=service.getEmployee(id);
		modelAndView.addObject("Employee",employee);
		return modelAndView;
	}
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable(name="id") int id)
	{
		service.delete(id);
		return "redirect:/";	
	}
}
