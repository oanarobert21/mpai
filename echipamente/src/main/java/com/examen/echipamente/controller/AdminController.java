package com.examen.echipamente.controller;

import com.examen.echipamente.model.InchirieriStatus;
import com.examen.echipamente.service.InchirieriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminController {
    @Autowired
    private InchirieriService inchirieriService;

    @GetMapping({"/inchirieri"})
    public String seeInchirieri(Model model) {
        model.addAttribute("inchirieri", this.inchirieriService.getAllResponses());
        return "admin/inchirieri";
    }

    @PostMapping("/inchirieri/{id}/aproba")
    public String aprobaInchiriere(@PathVariable Long id) {
        this.inchirieriService.changeStatus(id, InchirieriStatus.APROBATA);
        return "redirect:/admin/inchirieri";
    }

    @PostMapping("/inchirieri/{id}/respinge")
    public String respingeInchiriere(@PathVariable Long id) {
        this.inchirieriService.changeStatus(id, InchirieriStatus.RESPINSA);
        return "redirect:/admin/inchirieri";
    }

    @PostMapping("/inchirieri/{id}/preia")
    public String preiaInchiriere(@PathVariable Long id) {
        this.inchirieriService.changeStatus(id, InchirieriStatus.PRELUATA);
        return "redirect:/admin/inchirieri";
    }

    @PostMapping("/inchirieri/{id}/returneaza")
    public String returneazaInchiriere(@PathVariable Long id) {
        this.inchirieriService.changeStatus(id, InchirieriStatus.RETURNATA);
        return "redirect:/admin/inchirieri";
    }
}
