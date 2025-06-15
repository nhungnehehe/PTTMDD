package com.phamtuyetnhung.connectors;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.phamtuyetnhung.models.OrderDetails;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsConnector {
        public List<OrderDetails> getOrderDetailsByOrderId(SQLiteDatabase db, int orderId) {
            List<OrderDetails> list = new ArrayList<>();
            String sql = "SELECT ProductId, Quantity, Price, Discount, VAT FROM OrderDetails WHERE OrderId = ?";
            Cursor c = db.rawQuery(sql, new String[]{ String.valueOf(orderId) });
            while (c.moveToNext()) {
                OrderDetails od = new OrderDetails();
                od.setOrderId(orderId);
                od.setProductId   (c.getInt   (0));
                od.setQuantity    (c.getInt   (1));
                od.setPrice       (c.getDouble(2));
                od.setDiscount    (c.getDouble(3));
                od.setVAT         (c.getDouble(4));
                // TotalValue tính trong getter
                list.add(od);
            }
            c.close();
            return list;
        }
    }
