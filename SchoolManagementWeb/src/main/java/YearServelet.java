

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

import schoolManagementEJB.metier.entities.Year;
import schoolManagementEJB.metier.session.IYearLocal;

@WebServlet(urlPatterns = { "/years", "/years/new", "/years/insert", "/years/delete", "/years/edit",
		"/years/update"

})
public class YearServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private IYearLocal metier;
	
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
			case "/years/new":
				showNewForm(request, response);
				break;
			case "/years/insert":
				insertYear(request, response);
				break;
			case "/years/delete":
				deleteYear(request, response);
				break;
			case "/years/edit":
				showEditForm(request, response);
				break;
			case "/years/update":
				updateYear(request, response);
				break;
			default:
				listYear(request, response);
				break;
			}
		} catch (SQLException ex) {
			response.getWriter().print(action);
//            throw new ServletException(ex);
		}
	}

	

	private void listYear(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Year> listYear = metier.findAll();
		request.setAttribute("listYear", listYear);
		System.out.println("In here walanokk");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/year/year-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/year/year-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Year existingYear = metier.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/year/year-form.jsp");
		request.setAttribute("year", existingYear);
//		response.getWriter().print(id);
		System.out.println("The year " + existingYear + id);
		dispatcher.forward(request, response);

	}

	private void insertYear(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
		String name = request.getParameter("name");

		Year newYear = new Year(name);
		
		
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<Year>> constraintViolations = validator.validate(newYear);
		if (!constraintViolations.isEmpty()) {
			String errors = "<ul>";
			for (ConstraintViolation<Year> constraintViolation : constraintViolations) {
				errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
						+ "</li>";
			}
			errors += "</ul>";
			request.setAttribute("account", newYear);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/WEB-INF/view/year/year-form.jsp").forward(request, response);
		} else {
			System.out.println("opic");
			Year m = metier.add(newYear);
			//request.setAttribute("account", newYear);
			response.sendRedirect(request.getContextPath() + "/years");
			//request.getRequestDispatcher("account/success.jsp").forward(request, response);
		}
	} catch (Exception e) {
		request.setAttribute("errors", e.getMessage());
		request.getRequestDispatcher("/WEB-INF/view/year/year-form.jsp").forward(request, response);
	}

		
//		response.getWriter().print(m);
		//response.sendRedirect("/years");
	}

	private void updateYear(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		Year year = new Year(name);
		year.setId(id);
		metier.update(year);
		response.sendRedirect(request.getContextPath() +"/years");
	}

	private void deleteYear(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		System.out.println(request.getParameter("id"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		metier.deleteInteger(id);
		response.sendRedirect(request.getContextPath() +"/years");

	}
}
