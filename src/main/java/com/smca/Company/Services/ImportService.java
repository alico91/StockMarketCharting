package com.smca.Company.Services;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smca.Company.Models.Company;
import com.smca.Company.Models.StockExchange;
import com.smca.Company.Models.StockPrice;
import com.smca.Company.Repository.CompanyRepository;
import com.smca.Company.Repository.StockExchangeRepository;
import com.smca.Company.Repository.StockPriceRepository;

@Service
public class ImportService {
	
	@Autowired
    private StockPriceRepository stockRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private StockExchangeRepository stockExchangeRepository;


    public List<StockPrice> uploadFile( MultipartFile StockDataFile) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook(StockDataFile.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        List<StockPrice> stockPrices = new ArrayList<>();
        StockPrice stockprice = new StockPrice();
        for(int i=1;i<worksheet.getPhysicalNumberOfRows();i++){
            XSSFRow row=worksheet.getRow(i);

            Optional<Company> companyOptional=companyRepository.findById((Long)Math.round(row.getCell(0).getNumericCellValue()));
            if(companyOptional.isPresent())
            	stockprice.setCompany(companyOptional.get());
            else{
                return new ArrayList<>();
            }
            Optional<StockExchange>stockExchangeOptional=stockExchangeRepository.findById((Long)Math.round(row.getCell(1).getNumericCellValue()));
            if(stockExchangeOptional.isPresent())
            	stockprice.setExchangeName(stockExchangeOptional.get().getName());
            else
                return new ArrayList<>();
            stockprice.setCurrentPrice((float)row.getCell(2).getNumericCellValue());
            stockprice.setDate(row.getCell(3).getDateCellValue());
            stockprice.setTime((Time) row.getCell(4).getDateCellValue());
            stockRepository.save(stockprice);
            //stockPrice.add(stockMapper.map(stock,StockPrice.class));
        }
        return stockPrices;
    }
}
