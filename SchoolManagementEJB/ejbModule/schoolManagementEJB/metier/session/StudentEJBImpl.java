package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import schoolManagementEJB.metier.entities.Course;
import schoolManagementEJB.metier.entities.Student;

@Stateless
public class StudentEJBImpl implements IStudentLocal{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Student add(Student registration) {
		// TODO Auto-generated method stub
		em.persist(registration);
		return registration;
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		return em.createNamedQuery("Student.getAll").getResultList();
	}

	@Override
	public void deleteInteger(Long id) {
		em.remove(findById(id));
		
	}

	@Override
	public Student update(Student registration) {
		em.merge(registration);
		return registration;
	}

}
