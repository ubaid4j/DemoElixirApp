package com.ubaid.elixir.elixirApp.controller;

import com.ubaid.elixir.elixirApp.common.TableHeader;
import com.ubaid.elixir.elixirApp.services.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/***
 * <p>
 *     Home controller which basically have two end points
 *     1. The first one is for GET (/) which get the file from the class path (in resource folder ) and return the index page along with csv data
 *     2. The second is for POST /upload which accept multipart file and return the index page along with the csv data
 * </p>
 *
 * @author Ubaid ur Rehman
 */
@Controller
@RequestMapping(value = "/")
@CrossOrigin("*")
public class HomeController {

    private final static Resource resource = new ClassPathResource("Task-Java.csv");
    private final static List<TableHeader> tableHeaders = new ArrayList<>(EnumSet.allOf(TableHeader.class));
    private final static String MESSAGE = "message";
    private final static String STATUS = "status";
    private final static String INDEX = "index";
    private final static String UPLOAD = "upload";
    private final static String PREFIX = "temp";
    private final static String SUFFIX = ".csv";
    private final static String TABLE_HEADER = "tableHeaders";
    private final static String CONTRACTS = "contracts";
    private final static String FILTERS = "filters";
    private final static String FILE = "file";
    private final static String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error";
    private final static String CSV_UPLOAD_MESSAGE = "Please select a CSV file to upload.";

    /**
     * services
     */
    private final CSVService service;

    public HomeController(@Autowired CSVService service) {
        this.service = service;
    }

    /**
     * <p>
     * It get the file from resource folder
     * then getting csv and filters and adding it to model
     * </p>
     *
     * @param model ui model
     * @return index page (attached with model)
     */
    @GetMapping(value = "/")
    public String index(Model model) {
        try {
            setModelAndReturnIndex(model, createTempFile(resource.getInputStream()));
            return INDEX;
        } catch (IOException exp) {
            exp.printStackTrace();
            model.addAttribute(MESSAGE, INTERNAL_SERVER_ERROR_MESSAGE);
            model.addAttribute(STATUS, false);
            return INDEX;
        }
    }

    /**
     * <p>
     * this method is responsible for uploading csv file, save it to temp file and
     * then setting csv and filters to the model
     * </p>
     *
     * @param file  multipart file (csv file)
     * @param model ui model
     * @return index page
     */
    @PostMapping(value = UPLOAD)
    public String uploadFile(@RequestParam(FILE) MultipartFile file, Model model) {
        if (file.isEmpty()) {
            model.addAttribute(MESSAGE, CSV_UPLOAD_MESSAGE);
            model.addAttribute(STATUS, false);
            return INDEX;
        } else {
            try {
                return setModelAndReturnIndex(model, createTempFile(file.getInputStream()));
            } catch (IOException exp) {
                exp.printStackTrace();
                model.addAttribute(MESSAGE, INTERNAL_SERVER_ERROR_MESSAGE);
                model.addAttribute(STATUS, false);
                return INDEX;
            }
        }
    }

    /**
     * <p>
     * this method attach the csv data and filters to the model
     * </p>
     *
     * @param model model view
     * @param file  csv file
     * @return index page
     */
    private String setModelAndReturnIndex(Model model, File file) {
        model.addAttribute(TABLE_HEADER, tableHeaders);
        model.addAttribute(CONTRACTS, service.getContracts(file));
        model.addAttribute(FILTERS, service.getFilters(file));
        return INDEX;
    }

    /**
     * <p>
     * Simply creates a temporary file consisting of given input stream
     * </p>
     *
     * @param inputStream input stream
     * @return file which contain the input stream
     * @throws IOException an io exception
     */
    private File createTempFile(InputStream inputStream) throws IOException {
        File tempFile = File.createTempFile(PREFIX, SUFFIX);
        Files.copy(inputStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return tempFile;
    }
}
