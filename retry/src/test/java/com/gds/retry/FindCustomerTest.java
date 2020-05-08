package com.gds.retry;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author zhanglifeng
 * @since 2020-05-08 16:45
 */
public class FindCustomerTest {

    @Test
    public void resultAfterExceptions() throws Exception {
        final FindCustomer op = new FindCustomer(
                "123",
                new CustomerNotFoundException("not found"),
                new DatabaseNotAvailableException("not available")
        );
        try {
            op.perform();
        } catch (CustomerNotFoundException e) {
            //ignore
            System.out.println("CustomerNotFoundException");
        }
        try {
            op.perform();
        } catch (DatabaseNotAvailableException e) {
            //ignore
            System.out.println("DatabaseNotAvailableException");
        }

        assertThat(op.perform(), is("123"));
    }
}