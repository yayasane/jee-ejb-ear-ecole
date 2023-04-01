

import java.io.IOException;
import java.sql.SQLException;
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
import schoolManagementEJB.metier.session.ICourseLocal;

@WebServlet(urlPatterns = { "/courses", "/courses/new", "/courses/insert", "/courses/delete", "/courses/edit",
		"/courses/update"

})
public class CourseServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ICourseLocal metier;
	
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
			case "/courses/new":
				showNewForm(request, response);
				break;
			case "/courses/insert":
				insertCourse(request, response);
				break;
			case "/courses/delete":
				deleteCourse(request, response);
				break;
			case "/courses/edit":
				showEditForm(request, response);
				break;
			case "/courses/update":
				updateCourse(request, response);
				break;
			default:
				listCourse(request, response);
				break;
			}
		} catch (SQLException ex) {
			response.getWriter().print(action);
//            throw new ServletException(ex);
		}
	}

	

	private void listCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Course> listCourse = metier.findAll();
		request.setAttribute("listCourse", listCourse);
		System.out.println("In here walanokk");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/course/course-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/course/course-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		Course existingCourse = metier.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/course/course-form.jsp");
		request.setAttribute("course", existingCourse);
//		response.getWriter().print(id);
		dispatcher.forward(request, response);

	}

	private void insertCourse(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
		String name = request.getParameter("name");
		String program = request.getParameter("program");

		Course newCourse = new Course(name, program);
		
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Course>> constraintViolations = validator.validate(newCourse);
		if (!constraintViolations.isEmpty()) {
			String errors = "<ul>";
			for (ConstraintViolation<Course> constraintViolation : constraintViolations) {
				errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
						+ "</li>";
			}
			errors += "</ul>";
			request.setAttribute("account", newCourse);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/view/course/course-form.jsp").forward(request, response);
		} else {
			System.out.println("opic");
			Course m = metier.add(newCourse);
			//request.setAttribute("account", newCourse);
			response.sendRedirect(request.getContextPath() +"/courses");
			//request.getRequestDispatcher("account/success.jsp").forward(request, response);
		}
	} catch (Exception e) {
		request.setAttribute("errors", e.getMessage());
		request.getRequestDispatcher("/WEB-INF/view/course/course-form.jsp").forward(request, response);
	}

		
//		response.getWriter().print(m);
		//response.sendRedirect("/courses");
	}

	private void updateCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String program = request.getParameter("program");

		Course course = new Course(name, program);
		course.setId(id);
		metier.update(course);
		response.sendRedirect(request.getContextPath() +"/courses");
	}

	private void deleteCourse(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		System.out.println(request.getParameter("id"));
		Long id = Long.parseLong(request.getParameter("id"));
		metier.deleteInteger(id);
		response.sendRedirect(request.getContextPath() + "/courses");

	}
}
