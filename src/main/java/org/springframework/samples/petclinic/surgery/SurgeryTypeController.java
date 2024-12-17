package org.springframework.samples.petclinic.surgery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SurgeryTypeController {

    private final SurgeryTypeService surgeryTypeService;
    private final SurgeryTypeRepository surgeryTypeRepository;

    @Autowired
    public SurgeryTypeController(SurgeryTypeService surgeryTypeService, SurgeryTypeRepository surgeryTypeRepository) {
        this.surgeryTypeService = surgeryTypeService;
        this.surgeryTypeRepository = surgeryTypeRepository;
    }

    @PreAuthorize("hasRole(VET)")
    @GetMapping("api/v1/surgerytypes")
    public ResponseEntity<List<SurgeryType>> getAllSurgeryTypes() {
        List<SurgeryType> surgeryTypes = surgeryTypeService.findSurgeryTypes();
        return new ResponseEntity<>(surgeryTypes, HttpStatus.OK);
    }

    @PreAuthorize("hasRole(VET)")
    @GetMapping("/api/v1/surgerytypes/{id}")
    public ResponseEntity<SurgeryType> getSurgeryTypeById(@PathVariable Integer id) {
        return surgeryTypeRepository.findById(id)
                .map(surgeryType -> new ResponseEntity<>(surgeryType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
}
