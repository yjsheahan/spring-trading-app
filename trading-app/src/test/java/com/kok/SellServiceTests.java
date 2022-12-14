package com.kok;

import com.kok.entities.Transaction;
import com.kok.repositories.SellRepository;
import com.kok.services.SellServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SellServiceTests {
    @Mock
    private SellRepository sellRepository;

    @InjectMocks
    private SellServiceImpl sellServiceImpl;
    @Test
    public void addSellTransaction(){
        // Given
        Transaction t = new Transaction();
        String nasdaq = "AAPL";
        // When
        when(sellRepository.save(t)).thenReturn(t);
        // Then
        assertEquals(this.sellServiceImpl.createAsk(t, nasdaq), t);

    }
}
