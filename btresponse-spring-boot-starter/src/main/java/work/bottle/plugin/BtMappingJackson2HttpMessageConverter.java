package work.bottle.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class BtMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    private static final Logger logger = LoggerFactory.getLogger(BtMappingJackson2HttpMessageConverter.class);

    public BtMappingJackson2HttpMessageConverter( ) {
        super();
    }

    // 这里不处理请求参数, 只处理返回值
    @Override
    protected boolean canRead(MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {

        logger.debug("BtMappingJackson2HttpMessageConverter::canWrite({}, {})", clazz, mediaType);

        // return Object.class != clazz ? super.canWrite(clazz, mediaType) : true;
        return true;
    }
}
