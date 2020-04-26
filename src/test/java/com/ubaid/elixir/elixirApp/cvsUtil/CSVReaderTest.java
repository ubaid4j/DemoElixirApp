package com.ubaid.elixir.elixirApp.cvsUtil;

import com.ubaid.elixir.elixirApp.entity.ContractEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
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
            List<ContractEntity> contractEntities = CSVReader.getContracts(file);
            assertNotNull(contractEntities);
            // TODO: 4/26/20 plan field splits using spaces
        } catch(IOException exp) {
            exp.printStackTrace();
        }


    }
}