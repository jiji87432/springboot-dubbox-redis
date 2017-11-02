package cn.zhangxd.platform.system.provider.serviceimpl;

import cn.zhangxd.platform.system.api.service.ICurrencyRateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 汇率服务
 *
 * @author zhangxd
 */
@Service
@Transactional(readOnly = true)
public class CurrencyRateService implements ICurrencyRateService {
    @Override
    public Map<String, String> getRate() {
        return null;
    }

    /**
     * yahoo 汇率服务
     */
    // @Autowired
    // private YahooRateService yahooRateService;
    //
    // @Override
    // public Map<String, String> getRate() {
    //     return yahooRateService.get();
    // }
}
