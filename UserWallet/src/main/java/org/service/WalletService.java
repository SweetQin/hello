package org.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @since: 2023/3/2 19:36
 * @author: tianqin
 */
@Service
public class WalletService {

    // 返回的结构体可以根据业务要求进行专门设计，用map是为了方便


    public Map<String, Object> queryBalance(String userId) {
        return new HashMap<>() {{
            put("userId", "用户id");
            put("balance", "余额查询-- 通过userid在用户钱包表进行余额查询");

        }};
    }

    public Map<String, Object> walletChange(Map<String, Object> walletChangeObject) {
        /**
         * walletChangeObject必须具备的参数为 -- {
         *      userId: 用户id
         *      type: 0-充值/1-消费/2-退款
         *      amount_consumption: 变动金额
         * }
         *
         */
        return new HashMap<>(){{
            put("userId", "用户id");
            put("success", updateWallet(walletChangeObject));
            put("message", "如果操作失败则说明原因，成功则不填充这个字段");
        }};
    }

    private boolean updateWallet(Map<String, Object> walletChangeObject) {
        /**
         * 如果是充值，那么需要先收到用户的付款，不管是微信支付/支付宝支付还是银联支付，我们首先要
         * 根据请求携带的金额大小参数去发起用户支付请求，微信支付是调用支付接口的时候需要提供一个回调地址
         * 作为入参，作为后续支付结果的确认，支付宝和银联的应该也是类似，先将数据写入历史表(数据状态设置
         * 为未生效)，在确认支付结果之后，再将历史表数据状态字段设置为生效，且更新用户钱包表
         *
         * 如果是消费，那么直接与用户钱包表进行比对，合法则进行数据的更改
         *
         * 如果是退款，同样是先判断数据的合法性，然后发起退款请求，确认退款结果
         */
        return true;
    }

    public Map<String, Object> walletChangeDetail(String userId, long startTime, long endTime, int limit, int offset) {
        return new HashMap<>(){{
            put("userId", "用户id");
            put("walletChangeDetails", "账户变更明细,在历史表进行查询，如果业务需要还可以根据消费类型进行查询");
        }};
    }
}
