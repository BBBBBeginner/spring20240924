package core.app10;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Component1 {
    private Component2 component2;

    public Component1(Component2 component2) {
        this.component2 = component2;
    }
}
