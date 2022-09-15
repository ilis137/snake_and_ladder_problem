package com.practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SnakeAndLadder {

    private static final Logger LOG = LogManager.getLogger(SnakeAndLadder.class);

    public static void main(String[] args) {

        String message = "Hello , World";
        LOG.debug(message + " Will Be Printed On Debug ");
        LOG.info(message + " Will Be Printed On Info ");
        LOG.warn(message + "Will Be Printed On Warn ");
        LOG.error(message + " Will Be Printed On Error ");
        LOG.fatal(message + " Will Be Printed On Fatal ");
        LOG.info(" Appending string : {}. ", message);
        System.out.println(message);
    }
}