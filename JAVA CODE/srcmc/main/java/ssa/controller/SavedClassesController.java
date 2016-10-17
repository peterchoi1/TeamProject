package ssa.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ssa.entity.SavedClasses;
import ssa.service.ISavedClassesService;

@CrossOrigin
@Controller
@RequestMapping("/")
public class SavedClassesController {
	
	@Autowired
	private ISavedClassesService SavedClassesService;
	
	@RequestMapping(value= "/savedclasses/{login_id}", method = RequestMethod.GET)
    public ResponseEntity<List<SavedClasses>> getSavedClassesById(@PathVariable("login_id") int login_id) {
        List<SavedClasses> savedClasses = SavedClassesService.getSavedClassesById(login_id);
        return new ResponseEntity<List<SavedClasses>>(savedClasses, HttpStatus.OK);
    }
	
	@RequestMapping(value= "/SavedClasses/delete", method = RequestMethod.DELETE)
    public ResponseEntity<SavedClasses> deleteStudent(SavedClasses SavedClassesData) {
		SavedClasses SavedClasses = SavedClassesService.getSavedClassById(SavedClassesData.getLogin_id(), SavedClassesData.getClass_id());
        SavedClassesService.deleteSavedClasses(SavedClasses);
        return new ResponseEntity<SavedClasses>(HttpStatus.OK);
    }
	
	@RequestMapping(value= "/SavedClasses/insert/", method = RequestMethod.POST)
	public void insertSavedClasses(SavedClasses SavedClassesData)  {
				SavedClasses SavedClasses = new SavedClasses(SavedClassesData.getLogin_id(), SavedClassesData.getClass_id());
	       		SavedClassesService.insertSavedClasses(SavedClasses);
    }
	
}
