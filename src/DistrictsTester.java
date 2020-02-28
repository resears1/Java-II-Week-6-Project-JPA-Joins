import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.District;
import model.ListDetails;
import model.ListPet;

public class DistrictsTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		District wdm = new District("West Des Moines");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListPet owner1 = new ListPet("Chihuahua", "Roxy", "James Sutherland");
		ListPet owner2 = new ListPet("Dachshund", "Robert", "Jimothy Jones");
		
		List<ListPet> wdmPets = new ArrayList<ListPet>();
		wdmPets.add(owner1);
		wdmPets.add(owner2);
		
		ListDetails wdmList = new ListDetails("West Des Moines List", LocalDate.now(), wdm);
		wdmList.setListOfPets(wdmPets);
		
		ldh.insertNewListDetails(wdmList);
		
		List<ListDetails> allLists = ldh.showAllDistricts();
		for(ListDetails a :allLists) {
			System.out.println(a.toString());
		}
	}

}
