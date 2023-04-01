package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Local;

import schoolManagementEJB.metier.entities.Registration;

@Local
public interface IRegistrationLocal {
	Registration add(Registration registration);

	Registration update(Registration registration);

	Registration findById(Long id);

    List<Registration> findAll();

    void deleteInteger(Long id);
}
