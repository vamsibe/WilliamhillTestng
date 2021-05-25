package com.wipro.willhills.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "getDataFromXL")
    public static Object[][] getTestDataFromXL(Method m) {

        return DataUtils.getData(m.getName().substring(0, 1).toUpperCase() + m.getName().substring(1),
                new ReadXlsFile(System.getProperty("user.dir") + "/src/main/resources/join.xlsx"));

    }

    @DataProvider(name = "getDataFromJson")
    public static Object[] getTestDataFromJson(Method m) throws IOException {
        ObjectMapper mapper1 = new ObjectMapper();

        // convert JSON file to map
        System.out.println(m.getName());
        Map<String, Map<String, Object>> map1 = mapper1.readValue(Paths.get(System.getProperty("user.dir") +
                "/src/main/resources/join.json").toFile(), Map.class);
        List<Map<String, Object>> result1 = new ArrayList<>();

        Iterator<Object> it = map1.get("joinTestUsingDataFromJson").values().iterator();
        while (it.hasNext()) {
            result1.add((Map<String, Object>) it.next());
        }

        Object testData[] = new Object[result1.size()];
        for (int i = 0; i < result1.size(); i++) {
            testData[i] = result1.get(i);
        }
        return testData;
    }
}
