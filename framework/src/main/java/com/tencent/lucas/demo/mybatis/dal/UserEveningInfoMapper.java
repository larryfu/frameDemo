package com.tencent.lucas.demo.mybatis.dal;

import org.apache.ibatis.annotations.Param;

/**
 * Created by lucasfu on 2016/12/29.
 */
public interface UserEveningInfoMapper {

    void insertUserInfo(@Param("uin") long uin, @Param("freeGift") int freeGift);

    void updateFreeGift(@Param("round") int round, @Param("uin") long uin, @Param("freeGift") int freeGift);

    void updateChargeGift(@Param("round") int round, @Param("uin") long uin, @Param("chargeGift") int chargeGift);

    void setUserAward(@Param("round") int round, @Param("uin") long uin, @Param("award") String award, @Param("qb") int qb);

    void updateGrantStatus(@Param("round") int round, @Param("status") int status);
}
