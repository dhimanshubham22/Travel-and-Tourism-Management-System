package com.system.toursandtravelmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.toursandtravelmanagement.DTO.BookingsDTO;
import com.system.toursandtravelmanagement.model.BusData;
import com.system.toursandtravelmanagement.model.User;
import com.system.toursandtravelmanagement.repository.BusDataRepository;
import com.system.toursandtravelmanagement.repository.UserRepository;

@Controller
@RequestMapping(value = "/adminScreen")
public class AdminController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	BusDataRepository busDataRepository;
	
	
	@ModelAttribute("busDetails")
    public BusData busData() {
        return new BusData();
    }
	
	@GetMapping
    public String displayDashboard(Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        return "adminScreen";
    }

	private String returnUsername() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
		User users = userRepository.findByEmail(user.getUsername());
		return users.getName();
	}
	
	@PostMapping
    public String saveBusData(@ModelAttribute("busDetails") BusData busData,Model model){
		String user= returnUsername();
        model.addAttribute("userDetails", user);
        busDataRepository.save(busData);
        model.addAttribute("busDetails", new BusData());
        return "redirect:/adminScreen?success";
    }
	
	@GetMapping("/allRecords")
	public String getAllRecords(Model model){
		List<BusData> data = busDataRepository.findAll();
		String user= returnUsername();
        model.addAttribute("userDetails", user);
		model.addAttribute("data", data);
		return "allRecords";
	}
	@GetMapping("/delete/{id}")
	public String getDataAfterDelete(@PathVariable int id,Model model){
		busDataRepository.deleteById(id);
		List<BusData> data = busDataRepository.findAll();
		String user= returnUsername();
        model.addAttribute("userDetails", user);
		model.addAttribute("data", data);
		return "redirect:/adminScreen/allRecords?success";
	}

	@GetMapping("/edit/{id}")
	public String editBusData(@PathVariable int id, Model model) {
	    String user = returnUsername();
	    model.addAttribute("userDetails", user);
	    
	    // Retrieve the BusData object to be edited from the database by its ID
	    BusData busData = busDataRepository.findById(id).orElse(null);
	    
	    if (busData == null) {
	        // Handle the case where the BusData with the given ID is not found
	        return "redirect:/adminScreen/allRecords?error=BusDataNotFound";
	    }
	    
	    // Add the BusData object to the model so it can be displayed in the edit form
	    model.addAttribute("busData", busData);
	    
	    return "editBusData"; // Create an "editBusData" view for editing
	}

	@PostMapping("/update/{id}")
	public String updateBusData(@PathVariable int id, @ModelAttribute("busData") BusData updatedBusData, Model model) {
	    String user = returnUsername();
	    model.addAttribute("userDetails", user);
	    
	    // Retrieve the BusData object to be updated from the database by its ID
	    BusData existingBusData = busDataRepository.findById(id).orElse(null);
	    
	    if (existingBusData == null) {
	        // Handle the case where the BusData with the given ID is not found
	        // You can add appropriate error handling or redirect to an error page
	        return "redirect:/adminScreen/allRecords?error=BusDataNotFound";
	    }
	    
	    // Update the fields of the existing BusData object with the data from the form
	    existingBusData.setBusName(updatedBusData.getBusName()); 
	    existingBusData.setFilterDate(updatedBusData.getFilterDate());
	    existingBusData.setFromDestination(updatedBusData.getFromDestination());
	    existingBusData.setPrice(updatedBusData.getPrice());
	    existingBusData.setTime(updatedBusData.getTime());
	    existingBusData.setToDestination(updatedBusData.getToDestination());
	    
	    // Save the updated BusData object to the database
	    busDataRepository.save(existingBusData);
	    boolean editSuccess = true;
	    model.addAttribute("editSuccess", editSuccess);
	    // Redirect to the page displaying all records with a success message
	    return "redirect:/adminScreen/allRecords?success=BusDataUpdated";
	}

}
