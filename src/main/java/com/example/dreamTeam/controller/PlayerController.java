package com.example.dreamTeam.controller;

import com.example.dreamTeam.model.PlayerModel;
import com.example.dreamTeam.model.Position;
import com.example.dreamTeam.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping
    public String getAllPlayers(Model model) {
        List<PlayerModel> players = playerService.getPlayers();
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
        playerService.save(player);
        return "redirect:";
    }

}
