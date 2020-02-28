package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.District;
import model.ListDetails;
import model.ListPet;

/**
 * Servlet implementation class CreateNewListServlet
 */
@WebServlet("/createNewListServlet")
public class CreateNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListPetHelper lih = new ListPetHelper();
		String listName = request.getParameter("listName");
		System.out.println("List Name: " + listName);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String districtName = request.getParameter("districtName");
		
		LocalDate ld;
		
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		String[] selectedPets = request.getParameterValues("allPetsToAdd");
		List<ListPet> selectedPetsInList = new ArrayList<ListPet>();
		
		if (selectedPets != null && selectedPets.length > 0) {
			for (int i = 0; i < selectedPets.length; i++) {
				System.out.println(selectedPets[i]);
				ListPet c = lih.searchForPetById((Integer.parseInt(selectedPets[i])));
				selectedPetsInList.add(c);
			}
		}
		
		District district = new District(districtName);
		ListDetails sld = new ListDetails(listName, ld, district);
		sld.setListOfPets(selectedPetsInList);
		ListDetailsHelper slh = new ListDetailsHelper();
		
		slh.insertNewListDetails(sld);
		
		System.out.println("Success!");
		System.out.println(sld.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
