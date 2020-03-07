package com.incompetent.tester.automation.selenium.ide.commands;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Command {
    private String id;
    private String comment;
    private String target;
    private String value;
    private String[][] targets;
}
