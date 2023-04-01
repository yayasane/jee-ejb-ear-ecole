package schoolManagementEJB.metier.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({@NamedQuery(name="Registration.getAll",query="SELECT e FROM Registration e")})
public class Registration  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String detail;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Course course;
	@ManyToOne
	private Year year;
	public Registration() {
		super();
	}
	public Registration(String detail, Student student, Course course, Year year) {
		super();
		this.detail = detail;
		this.student = student;
		this.course = course;
		this.year = year;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@NotEmpty
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@NotNull
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@NotNull
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@NotNull
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
}
