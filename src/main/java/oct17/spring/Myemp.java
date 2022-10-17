package oct17.spring;

import org.springframework.data.jpa.repository.JpaRepository;
public interface Myemp extends JpaRepository<Employee, Integer>
{

}
