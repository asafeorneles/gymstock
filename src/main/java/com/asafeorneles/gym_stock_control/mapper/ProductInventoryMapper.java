package com.asafeorneles.gym_stock_control.mapper;

import com.asafeorneles.gym_stock_control.dtos.ProductInventory.PatchProductInventoryQuantity;
import com.asafeorneles.gym_stock_control.dtos.ProductInventory.ResponseProductInventory;
import com.asafeorneles.gym_stock_control.entities.ProductInventory;

public class ProductInventoryMapper {

    public static ResponseProductInventory productInventoryToResponseProductInventory(ProductInventory productInventory){
        return new ResponseProductInventory(
                productInventory.getProductInventoryId(),
                productInventory.getQuantity(),
                productInventory.getLowStockThreshold()
        );
    }

    public static void patchProductInventoryQuantity(ProductInventory productInventory, PatchProductInventoryQuantity patchProductInventoryQuantity){
        productInventory.setQuantity(patchProductInventoryQuantity.quantity());
    }
}
