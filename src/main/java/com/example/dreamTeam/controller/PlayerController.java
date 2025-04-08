package com.example.dreamTeam.controller;

import com.example.dreamTeam.entity.PlayerEntity;
import com.example.dreamTeam.model.PlayerModel;
import com.example.dreamTeam.model.Position;
import com.example.dreamTeam.repository.PlayerRepository;
import com.example.dreamTeam.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    @Autowired
    private final PlayerService playerService;
    private final PlayerRepository playerRepository;

    @GetMapping("/home")
    public String getAllPlayers(Model model) {
        List<PlayerEntity> players = playerService.getAllEntities();
        model.addAttribute("players",players);
        return "players_list";
    }

    @GetMapping("/new")
    public String showPlayerForm(Model model) {

        model.addAttribute("player", new PlayerModel());

        model.addAttribute("positions", Position.values());
        return "player_form";
    }

    @PostMapping("/save")
    public String savePlayer(@ModelAttribute PlayerModel player) {
        try {
            playerService.save(player);
            return "redirect:/home";
        }catch (Exception e){
            System.out.println(e.getMessage());;
        }
        return "";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("player", playerService.getPlayerById(id));
        model.addAttribute("positions", Position.values());
        return "update_form";
    }

    @PostMapping("/update/{id}")
    public String updatePlayer(@ModelAttribute PlayerModel player, @PathVariable Long id){
            playerService.update(id, player);
            return "redirect:/home";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        try {
            playerService.delete(id);
            return "redirect:/home";
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}


