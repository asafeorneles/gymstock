package com.asafeorneles.gym_stock_control.services;

import com.asafeorneles.gym_stock_control.dtos.ProductInventory.PatchProductInventoryLowStockThreshold;
import com.asafeorneles.gym_stock_control.dtos.ProductInventory.PatchProductInventoryQuantity;
import com.asafeorneles.gym_stock_control.dtos.ProductInventory.ResponseProductInventory;
import com.asafeorneles.gym_stock_control.entities.Category;
import com.asafeorneles.gym_stock_control.entities.Product;
import com.asafeorneles.gym_stock_control.entities.ProductInventory;
import com.asafeorneles.gym_stock_control.repositories.ProductInventoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.ErrorResponseException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductInventoryServiceTest {

    @Mock
    ProductInventoryRepository productInventoryRepository;

    @InjectMocks
    ProductInventoryService productInventoryService;

    private Category category;
    private Product product;
    private  ProductInventory productInventory;
    private PatchProductInventoryQuantity patchProductInventoryQuantity;
    private PatchProductInventoryLowStockThreshold patchProductInventoryLowStockThreshold;

    @Captor
    ArgumentCaptor<ProductInventory> productInventoryArgumentCaptor;

    @BeforeEach
    void setUp() {
        category = Category.builder()
                .categoryId(UUID.randomUUID())
                .name("Suplementos")
                .description("Alimento em pó para maior eficiência")
                .build();

        product = Product.builder()
                .productId(UUID.randomUUID())
                .name("Hipercalórico")
                .brand("Growth")
                .price(BigDecimal.valueOf(100.99))
                .costPrice(BigDecimal.valueOf(69.99))
                .category(category)
                .build();

        productInventory = ProductInventory.builder()
                .productInventoryId(product.getProductId())
                .product(product)
                .quantity(10)
                .lowStockThreshold(5)
                .build();

        patchProductInventoryQuantity = new PatchProductInventoryQuantity(25);
        patchProductInventoryLowStockThreshold = new PatchProductInventoryLowStockThreshold(7);

    }

    @Nested
    class findProducts{
        @Test
        void shouldFindProductsInventoriesWithSuccessfully(){
            // ARRANGE
            when(productInventoryRepository.findAll()).thenReturn(List.of(productInventory));

            //ACT
            List<ResponseProductInventory> inventoriesFound = productInventoryService.findProductsInventories();

            //ASSERT
            assertNotNull(inventoriesFound);
            assertEquals(1, inventoriesFound.size());
            assertEquals(productInventory.getProductInventoryId(), inventoriesFound.get(0).productId());
        }

        @Test
        void shouldThrowExceptionWhenProductsInventoriesIsNotFound(){
            // ARRANGE
            when(productInventoryRepository.findAll()).thenReturn(List.of());

            // ASSERT
            assertThrows(ErrorResponseException.class, ()-> productInventoryService.findProductsInventories());
            verify(productInventoryRepository, times(1)).findAll();
        }
    }

    @Nested
    class updateQuantity{
        @Test
        void shouldUpdateQuantityOfInventorySuccessfully(){
            // ARRANGE
            when(productInventoryRepository.findById(productInventory.getProductInventoryId())).thenReturn(Optional.of(productInventory));
            when(productInventoryRepository.save(any(ProductInventory.class))).thenReturn(productInventory);

            //ACT
            ResponseProductInventory responseProductInventory = productInventoryService.updateQuantity(productInventory.getProductInventoryId(), patchProductInventoryQuantity);

            //ASSERT
            verify(productInventoryRepository, times(1)).findById(productInventory.getProductInventoryId());
            verify(productInventoryRepository).save(productInventoryArgumentCaptor.capture());
            ProductInventory inventoryCaptured = productInventoryArgumentCaptor.getValue();

            // PatchProductInventoryQuantity -> inventorySaved
            assertEquals(patchProductInventoryQuantity.quantity(), inventoryCaptured.getQuantity());

            // PatchProductInventoryQuantity -> ResponseProductInventory
            assertEquals(patchProductInventoryQuantity.quantity(), responseProductInventory.quantity());
        }

        @Test
        void shouldThrowExceptionWhenProductsInventoriesQuantityIsNotUpdated(){
            // ARRANGE
            when(productInventoryRepository.findById(productInventory.getProductInventoryId())).thenReturn(Optional.of(productInventory));
            when(productInventoryRepository.save(any(ProductInventory.class))).thenThrow(new RuntimeException());

            // ASSERT
            assertThrows(RuntimeException.class, ()-> productInventoryService.updateQuantity(productInventory.getProductInventoryId(), patchProductInventoryQuantity));
            verify(productInventoryRepository, times(1)).save(any(ProductInventory.class));
        }
    }

    @Nested
    class updateLowStockThreshold{
        @Test
        void shouldUpdateLowStockThresholdOfInventorySuccessfully(){
            // ARRANGE
            when(productInventoryRepository.findById(productInventory.getProductInventoryId())).thenReturn(Optional.of(productInventory));
            when(productInventoryRepository.save(any(ProductInventory.class))).thenReturn(productInventory);

            //ACT
            ResponseProductInventory responseProductInventory = productInventoryService.updateLowStockThreshold(productInventory.getProductInventoryId(), patchProductInventoryLowStockThreshold);

            //ASSERT
            verify(productInventoryRepository, times(1)).findById(productInventory.getProductInventoryId());
            verify(productInventoryRepository).save(productInventoryArgumentCaptor.capture());
            ProductInventory inventoryCaptured = productInventoryArgumentCaptor.getValue();

            // PatchProductInventoryQuantity -> inventorySaved
            assertEquals(patchProductInventoryLowStockThreshold.lowStockThreshold(), inventoryCaptured.getLowStockThreshold());

            // PatchProductInventoryQuantity -> ResponseProductInventory
            assertEquals(patchProductInventoryLowStockThreshold.lowStockThreshold(), responseProductInventory.lowStockThreshold());
        }

        @Test
        void shouldThrowExceptionWhenProductsInventoriesLowStockThresholdIsNotUpdated(){
            // ARRANGE
            when(productInventoryRepository.findById(productInventory.getProductInventoryId())).thenReturn(Optional.of(productInventory));
            when(productInventoryRepository.save(any(ProductInventory.class))).thenThrow(new RuntimeException());

            // ASSERT
            assertThrows(RuntimeException.class, ()-> productInventoryService.updateLowStockThreshold(productInventory.getProductInventoryId(), patchProductInventoryLowStockThreshold));
            verify(productInventoryRepository, times(1)).save(any(ProductInventory.class));
        }
    }
}