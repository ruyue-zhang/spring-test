package com.thoughtworks.rslist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private int amount;
    private int rank;
    private int rsEventId;

    public Trade(int amount, int rank) {
        this.amount = amount;
        this.rank = rank;
    }
}
