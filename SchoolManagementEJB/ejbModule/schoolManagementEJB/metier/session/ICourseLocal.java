package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Local;

import schoolManagementEJB.metier.entities.Course;

@Local
public interface ICourseLocal {
	Course add(Course registration);

	Course update(Course registration);

	Course findById(Long id);

    List<Course> findAll();

    void deleteInteger(Long id);
}
