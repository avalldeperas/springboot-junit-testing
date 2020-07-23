package com.avalldeperas.springbootjunittesting.unittesting.spike;

import com.avalldeperas.springbootjunittesting.unittesting.model.Item;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JsonPath allows you to do queries on a given JSON, which will be converted as a DocumentContext.
 */
@Slf4j
public class JsonPathTest {

    @Test
    public void learning() {
        String responseFromService = "[" +
                "{\"id\": 10000, \"name\": \"Pencil\", \"quantity\": 5}," +
                "{\"id\": 10001, \"name\": \"Pen\", \"quantity\": 15}," +
                "{\"id\": 10002, \"name\": \"Eraser\", \"quantity\": 10}" +
                "]";

        DocumentContext context = JsonPath.parse(responseFromService);
        int length = context.read("$.length()");
        assertThat(length).isEqualTo(3);

        List<Integer> ids = context.read("$..id");
        assertThat(ids).containsExactly(10000,10001,10002)
                .startsWith(10000)
                .endsWith(10002);

        log.info(context.read("$.[0:2]").toString()); // [0:x] where x is exclusive
        log.info(context.read("$.[?(@.name=='Pencil')]").toString()); // [0:x] where x is exclusive
        log.info(context.read("$.[?(@.quantity == 5)]").toString()); // [0:x] where x is exclusive

    }
}
