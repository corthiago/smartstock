package com.thiago.smartstock.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.thiago.smartstock.domain.CsvStockItem;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ReportService {

    public List<CsvStockItem> readStockReport(String reportPath) throws IOException {

        try (Reader reader = Files.newBufferedReader(Paths.get(reportPath))){

            var builder = new CsvToBeanBuilder<CsvStockItem>(reader)
                    .withType(CsvStockItem.class)
                    .build();

            return builder.parse();

        }

    }
}
