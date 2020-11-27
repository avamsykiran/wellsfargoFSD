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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.batch7.sbwdd.exception.AddressBookException;
import com.wellsfargo.batch7.sbwdd.model.ContactModel;
import com.wellsfargo.batch7.sbwdd.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactApi {
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping
	public ResponseEntity<List<ContactModel>> contactsAction() throws AddressBookException{
		return new ResponseEntity<>(contactService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{cid}")
	public ResponseEntity<ContactModel> contactAction(@PathVariable("cid")long contactId) throws AddressBookException{
		return new ResponseEntity<>(contactService.get(contactId),HttpStatus.OK);
	}
	
	@DeleteMapping("/{cid}")
	public ResponseEntity<Void> deleteAction(@PathVariable("cid")long contactId) throws AddressBookException{
		contactService.delete(contactId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ContactModel> addAction(
			@RequestBody @Valid ContactModel contact,BindingResult result) 
			throws AddressBookException{
		
		if(result.hasErrors()) {
			throw new AddressBookException(ExceptionController.from(result));
		}
		
		return new ResponseEntity<>(contactService.add(contact), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ContactModel> updateAction(
			@RequestBody @Valid ContactModel contact,BindingResult result) 
			throws AddressBookException{
		
		if(result.hasErrors()) {
			throw new AddressBookException(ExceptionController.from(result));
		}
		
		return new ResponseEntity<>(contactService.update(contact), HttpStatus.OK);
	}
}
