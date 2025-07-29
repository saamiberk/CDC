package com.hititcs.jet.cdc.mapper.record.key;

import com.hazelcast.enterprise.jet.cdc.ChangeRecord;
import com.hazelcast.function.FunctionEx;

import java.io.Serializable;

public class FlightSegmentKeyMapper implements FunctionEx<ChangeRecord, Long>, Serializable {

    @Override
    public Long applyEx(ChangeRecord r) {
        return Long.valueOf(r.key().toMap().get("SEG_ISN").toString());
    }

}