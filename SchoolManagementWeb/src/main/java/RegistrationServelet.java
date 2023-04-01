

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

import schoolManagementEJB.metier.entities.Course;
import schoolManagementEJB.metier.entities.Registration;
import schoolManagementEJB.metier.entities.Student;
import schoolManagementEJB.metier.entities.Year;
import schoolManagementEJB.metier.session.ICourseLocal;
import schoolManagementEJB.metier.session.IRegistrationLocal;
import schoolManagementEJB.metier.session.IStudentLocal;
import schoolManagementEJB.metier.session.IYearLocal;

@WebServlet(urlPatterns = { "/registrations", "/registrations/new", "/registrations/insert", "/registrations/delete", "/registrations/edit",
		"/registrations/update"

})
public class RegistrationServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IRegistrationLocal metier;
	@EJB
	private IStudentLocal studentBusness;
	@EJB
	private IYearLocal yearBusness;
	@EJB
	private ICourseLocal courseBusness;
	
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
			case "/registrations/new":
				showNewForm(request, response);
				break;
			case "/registrations/insert":
				insertRegistration(request, response);
				break;
			case "/registrations/delete":
				deleteRegistration(request, response);
				break;
			case "/registrations/edit":
				showEditForm(request, response);
				break;
			case "/registrations/update":
				updateRegistration(request, response);
				break;
			default:
				listRegistration(request, response);
				break;
			}
		} catch (SQLException ex) {
			response.getWriter().print(action);
//            throw new ServletException(ex);
		}
	}

	

	private void listRegistration(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Registration> listRegistration = metier.findAll();
		request.setAttribute("listRegistration", listRegistration);
		System.out.println("In here walanokk");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/registration/registration-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Student> students = studentBusness.findAll();
		List<Course> courses = courseBusness.findAll();
		List<Year> years = yearBusness.findAll();
		
		request.setAttribute("students", students);
		request.setAttribute("years", years);
		request.setAttribute("courses", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/registration/registration-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Registration existingRegistration = metier.findById(id);
		List<Student> students = studentBusness.findAll();
		List<Course> courses = courseBusness.findAll();
		List<Year> years = yearBusness.findAll();
		request.setAttribute("students", students);
		request.setAttribute("years", years);
		request.setAttribute("courses", courses);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/registration/registration-form.jsp");
		request.setAttribute("registration", existingRegistration);
//		response.getWriter().print(id);
		dispatcher.forward(request, response);

	}

	private void insertRegistration(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			String detail = request.getParameter("detail");
			Long studentId = Long.parseLong(request.getParameter("student"));
			Long courseId = Long.parseLong(request.getParameter("course"));
			int yearId = Integer.parseInt(request.getParameter("year"));
			Student student = studentBusness.findById(studentId);
			Course course = courseBusness.findById(courseId);
			Year year = yearBusness.findById(yearId);
			
			Registration newRegistration = new Registration(detail, student, course, year);
			System.out.println("After i stanciation");
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Registration>> constraintViolations = validator.validate(newRegistration);
		if (!constraintViolations.isEmpty()) {
			String errors = "<ul>";
			for (ConstraintViolation<Registration> constraintViolation : constraintViolations) {
				errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
						+ "</li>";
			}
			errors += "</ul>";
			request.setAttribute("registration", newRegistration);
			request.setAttribute("errors", errors);
			List<Student> students = studentBusness.findAll();
			List<Course> courses = courseBusness.findAll();
			List<Year> years = yearBusness.findAll();
			request.setAttribute("students", students);
			request.setAttribute("years", years);
			request.setAttribute("courses", courses);
			System.out.println("Before dispatcher 1");
			System.out.println(errors);
			request.getRequestDispatcher("/WEB-INF/view/registration/registration-form.jsp").forward(request, response);
		} else {
			System.out.println("opic");
			Registration m = metier.add(newRegistration);
			//request.setAttribute("registration", newRegistration);
			response.sendRedirect(request.getContextPath() +"/registrations");
			//request.getRequestDispatcher("registration/success.jsp").forward(request, response);
		}
	} catch (Exception e) {
		List<Student> students = studentBusness.findAll();
		List<Course> courses = courseBusness.findAll();
		List<Year> years = yearBusness.findAll();
		request.setAttribute("students", students);
		request.setAttribute("years", years);
		request.setAttribute("courses", courses);
		request.setAttribute("errors", e.getMessage());
		System.out.println("Before dispatcher 2");
		System.out.println(e);
		request.getRequestDispatcher("/WEB-INF/view/registration/registration-form.jsp").forward(request, response);
	}

		
//		response.getWriter().print(m);
		//response.sendRedirect("/registrations");
	}

	private void updateRegistration(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			String detail = request.getParameter("detail");
			Long studentId = Long.parseLong(request.getParameter("student"));
			Long courseId = Long.parseLong(request.getParameter("course"));
			int yearId = Integer.parseInt(request.getParameter("year"));
			Student student = studentBusness.findById(studentId);
			Course course = courseBusness.findById(courseId);
			Year year = yearBusness.findById(yearId);
			Registration registration = new Registration(detail, student, course, year);
			registration.setId(id);
			
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			Validator validator = validatorFactory.getValidator();
			Set<ConstraintViolation<Registration>> constraintViolations = validator.validate(registration);
			if (!constraintViolations.isEmpty()) {
				String errors = "<ul>";
				for (ConstraintViolation<Registration> constraintViolation : constraintViolations) {
					errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
							+ "</li>";
				}
				errors += "</ul>";
				request.setAttribute("registration", registration);
				request.setAttribute("errors", errors);
				request.getRequestDispatcher("/WEB-INF/view/registration/registration-form.jsp").forward(request, response);
			} else {
				System.out.println("opic");
				metier.update(registration);
				response.sendRedirect(request.getContextPath() +"/registrations");
			}
		} catch (Exception e) {
			request.setAttribute("errors", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/view/registration/registration-form.jsp").forward(request, response);
		}
		

		
		
	}

	private void deleteRegistration(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		System.out.println(request.getParameter("id"));
		Long id = Long.parseLong(request.getParameter("id"));
		metier.deleteInteger(id);
		response.sendRedirect(request.getContextPath() + "/registrations");

	}
}
