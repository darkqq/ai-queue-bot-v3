package com.ai.queue.sec.temp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wrapper implements WrapperModel {
    private Object data;

    @SneakyThrows
    @Override
    public void setData(Object object) {
        data = object;
    }

}