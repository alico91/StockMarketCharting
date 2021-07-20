package com.smca.Company.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smca.Company.Models.StockPrice;

@RestController
public class ImportController {
	@Autowired
    private ImportController importService;

    @PostMapping
    public List<StockPrice> uploadFile(@RequestParam MultipartFile stockDataFile) throws IOException {
        return importService.uploadFile(stockDataFile);
    }
}
