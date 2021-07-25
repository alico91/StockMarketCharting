package com.smca.Company.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smca.Company.Config.ImportConfig;
import com.smca.Company.Message.ResponseMessage;
import com.smca.Company.Models.StockPrice;

@RestController
@CrossOrigin(origins= "http://localhost:4200")
@RequestMapping("/import-excel")
public class ImportController {
//	
//	@Autowired
//    private ImportController importService;
//
//    @PostMapping(path="")
//    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam MultipartFile file) throws IOException {
//    	String message = "";
//
//        if (ImportConfig.hasExcelFormat(file)) {
//            try {
//                importService.uploadFile(file);
//
//                message = "Uploaded the file successfully: " + file.getOriginalFilename();
//                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//            } catch (Exception e) {
//                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//            }
//        }
//
//        message = "Please upload an excel file!";
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
//    }
}
