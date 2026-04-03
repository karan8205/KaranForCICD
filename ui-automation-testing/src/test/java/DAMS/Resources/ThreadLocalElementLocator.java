package DAMS.Resources;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.Annotations;
import org.openqa.selenium.By;
import java.lang.reflect.Field;
import java.util.List;

public class ThreadLocalElementLocator implements ElementLocator {
    private final By by;

    public ThreadLocalElementLocator(Field field) {
        Annotations annotations = new Annotations(field);
        this.by = annotations.buildBy();
    }

    @Override
    public WebElement findElement() {
        return BaseClass.getDriver().findElement(by);
    }

    @Override
    public List<WebElement> findElements() {
        return BaseClass.getDriver().findElements(by);
    }
}
