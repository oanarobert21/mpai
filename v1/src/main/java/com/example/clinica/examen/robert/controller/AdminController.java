package com.example.clinica.examen.robert.controller;

import com.example.clinica.examen.robert.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping({"/appointments"})
    public String seeAppointments(Model model) {
        model.addAttribute("appointments", this.appointmentService.getAllAppointments());
        return "admin/appointments";
    }
}