package schoolManagementEJB.metier.session;

import java.util.List;

import javax.ejb.Local;

import schoolManagementEJB.metier.entities.Student;

@Local
public interface IStudentLocal {
	Student add(Student registration);

	Student update(Student registration);

	Student findById(Long id);

    List<Student> findAll();

    void deleteInteger(Long id);
}
