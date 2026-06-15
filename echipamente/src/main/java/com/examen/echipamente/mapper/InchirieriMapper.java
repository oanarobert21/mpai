package com.examen.echipamente.mapper;

import com.examen.echipamente.dto.InchirieriResponse;
import com.examen.echipamente.model.Inchirieri;

public class InchirieriMapper {
    public static InchirieriResponse InchirieriToDTO(Inchirieri inchirieri) {
        return new InchirieriResponse(inchirieri.getId(), inchirieri.getStartDate(), inchirieri.getEndDate(), inchirieri.getInchirieriStatus().toString(), inchirieri.getUser().getFirstName(), inchirieri.getUser().getLastName(), inchirieri.getEchipament().getName(), inchirieri.getEchipament().getDescriere());
    }
}
