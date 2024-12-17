package org.springframework.samples.petclinic.surgery;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

public class OperatingRoomService {
    private OperatingRoomRepository repo;

    public OperatingRoomService(OperatingRoomRepository tr){
        this.repo=tr;
    }

    @Transactional(readOnly = true)
    public List<OperatingRoom> getAll() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public OperatingRoom save(OperatingRoom t) {
        return repo.save(t);
    }
}
