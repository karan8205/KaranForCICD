package DAMS.Resources;

import java.lang.reflect.Field;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

public class ThreadLocalElementLocatorFactory implements ElementLocatorFactory {
    @Override
    public ElementLocator createLocator(Field field) {
        return new ThreadLocalElementLocator(field);
    }
}
