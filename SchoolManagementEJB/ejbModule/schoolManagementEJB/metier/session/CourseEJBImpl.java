package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import schoolManagementEJB.metier.entities.Course;

@Stateless
public class CourseEJBImpl implements ICourseLocal{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Course add(Course registration) {
		// TODO Auto-generated method stub
		em.persist(registration);
		return registration;
	}

	@Override
	public Course findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Course.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findAll() {
		return em.createNamedQuery("Course.getAll").getResultList();
	}

	@Override
	public void deleteInteger(Long id) {
		em.remove(findById(id));
		
	}

	@Override
	public Course update(Course registration) {
		em.merge(registration);
		return registration;
	}

}
