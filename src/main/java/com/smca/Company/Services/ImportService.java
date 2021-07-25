package com.smca.Company.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smca.Company.Config.ImportConfig;
import com.smca.Company.Models.StockPrice;

import com.smca.Company.Repository.StockPriceRepository;

@Service
public class ImportService {
	
//	@Autowired
//    private StockPriceRepository stockRepository;
//
//
//    public void uploadFile( MultipartFile file){
//
//    	try {
//
//            List<StockPrice> stockPriceList = ImportConfig.excelToStockPrice(file.getInputStream());
//            stockRepository.saveAll(stockPriceList);
//
//
//        } catch (IOException e) {
//            throw new RuntimeException("fail to store excel data: " + e.getMessage());
//        }
//    }
}
