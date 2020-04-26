package com.ubaid.elixir.elixirApp.controller;

import com.ubaid.elixir.elixirApp.common.TableHeader;
import com.ubaid.elixir.elixirApp.services.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    private final static Resource resource = new ClassPathResource("Task-Java.csv");
    private final static List<TableHeader> tableHeaders = new ArrayList<>(EnumSet.allOf(TableHeader.class));

    CSVService service;
    public HomeController(@Autowired CSVService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        try {
            setModel(model, resource.getFile());
            return "index";
        } catch(IOException exp) {
            exp.printStackTrace();
            model.addAttribute("message", "Internal Server Error");
            model.addAttribute("status", false);
            return "index";
        }
    }

    @PostMapping(value = "/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file,  Model model) {
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
            return "index";
        } else {
            try {
                File tempFile = File.createTempFile("temp", ".csv");
                tempFile.deleteOnExit();
                file.transferTo(tempFile);
                setModel(model, tempFile);
                if (tempFile.delete()) {
                    System.out.println("[Just ignore it]: Temp file deleted");
                }
                return "index";
            } catch(IOException exp) {
                exp.printStackTrace();
                model.addAttribute("message", "Internal Server Error");
                model.addAttribute("status", false);
                return "index";
            }
        }
    }

    private void setModel(Model model, File file) {
        model.addAttribute("tableHeaders", tableHeaders);
        model.addAttribute("contracts", service.getContracts(file));
        model.addAttribute("filters", service.getFilters(file));
    }
}
