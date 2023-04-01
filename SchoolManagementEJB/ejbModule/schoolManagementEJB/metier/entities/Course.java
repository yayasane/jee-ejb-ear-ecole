package schoolManagementEJB.metier.entities;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({@NamedQuery(name="Course.getAll",query="SELECT e FROM Course e")})
public class Course implements Serializable{

	private static final long serialVersionUID = 1L;
	public Course() {
		super();
	}
	public Course(String name, String program) {
		super();
		this.name = name;
		this.program = program;
	}
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String program;
	@OneToMany(mappedBy = "course")
	private List<Registration> registrations;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty
	@Length(min = 3)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotEmpty
	@Length(min = 3)
	public String getProgram() {
		return program;
	}
	public void setProgram(String program) {
		this.program = program;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
