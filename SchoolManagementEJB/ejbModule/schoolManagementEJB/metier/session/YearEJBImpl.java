package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import schoolManagementEJB.metier.entities.Course;
import schoolManagementEJB.metier.entities.Year;

@Stateless
public class YearEJBImpl implements IYearLocal{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Year add(Year registration) {
		// TODO Auto-generated method stub
		em.persist(registration);
		return registration;
	}

	@Override
	public Year findById(Integer id) {
		// TODO Auto-generated method stub
		return em.find(Year.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Year> findAll() {
		return em.createNamedQuery("Year.getAll").getResultList();
	}

	@Override
	public void deleteInteger(Integer id) {
		em.remove(findById(id));
		
	}

	@Override
	public Year update(Year registration) {
		em.merge(registration);
		return registration;
	}

}
