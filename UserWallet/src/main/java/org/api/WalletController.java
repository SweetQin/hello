package org.api;

import org.service.WalletService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @since: 2023/3/2 19:17
 * @author: tianqin
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {
    /**
     * 业务背景：电商业务中，需要给电商app设计一个用户钱包，用户可以往钱包中充值，购买商品时用户可以使用钱包中的钱消费，商品申请退款成功后钱会退回
     * 钱包中，用户也可以申请提现把钱提到银行卡中
     * 用程序实现如下api接口
     *  1.  查询用户钱包余额
     * 2. 用户消费100元的接口
     * 3. 用户退款20元接口
     * 4. 查询用户钱包金额变动明细的接口
     *
     * 代码比较简洁，只是写了我的一个大概思路，如果有明显的遗漏之处，希望大佬帮我指出，谢谢~~
     */
    @Resource
    public WalletService service;

    //1.  查询用户钱包余额
    @GetMapping("/queryBalance")
    public Map<String, Object> queryBalance(
            @RequestParam(name = "userId") String userId
    ) {
        return service.queryBalance(userId);
    }

    //用户钱包操作接口
    @PostMapping("/walletChange")
    public Map<String, Object> walletChange(
            @RequestBody Map<String, Object> walletChangeObject
    ) {
        return service.walletChange(walletChangeObject);
    }

    //用户钱包明细查询接口
    @GetMapping("/walletChangeDetail")
    public Map<String, Object> walletChangeDetail(
            @RequestParam(name = "userId") String userId,
            @RequestParam(name = "startTime") long startTime,
            @RequestParam(name = "endTime") long endTime,
            @RequestParam(name = "limit") int limit,
            @RequestParam(name = "offset") int offset
    ) {
        return service.walletChangeDetail(userId,startTime, endTime, limit, offset);
    }
}
