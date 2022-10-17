package oct17.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
	@Autowired
Myemp emp;
	public List <Employee>displatdata()
	{
		return emp.findAll();
		
	}
	public void saveEmployee(Employee employee)
    {
		emp.save(employee);
	}
	public Employee getEmployee(int id) 
	{
		
		return emp.findById(id).get();
	}
	public void delete(int id)
    {
		emp.deleteById(id);
	}
}
