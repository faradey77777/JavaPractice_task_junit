import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import ua.skillsup.practice.dao.ExampleDao;
import ua.skillsup.practice.dao.ImplementDao;
import ua.skillsup.practice.entity.ExampleEntity;
import ua.skillsup.practice.service.ExampleService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import ua.skillsup.practice.service.ImplementServ;

import java.math.BigDecimal;

public class ImplementServTest {
    private ExampleDao exampleDao = Mockito.mock(ExampleDao.class);
    private ImplementServ implementServ =  new ImplementServ(exampleDao);
    @Test
    public void test_save_examentity_into_store(String title, BigDecimal price) throws Exception {
        //Given
        Mockito.when(exampleDao.store(any(ExampleEntity.class))).thenReturn(true);

        //When
        implementServ.addNewItem(title,price);

        // Then
        ExampleEntity exampleEntity = new ExampleEntity();
        verify(exampleDao).store(exampleEntity);
    }

}