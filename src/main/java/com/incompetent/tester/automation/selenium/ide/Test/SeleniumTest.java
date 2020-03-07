package com.incompetent.tester.automation.selenium.ide.Test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeleniumTest {
    private String testName;
    private String testUrl;
    private JSONArray testCommands;
}
