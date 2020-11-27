package com.wellsfargo.batch7.sbwdd.restapi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.AddressGroupModel;
import com.wellsfargo.batch7.sbwdd.model.ContactModel;
import com.wellsfargo.batch7.sbwdd.service.AddressGroupService;
import com.wellsfargo.batch7.sbwdd.service.ContactService;

@RestController
@RequestMapping("/groups")
public class AddressGroupApi {

	@Autowired
	private AddressGroupService agService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public ResponseEntity<List<AddressGroupModel>> groupsAction() throws AddressBookException{
		return new ResponseEntity<>(agService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{gid}")
	public ResponseEntity<AddressGroupModel> groupAction(@PathVariable("gid")int groupId) throws AddressBookException{
		return new ResponseEntity<>(agService.get(groupId),HttpStatus.OK);
	}
	
	@GetMapping("/{gid}/contacts")
	public ResponseEntity<List<ContactModel>> contactsByGroupAction(@PathVariable("gid")int groupId) throws AddressBookException{
		return new ResponseEntity<>(
				contactService.getAllByGroup(agService.get(groupId)),HttpStatus.OK);
	}
	
	@DeleteMapping("/{gid}")
	public ResponseEntity<Void> deleteAction(@PathVariable("gid")int groupId) throws AddressBookException{
		agService.delete(groupId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AddressGroupModel> addAction(
			@RequestBody @Valid AddressGroupModel group,BindingResult result) 
			throws AddressBookException{
		
		if(result.hasErrors()) {
			throw new AddressBookException(ExceptionController.from(result));
		}
		
		return new ResponseEntity<AddressGroupModel>(agService.add(group), HttpStatus.OK);
	}
}
