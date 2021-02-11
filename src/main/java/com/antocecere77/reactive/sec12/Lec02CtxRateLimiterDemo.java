package com.antocecere77.reactive.sec12;

import com.antocecere77.reactive.courseutil.Util;
import com.antocecere77.reactive.sec12.helper.BookService;
import com.antocecere77.reactive.sec12.helper.UserService;
import reactor.util.context.Context;

public class Lec02CtxRateLimiterDemo {

    public static void main(String[] args) {

        BookService
                .getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user", "sam"))
                .subscribe(Util.subscriber());
    }
}
