package com.artcode.artcode.util;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("HeavyResource")
@Lazy // by default IoC will create an object from each @Component but if we annotate it with @Lazy
public class HeavyResource {
    public HeavyResource() {
        System.out.println("Heavy Resource is created!");
    }

}
