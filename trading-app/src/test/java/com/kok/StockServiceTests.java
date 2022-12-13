package com.kok;

import com.kok.entities.Stock;
import com.kok.repositories.StockRepository;
import com.kok.services.StockServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StockServiceTests {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockServiceImpl;
    private final List<Stock> stocks = Arrays.asList(
            new Stock("Tesla", "TSLA", 179.05),
            new Stock("Apple Inc.", "AAPL", 142.16),
            new Stock("Amazon.com, Inc.", "AMZN", 89.09),
            new Stock("Alphabet Inc.", "GOOGL", 92.83),
            new Stock("Microsoft Corporation Common Stock", "MSFT", 245.42)
    );

    @DisplayName("Displays list of all stocks.")
    @Test
    public void getAllStocks(){
        // Given

        // When
        when(stockRepository.findAll()).thenReturn(this.stocks);
        // Then
        assertEquals(stockRepository.findAll().size(), 5);
    }

    @DisplayName("Get stock by NASDAQ.")
    @Test
    public void getStockByNasdaq(){
        // Given
        Stock s1 = new Stock("Tesla", "TSLA", 189.90);
        // When
        when(stockRepository.getByNasdaq(s1.getNasdaq())).thenReturn(s1);
        // Then
        assertEquals(stockRepository.getByNasdaq("TSLA"), s1);
    }

    @DisplayName("Get stock by name.")
    @Test
    public void getStockByStockName(){
        // Given
        Stock s1 = new Stock("Tesla", "TSLA", 189.90);
        // When
        when(stockRepository.getByStockName(s1.getStockName())).thenReturn(s1);
        // Then
        assertEquals(stockRepository.getByStockName("Tesla"), s1);
    }
}
