package com.ubaid.elixir.elixirApp.cvsUtil;

import com.ubaid.elixir.elixirApp.entity.Contract;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CSVReaderTest {

    @Test
    void getContracts() {
        Resource resource = new ClassPathResource("Task-Java.csv");
        assertNotNull(resource);
        try {
            File file = resource.getFile();
            List<Contract> contracts = CSVReader.getContracts(file);
            assertNotNull(contracts);
            // TODO: 4/26/20 plan field splits using spaces  
        } catch(IOException exp) {
            exp.printStackTrace();
        }


    }
}