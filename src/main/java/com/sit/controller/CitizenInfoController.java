package com.sit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sit.entity.CitizenDetaillsEntity;
import com.sit.model.CitizenDetailsInfo;
import com.sit.service.CitizenInfoMangService;

@Controller
public class CitizenInfoController {
	

	@Autowired
	private CitizenInfoMangService citizenService;

	@GetMapping(value = "/")
	public String showForm(Model model) {
		CitizenDetailsInfo cInfo = new CitizenDetailsInfo();
		model.addAttribute("cInfo", cInfo);
		List<String> statesList = citizenService.getCitiesList();
		model.addAttribute("states", statesList);
		return "citizen_info";
	}

	@PostMapping(value = "/submitBtn")
	public String handleSubmitBtn(@ModelAttribute("cInfo") CitizenDetailsInfo cInfo,RedirectAttributes attr) {
		CitizenDetaillsEntity cDetailsEntity = citizenService.saveCitizenInfo(cInfo);
		if (cDetailsEntity.getCid() > 0) {
			attr.addFlashAttribute("success", "SSN Enrollment Is Successful !!! Your SSN No is : " + cDetailsEntity.getSsn());
		} else {
			attr.addFlashAttribute("failure", "Enrollment Failed..Please Try Again !!!");
		}
		return "redirect:saveSuccess";
	}
	
	@GetMapping(value = "saveSuccess")
	public String citizenDetailsSaveSucess(Model model,CitizenDetailsInfo cinfo) {
		CitizenDetailsInfo cInfo = new CitizenDetailsInfo();
		model.addAttribute("cInfo",cinfo);
		List<String> statesList = citizenService.getCitiesList();
		model.addAttribute("states", statesList);
		return "citizen_info";
	}

	

	
}
