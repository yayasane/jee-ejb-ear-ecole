

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import schoolManagementEJB.metier.entities.Student;
import schoolManagementEJB.metier.session.IStudentLocal;

@WebServlet(urlPatterns = { "/students", "/students/new", "/students/insert", "/students/delete", "/students/edit",
		"/students/update"

})
public class StudentServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IStudentLocal metier;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/students/new":
				showNewForm(request, response);
				break;
			case "/students/insert":
				insertStudent(request, response);
				break;
			case "/students/delete":
				deleteStudent(request, response);
				break;
			case "/students/edit":
				showEditForm(request, response);
				break;
			case "/students/update":
				updateStudent(request, response);
				break;
			default:
				listStudent(request, response);
				break;
			}
		} catch (SQLException ex) {
			response.getWriter().print(action);
//            throw new ServletException(ex);
		}
	}

	

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listStudent = metier.findAll();
		request.setAttribute("listStudent", listStudent);
		System.out.println("In here walanokk");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Student existingStudent = metier.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/student/student-form.jsp");
		request.setAttribute("student", existingStudent);
//		response.getWriter().print(id);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String phone = request.getParameter("phone");
			String birthDate = request.getParameter("birthDate");
			String toLog = firstName + lastName + phone  + birthDate;
			System.out.println(toLog);
			Student newStudent = new Student(firstName, lastName, phone, new SimpleDateFormat("yyyy-MM-dd").parse(birthDate));
			System.out.println("After i stanciation");
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Student>> constraintViolations = validator.validate(newStudent);
		if (!constraintViolations.isEmpty()) {
			String errors = "<ul>";
			for (ConstraintViolation<Student> constraintViolation : constraintViolations) {
				errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
						+ "</li>";
			}
			errors += "</ul>";
			request.setAttribute("student", newStudent);
			request.setAttribute("errors", errors);
			System.out.println("Before dispatcher 1");
			System.out.println(errors);
			request.getRequestDispatcher("/WEB-INF/view/student/student-form.jsp").forward(request, response);
		} else {
			System.out.println("opic");
			Student m = metier.add(newStudent);
			//request.setAttribute("student", newStudent);
			response.sendRedirect(request.getContextPath() +"/students");
			//request.getRequestDispatcher("student/success.jsp").forward(request, response);
		}
	} catch (Exception e) {
		request.setAttribute("errors", e.getMessage());
		System.out.println("Before dispatcher 2");
		System.out.println(e);
		request.getRequestDispatcher("/WEB-INF/view/student/student-form.jsp").forward(request, response);
	}

		
//		response.getWriter().print(m);
		//response.sendRedirect("/students");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String phone = request.getParameter("phone");
			String birthDate = request.getParameter("birthDate");
			@SuppressWarnings("deprecation")
			Student student = new Student(firstName, lastName, phone, new Date(birthDate));
			student.setId(id);
			
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<Student>> constraintViolations = validator.validate(student);
			if (!constraintViolations.isEmpty()) {
				String errors = "<ul>";
				for (ConstraintViolation<Student> constraintViolation : constraintViolations) {
					errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
							+ "</li>";
				}
				errors += "</ul>";
				request.setAttribute("student", student);
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/WEB-INF/view/student/student-form.jsp").forward(request, response);
			} else {
				System.out.println("opic");
				metier.update(student);
				response.sendRedirect(request.getContextPath() +"/students");
			}
		} catch (Exception e) {
			request.setAttribute("errors", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/view/student/student-form.jsp").forward(request, response);
		}
		

		
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		System.out.println(request.getParameter("id"));
		Long id = Long.parseLong(request.getParameter("id"));
		metier.deleteInteger(id);
		response.sendRedirect(request.getContextPath() + "/students");

	}
}
