package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import schoolManagementEJB.metier.entities.Registration;

@Stateless
public class RegistrationEJBImpl implements IRegistrationLocal{
	@PersistenceContext
	private EntityManager em;

	@Override
	public Registration add(Registration registration) {
		// TODO Auto-generated method stub
		em.persist(registration);
		return registration;
	}

	@Override
	public Registration findById(Long id) {
		// TODO Auto-generated method stub
		return em.find(Registration.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registration> findAll() {
		return em.createNamedQuery("Registration.getAll").getResultList();
	}

	@Override
	public void deleteInteger(Long id) {
		em.remove(findById(id));
		
	}

	@Override
	public Registration update(Registration registration) {
		em.merge(registration);
		return registration;
	}

}
