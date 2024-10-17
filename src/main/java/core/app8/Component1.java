package core.app8;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Component1 {
    private Component2 component2;

    @Autowired
    public Component2 Component2;


}
