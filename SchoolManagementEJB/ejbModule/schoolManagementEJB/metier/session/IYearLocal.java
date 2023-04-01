package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Local;

import schoolManagementEJB.metier.entities.Year;

@Local
public interface IYearLocal {
	Year add(Year registration);

	Year update(Year registration);

	Year findById(Integer id);

    List<Year> findAll();

    void deleteInteger(Integer id);
}
