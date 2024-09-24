package dev.aq.cache.library.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class CacheConfig {

    @Bean
    CacheManagerCustomizer<ConcurrentMapCacheManager> cacheManagerCustomizer(){
        return new ConcurrentCustomizer();
    }

    static class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>{

        @Override
        public void customize(ConcurrentMapCacheManager cacheManager) {
            cacheManager.setAllowNullValues(false);
            //cacheManager.setStoreByValue(true);
            log.info("customizer invoked!!");
        }
    }
}
