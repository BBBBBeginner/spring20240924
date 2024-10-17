package core.app9;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class Comp1 {
    private Comp2 comp2;

    // 생성자 주입
    @Autowired
    public Comp1(Comp2 comp2) {
        this.comp2 = comp2;
    }
}