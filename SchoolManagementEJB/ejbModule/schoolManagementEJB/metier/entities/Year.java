package schoolManagementEJB.metier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@NamedQueries({@NamedQuery(name="Year.getAll",query="SELECT e FROM Year e")})
public class Year implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToMany(mappedBy = "year")
	private List<Registration> registrations;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@NotEmpty
	@Pattern(regexp = "^(?=.*?(19[56789]|20\\d{2}).*)\\d{4}$", message = "La Date n'est valide (1950 to 2099)")
	@Length(min = 4, max = 4)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Year() {
		super();
	}
	public Year(String name) {
		super();
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
