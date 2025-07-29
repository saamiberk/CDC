package com.hititcs.jet.cdc.mapper.record.value;

import com.hazelcast.function.FunctionEx;
import com.hazelcast.enterprise.jet.cdc.ChangeRecord;
import com.hititcs.jet.cdc.config.CacheConstants;
import com.hititcs.jet.cdc.record.FlightSegment;
import com.hititcs.jet.cdc.record.Inventory;

import java.io.Serializable;
import java.time.LocalDateTime;

import static com.hititcs.DebeziumStarter.hz;

public class InventoryValueMapper implements FunctionEx<ChangeRecord, Inventory>, Serializable {

    @Override
    public Inventory applyEx(ChangeRecord record) {
        try {
            return record.value().toObject(Inventory.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // filtreye takıldıysa yazma
    }

    boolean filter(Inventory inventory) {
        if (inventory == null || inventory.getSegIsn() == null) {
            return false;
        }
        FlightSegment segment = (FlightSegment) hz.getMap(CacheConstants.CACHE_NAME_FLT_SEGMENT)
                .get(inventory.getSegIsn());
        if (segment == null) {
            return false;
        }
        return segment.getSchDepDt().isAfter(LocalDateTime.now());
    }
}