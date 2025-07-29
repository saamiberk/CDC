package com.hititcs.jet.cdc.mapper.record.key;

import com.hazelcast.function.FunctionEx;
import com.hazelcast.enterprise.jet.cdc.ChangeRecord;

import java.io.Serializable;
import java.util.Map;

public class InventoryKeyMapper implements FunctionEx<ChangeRecord, String>, Serializable {

    @Override
    public String applyEx(ChangeRecord r) {
        Map<String, Object> keyMap = r.key().toMap();
        return keyMap.get("SEG_ISN") + "#" + keyMap.get("REZ_CLASS");
    }
}