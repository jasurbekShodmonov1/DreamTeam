package com.example.dreamTeam.controller;



import com.example.dreamTeam.model.RoleModel;
import com.example.dreamTeam.service.RoleService;
import com.example.dreamTeam.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public String listRoles(Model model){

        List<RoleModel> roleEntity = roleService.getRoles();
        model.addAttribute("roles",roleEntity);
        return "roles/role_list";

    }

    @GetMapping("/create")
    public String showRole(Model model){
        model.addAttribute("roles", new RoleModel());
        return "roles/role_form";
    }
    @PostMapping("/create")
    public String createRoles(@RequestParam String name){
        roleService.createRole(name);
        return "redirect:/roles";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoles(@PathVariable Long id){
        roleService.delete(id);
        return "redirect:/roles";
    }
}
