package com.example.demo2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class ContactController {
    private final List<Contact> contactList = new ArrayList<>();

    @PostMapping("/addContact")
    public String addContact(@RequestBody Contact contact){
        for(Contact existingContact : contactList) {
            if (existingContact.getEmail().equals(contact.getEmail())) {
                return "Contact already exists";
            }
        }
        contactList.add(contact);
        return "Contact added successfully";
    }
    @GetMapping("/getContactDetails")
    public Object getContactDetails(@RequestParam String name){
for(Contact contact1 : contactList){
    if(contact1.getName().equalsIgnoreCase(name)){
        return contact1;
    }
}
return "contact not found";
    }
}



