package org.springframework.samples.petclinic.surgery;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.vet.Vet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Surgery extends NamedEntity{
    String description;

    @NotNull
    @Column(name = "surgery_date")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    LocalDate date;
    
    //Test 2
    @ManyToOne
    private Pet pet;

    
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Vet> surgeryTeam;
      
    @NotNull
    @ManyToOne
    OperatingRoom room;
}
