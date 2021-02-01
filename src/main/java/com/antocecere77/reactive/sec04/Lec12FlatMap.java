package com.antocecere77.reactive.sec04;

import com.antocecere77.reactive.courseutil.Util;
import com.antocecere77.reactive.sec04.helper.OrderService;
import com.antocecere77.reactive.sec04.helper.UserService;

public class Lec12FlatMap {

    public static void main(String[] args) {

        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }
}
