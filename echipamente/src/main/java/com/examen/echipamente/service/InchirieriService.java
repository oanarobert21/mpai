package com.examen.echipamente.service;

import com.examen.echipamente.dto.InchirieriResponse;
import com.examen.echipamente.mapper.InchirieriMapper;
import com.examen.echipamente.model.Inchirieri;
import com.examen.echipamente.model.InchirieriStatus;
import com.examen.echipamente.repository.EchipamentRepository;
import com.examen.echipamente.repository.InchirieriRepository;
import com.examen.echipamente.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InchirieriService {
    private final InchirieriRepository inchirieriRepository;
    private final EchipamentRepository echipamentRepository;
    private final UserRepository userRepository;

    @Autowired
    public InchirieriService(InchirieriRepository inchirieriRepository,EchipamentRepository echipamentRepository,  UserRepository userRepository) {
        this.inchirieriRepository = inchirieriRepository;
        this.echipamentRepository = echipamentRepository;
        this.userRepository = userRepository;
    }

    public List<InchirieriResponse> getAllResponses() {
        return this.inchirieriRepository.findAll().stream().map(InchirieriMapper::InchirieriToDTO).collect(Collectors.toList());
    }

    public void changeStatus(Long id, InchirieriStatus newStatus) {
        Inchirieri inchiriere = this.inchirieriRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inchirierea nu a fost gasita"));
        inchiriere.setInchirieriStatus(newStatus);
        this.inchirieriRepository.save(inchiriere);
    }
}
