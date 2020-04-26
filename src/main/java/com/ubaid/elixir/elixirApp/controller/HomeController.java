package com.ubaid.elixir.elixirApp.controller;

import com.ubaid.elixir.elixirApp.common.TableHeader;
import com.ubaid.elixir.elixirApp.services.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    private final static Resource resource = new ClassPathResource("Task-Java.csv");
    private final static List<TableHeader> tableHeaders = new ArrayList<>(EnumSet.allOf(TableHeader.class));
    @Autowired
    CSVService service;

    @GetMapping(value = "/")
    public String index(Model model) {
        try {
            model.addAttribute("tableHeaders", tableHeaders);
            model.addAttribute("contracts", service.getContracts(resource.getFile()));
            return "index";
        } catch(IOException exp) {
            model.addAttribute("contracts", null);
            exp.printStackTrace();
            return "index";
        }
    }
}
